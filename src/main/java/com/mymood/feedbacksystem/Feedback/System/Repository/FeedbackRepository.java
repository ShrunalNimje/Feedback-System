package com.mymood.feedbacksystem.Feedback.System.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mymood.feedbacksystem.Feedback.System.Entity.FeedbackEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.StudentEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.SubjectEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.TeacherEntity;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Long>{

	Optional<FeedbackEntity> findByStudentAndTeacherAndSubjectAndSemester(
			StudentEntity student, TeacherEntity teacher, SubjectEntity subject, Integer semester);

	List<FeedbackEntity> findByStudent_StudentId(Long studentId);
	
    List<FeedbackEntity> findByTeacher_TeacherId(Long teacherId);
    
    List<FeedbackEntity> findBySubject_SubjectId(Long subjectId);
	
}
