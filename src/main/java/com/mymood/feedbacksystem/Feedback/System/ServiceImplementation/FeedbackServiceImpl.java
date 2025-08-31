package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.FeedbackRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.FeedbackResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.FeedbackEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.StudentEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.SubjectEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.TeacherEntity;
import com.mymood.feedbacksystem.Feedback.System.Repository.FeedbackRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.StudentRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.SubjectRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.TeacherRepository;
import com.mymood.feedbacksystem.Feedback.System.Service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	FeedbackRepository feedbackRepository;
    
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
    TeacherRepository teacherRepository;
	
	@Autowired
    SubjectRepository subjectRepository;
	
	private static final float MIN_ATTENDANCE = 75.0f;
	
	private static final double MIN_LAT = 21.090;
    private static final double MAX_LAT = 21.110;
    private static final double MIN_LONG = 79.010;
    private static final double MAX_LONG = 79.030;
    
	@Override
	public FeedbackResponseDTO submitFeedback(FeedbackRequestDTO submit) {
		
        StudentEntity student = studentRepository.findById(submit.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found!"));

        TeacherEntity teacher = teacherRepository.findById(submit.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found!"));

        SubjectEntity subject = subjectRepository.findById(submit.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        if (student.getAttendancePercentage() < MIN_ATTENDANCE) {
            throw new RuntimeException("Student attendance below required threshold!");
        }

        if (submit.getLatitude() < MIN_LAT || submit.getLatitude() > MAX_LAT
                || submit.getLongitude() < MIN_LONG || submit.getLongitude() > MAX_LONG) {
            throw new RuntimeException("Feedback can only be submitted inside college premises!");
        }

        Optional<FeedbackEntity> existing = feedbackRepository.findByStudentAndTeacherAndSubjectAndSemester(
                student, teacher, subject, submit.getSemester());
        
        if (existing.isPresent()) {
            throw new RuntimeException("Feedback already submitted for this subject and teacher!");
        }

        FeedbackEntity entity = new FeedbackEntity();
        entity.setStudent(student);
        entity.setTeacher(teacher);
        entity.setSubject(subject);
        entity.setSemester(submit.getSemester());
        entity.setLatitude(submit.getLatitude());
        entity.setLongitude(submit.getLongitude());
        entity.setQuestion1_rating(submit.getQuestion1Rating());
        entity.setQuestion2_rating(submit.getQuestion2Rating());
        entity.setQuestion3_rating(submit.getQuestion3Rating());
        entity.setQuestion4_rating(submit.getQuestion4Rating());
        entity.setQuestion5_rating(submit.getQuestion5Rating());

        FeedbackEntity saved = feedbackRepository.save(entity);

        return new FeedbackResponseDTO(
                saved.getFeedbackId(),
                saved.getStudent().getName(),
                saved.getTeacher().getName(),
                saved.getSubject().getName(),
                saved.getSemester(),
                saved.getSubmittedAt());
	}

	@Override
	public List<FeedbackResponseDTO> getFeedbackByStudent(Long studentId) {
	    
		studentRepository.findById(studentId)
	            .orElseThrow(() -> new RuntimeException("Student not found!"));

	    return feedbackRepository.findByStudent_StudentId(studentId)
	            .stream()
	            .map(feedback -> new FeedbackResponseDTO(
	                    feedback.getFeedbackId(),
	                    feedback.getStudent().getName(),
	                    feedback.getTeacher().getName(),
	                    feedback.getSubject().getName(),
	                    feedback.getSemester(),
	                    feedback.getSubmittedAt()))
	            .collect(Collectors.toList());
	}

	@Override
	public List<FeedbackResponseDTO> getFeedbackByTeacher(Long teacherId) {
		
		teacherRepository.findById(teacherId).orElseThrow(
				() -> new RuntimeException("Teacher not found!"));
		
		return feedbackRepository.findByTeacher_TeacherId(teacherId)
                .stream()
                .map(feedback -> new FeedbackResponseDTO(
                		feedback.getFeedbackId(),
                		feedback.getStudent().getName(),
                		feedback.getTeacher().getName(),
                		feedback.getSubject().getName(),
                		feedback.getSemester(),
                		feedback.getSubmittedAt()))
                .collect(Collectors.toList());
	}

	@Override
	public List<FeedbackResponseDTO> getFeedbackBySubject(Long subjectId) {
		
		subjectRepository.findById(subjectId).orElseThrow(
				() -> new RuntimeException("Subject not found!"));

		return feedbackRepository.findBySubject_SubjectId(subjectId)
                .stream()
                .map(feedback -> new FeedbackResponseDTO(
                		feedback.getFeedbackId(),
                		feedback.getStudent().getName(),
                		feedback.getTeacher().getName(),
                		feedback.getSubject().getName(),
                		feedback.getSemester(),
                		feedback.getSubmittedAt()))
                .collect(Collectors.toList());
	}

}
