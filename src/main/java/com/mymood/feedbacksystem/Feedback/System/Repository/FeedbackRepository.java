package com.mymood.feedbacksystem.Feedback.System.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mymood.feedbacksystem.Feedback.System.DTO.Analytics.BatchAverageDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Analytics.QuestionAverageDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Analytics.SectionAverageDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.AnonymousFeedbackResponseDTO;
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
    
    List<FeedbackEntity> findBySubject_SubjectIdAndTeacher_User_UserId(Long subjectId, Long userId);

    
    @Query("SELECT new com.mymood.feedbacksystem.Feedback.System.DTO.Response.AnonymousFeedbackResponseDTO(" +
    	       "f.feedbackId, f.teacher.name, f.subject.name, f.semester, f.submittedAt) " +
    	       "FROM FeedbackEntity f " +
    	       "WHERE (:subjectId IS NULL OR f.subject.subjectId = :subjectId) " +
    	       "AND (:semester IS NULL OR f.semester = :semester)")
    	List<AnonymousFeedbackResponseDTO> findAnonymousFeedback(
    	       @Param("subjectId") Long subjectId,
    	       @Param("semester") Integer semester);

    @Query("""
    	       SELECT new com.mymood.feedbacksystem.Feedback.System.DTO.Analytics.QuestionAverageDTO('Question 1', AVG(f.question1_rating))
    	       FROM FeedbackEntity f
    	       WHERE f.subject.subjectId = :subjectId
    	       """)
    QuestionAverageDTO findAverageQuestion1(@Param("subjectId") Long subjectId);

	@Query("""
	       SELECT new com.mymood.feedbacksystem.Feedback.System.DTO.Analytics.QuestionAverageDTO('Question 2', AVG(f.question2_rating))
	       FROM FeedbackEntity f
	       WHERE f.subject.subjectId = :subjectId
	       """)
	QuestionAverageDTO findAverageQuestion2(@Param("subjectId") Long subjectId);
	
	@Query("""
		       SELECT new com.mymood.feedbacksystem.Feedback.System.DTO.Analytics.QuestionAverageDTO('Question 3', AVG(f.question3_rating))
		       FROM FeedbackEntity f
		       WHERE f.subject.subjectId = :subjectId
		       """)
	QuestionAverageDTO findAverageQuestion3(@Param("subjectId") Long subjectId);

	@Query("""
	       SELECT new com.mymood.feedbacksystem.Feedback.System.DTO.Analytics.QuestionAverageDTO('Question 4', AVG(f.question4_rating))
	       FROM FeedbackEntity f
	       WHERE f.subject.subjectId = :subjectId
	       """)
	QuestionAverageDTO findAverageQuestion4(@Param("subjectId") Long subjectId);

	@Query("""
		       SELECT new com.mymood.feedbacksystem.Feedback.System.DTO.Analytics.QuestionAverageDTO('Question 5', AVG(f.question5_rating))
		       FROM FeedbackEntity f
		       WHERE f.subject.subjectId = :subjectId
		       """)
	QuestionAverageDTO findAverageQuestion5(@Param("subjectId") Long subjectId);

	@Query("""
		       SELECT new com.mymood.feedbacksystem.Feedback.System.DTO.Analytics.BatchAverageDTO(
		           s.batch.name, 
		           AVG((f.question1_rating + f.question2_rating + f.question3_rating + f.question4_rating + f.question5_rating)/5)
		       )
		       FROM FeedbackEntity f
		       JOIN f.student s
		       WHERE f.subject.subjectId = :subjectId
		       GROUP BY s.batch.name
		       """)
		List<BatchAverageDTO> findAverageByBatch(@Param("subjectId") Long subjectId);

	@Query("""
		       SELECT new com.mymood.feedbacksystem.Feedback.System.DTO.Analytics.SectionAverageDTO(
		           s.section.name, 
		           AVG((f.question1_rating + f.question2_rating + f.question3_rating + f.question4_rating + f.question5_rating)/5)
		       )
		       FROM FeedbackEntity f
		       JOIN f.student s
		       WHERE f.subject.subjectId = :subjectId
		       GROUP BY s.section.name
		       """)
		List<SectionAverageDTO> findAverageBySection(@Param("subjectId") Long subjectId);

}
