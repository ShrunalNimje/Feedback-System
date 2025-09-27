package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.FeedbackRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.AnonymousFeedbackResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.FeedbackEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.StudentEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.SubjectEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.TeacherEntity;
import com.mymood.feedbacksystem.Feedback.System.Enum.Role;
import com.mymood.feedbacksystem.Feedback.System.Location.GeoUtils;
import com.mymood.feedbacksystem.Feedback.System.Repository.FeedbackRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.StudentRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.SubjectRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.TeacherRepository;
import com.mymood.feedbacksystem.Feedback.System.Service.FeedbackService;

import io.jsonwebtoken.lang.Collections;

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
    
	@Override
	public AnonymousFeedbackResponseDTO submitFeedback(FeedbackRequestDTO submit) {
		
        StudentEntity student = studentRepository.findById(submit.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found!"));

        TeacherEntity teacher = teacherRepository.findById(submit.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found!"));

        SubjectEntity subject = subjectRepository.findById(submit.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        if (student.getAttendancePercentage() < MIN_ATTENDANCE) {
            throw new RuntimeException("Student attendance below required threshold!");
        }

        double collegeLat = 21.105260;
        double collegeLng = 79.003490;
        
        double distance = GeoUtils.calculateDistance(
        		submit.getLatitude(), submit.getLongitude(), collegeLat, collegeLng);

        if (distance > 0.5) {
            throw new RuntimeException("Feedback can only be submitted from within college premises.");
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

        return new AnonymousFeedbackResponseDTO(
                saved.getFeedbackId(),
                saved.getTeacher().getName(),
                saved.getSubject().getName(),
                saved.getSemester(),
                saved.getSubmittedAt());
	}

	@Override
	public List<AnonymousFeedbackResponseDTO> getFeedbackByStudent(Long studentId, Long loggedInUserId, String roleStr) {
	    
		Role role = Role.valueOf(roleStr);
		
		studentRepository.findById(studentId)
	            .orElseThrow(() -> new RuntimeException("Student not found!"));

	    List<FeedbackEntity> feedbacks = feedbackRepository.findByStudent_StudentId(studentId);
	    
	    if (role == Role.TEACHER) {
	        feedbacks = feedbacks.stream()
	                .filter(f -> f.getTeacher().getUser().getUserId().equals(loggedInUserId))
	                .collect(Collectors.toList());
	    }
	    
	    return feedbacks.stream()
	            .map(feedback -> new AnonymousFeedbackResponseDTO(
	                    feedback.getFeedbackId(),
	                    feedback.getTeacher().getName(),
	                    feedback.getSubject().getName(),
	                    feedback.getSemester(),
	                    feedback.getSubmittedAt()))
	            .collect(Collectors.toList());
	}

	@Override
	public List<AnonymousFeedbackResponseDTO> getFeedbackByTeacher(Long teacherId, 
			Long loggedInUserId, String roleStr) {
		
		Role role = Role.valueOf(roleStr);

	    TeacherEntity teacher = teacherRepository.findById(teacherId)
	            .orElseThrow(() -> new RuntimeException("Teacher not found!"));

	    List<FeedbackEntity> feedbacks = feedbackRepository.findByTeacher_TeacherId(teacherId);

	    if (role == Role.TEACHER) {
	        if (!teacher.getUser().getUserId().equals(loggedInUserId)) {
	            feedbacks = Collections.emptyList();
	        }
	    }
		
		return feedbacks.stream()
                .map(feedback -> new AnonymousFeedbackResponseDTO(
                		feedback.getFeedbackId(),
                		feedback.getTeacher().getName(),
                		feedback.getSubject().getName(),
                		feedback.getSemester(),
                		feedback.getSubmittedAt()))
                .collect(Collectors.toList());
	}

	@Override
	public List<AnonymousFeedbackResponseDTO> getFeedbackBySubject(Long subjectId, Long loggedInUserId, String roleStr) {
		
		Role role = Role.valueOf(roleStr);
		
		subjectRepository.findById(subjectId)
        .orElseThrow(() -> new RuntimeException("Subject not found!"));

		List<FeedbackEntity> feedbackList;
		
		if (role == Role.TEACHER) {
		    feedbackList = feedbackRepository.findBySubject_SubjectIdAndTeacher_User_UserId(subjectId, loggedInUserId);
		}
		else {
		    feedbackList = feedbackRepository.findBySubject_SubjectId(subjectId);
		}
		
		subjectRepository.findById(subjectId).orElseThrow(
				() -> new RuntimeException("Subject not found!"));

		return feedbackList.stream()
                .map(feedback -> new AnonymousFeedbackResponseDTO(
                		feedback.getFeedbackId(),
                		feedback.getTeacher().getName(),
                		feedback.getSubject().getName(),
                		feedback.getSemester(),
                		feedback.getSubmittedAt()))
                .collect(Collectors.toList());
	}

}
