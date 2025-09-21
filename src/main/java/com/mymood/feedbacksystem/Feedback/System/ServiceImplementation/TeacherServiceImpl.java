package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mymood.feedbacksystem.Feedback.System.DTO.Analytics.AnalyticsResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Analytics.BatchAverageDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Analytics.QuestionAverageDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Analytics.SectionAverageDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Analytics.SubjectAnalyticsDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Request.TeacherRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.AnonymousFeedbackResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.SubmissionStatusDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.TeacherResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Update.TeacherUpdateDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.DepartmentEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.SubjectEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.TeacherEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.UserEntity;
import com.mymood.feedbacksystem.Feedback.System.Enum.Role;
import com.mymood.feedbacksystem.Feedback.System.Enum.SubjectType;
import com.mymood.feedbacksystem.Feedback.System.Repository.DepartmentRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.FeedbackRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.StudentRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.TeacherRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.TeacherSubjectAssignmentRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.UserRepository;
import com.mymood.feedbacksystem.Feedback.System.Service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
    private TeacherSubjectAssignmentRepository assignmentRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;
    
    @Autowired
    StudentRepository studentRepository;
    
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public TeacherResponseDTO createTeacher(TeacherRequestDTO create) {
		
		if(userRepository.existsByUsername(create.getEmail())) {
	        throw new RuntimeException("Email already in use!");
	    }
		
		DepartmentEntity department = departmentRepository.findById(create.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found!"));

		UserEntity user = new UserEntity();
		user.setPassword(passwordEncoder.encode(create.getPassword()));
		user.setUsername(create.getEmail());
		user.setRole(Role.TEACHER);
		userRepository.save(user);
		
        TeacherEntity teacher = new TeacherEntity();
        teacher.setName(create.getName());
        teacher.setEmail(create.getEmail());
        teacher.setDepartment(department);
        teacher.setUser(user);

        TeacherEntity saved = teacherRepository.save(teacher);
        return new TeacherResponseDTO(saved.getTeacherId(), saved.getName(), saved.getEmail(), 
        		saved.getDepartment().getName());
	}

	@Override
	public TeacherResponseDTO getTeacher(Long id) {
		
		TeacherEntity teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found!"));
		
        return new TeacherResponseDTO(teacher.getTeacherId(), teacher.getName(), teacher.getEmail(), 
        		teacher.getDepartment().getName());
	}

	@Override
	public List<TeacherResponseDTO> getAllTeacher() {
		
		return teacherRepository.findAll()
                .stream()
                .map(teacher -> new TeacherResponseDTO(
                		teacher.getTeacherId(),
                        teacher.getName(),
                        teacher.getEmail(),
                        teacher.getDepartment().getName()))
                .collect(Collectors.toList());
	}

	@Override
	public TeacherResponseDTO updateTeacher(Long id, TeacherUpdateDTO update) {
		
		TeacherEntity teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found!"));

		if(update.getName() != null) {
			teacher.setName(update.getName());
		}
        
		if(update.getEmail() != null) {
	        teacher.setEmail(update.getEmail());
		}
		
		if(update.getDepartmentId() != null) {
			DepartmentEntity department = departmentRepository.findById(update.getDepartmentId())
	                .orElseThrow(() -> new RuntimeException("Department not found!"));
	        
	        teacher.setDepartment(department);		
        }

        TeacherEntity saved = teacherRepository.save(teacher);
        
        return new TeacherResponseDTO(saved.getTeacherId(), saved.getName(), saved.getEmail(), 
        		saved.getDepartment().getName());
	}

	@Override
	public void deleteTeacher(Long id) {

		teacherRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Teacher not found!"));
		
		teacherRepository.deleteById(id);
	}

	@Override
    public AnalyticsResponseDTO getTeacherAnalytics(Long teacherId, Integer semester, Long subjectId, Integer year) {

        List<SubjectEntity> subjects = assignmentRepository.findSubjectsByTeacherId(teacherId);

        List<SubjectAnalyticsDTO> subjectAnalyticsList = new ArrayList<>();

        for (SubjectEntity subject : subjects) {
            if (subjectId != null && !subject.getSubjectId().equals(subjectId)) continue;

            List<SectionAverageDTO> sectionAverages = new ArrayList<>();
            List<BatchAverageDTO> batchAverages = new ArrayList<>();
            List<QuestionAverageDTO> questionAverages = new ArrayList<>();

            if (SubjectType.THEORY.equals(subject.getType())) {
                sectionAverages = feedbackRepository.findAverageBySection(subject.getSubjectId());
            } 
            
            else if (SubjectType.PRACTICAL.equals(subject.getType())) {
                batchAverages = feedbackRepository.findAverageByBatch(subject.getSubjectId());
            }

            questionAverages = feedbackRepository.findQuestionWiseAverage(subject.getSubjectId());

            SubjectAnalyticsDTO analyticsDTO = new SubjectAnalyticsDTO(
                    subject.getSubjectId(),
                    subject.getName(),
                    subject.getType(),
                    sectionAverages,
                    batchAverages,
                    questionAverages
            );

            subjectAnalyticsList.add(analyticsDTO);
        }

        return new AnalyticsResponseDTO(teacherId, subjectAnalyticsList);
    }
	
	@Override
	public List<AnonymousFeedbackResponseDTO> getAnonymousFeedback(Long teacherId, Long subjectId, Integer semester) {
	    return feedbackRepository.findAnonymousFeedback(subjectId, teacherId, semester);
	}
	
	@Override
	public List<SubmissionStatusDTO> getFeedbackSubmissionStatus(Long subjectId, Integer semester, Long batchId) {
	    return studentRepository.getFeedbackSubmissionStatus(subjectId, semester, batchId);
	}

}
