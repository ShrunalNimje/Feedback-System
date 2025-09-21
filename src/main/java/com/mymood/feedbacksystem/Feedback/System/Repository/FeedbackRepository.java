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
    
    @Query("SELECT new com.mymood.feedbacksystem.dto.AnonymousFeedbackResponseDTO(" +
    	       "f.id, f.teacher.name, f.subject.name, f.semester, f.submittedAt) " +
    	       "FROM FeedbackEntity f " +
    	       "WHERE (:subjectId IS NULL OR f.subject.id = :subjectId) " +
    	       "AND (:teacherId IS NULL OR f.teacher.id = :teacherId) " +
    	       "AND (:semester IS NULL OR f.semester = :semester)")
    	List<AnonymousFeedbackResponseDTO> findAnonymousFeedback(
    	       @Param("subjectId") Long subjectId,
    	       @Param("teacherId") Long teacherId,
    	       @Param("semester") Integer semester);

    @Query("SELECT new com.yourpackage.dto.analytics.QuestionAverageDTO(q.text, AVG(f.answer)) " +
    	       "FROM Feedback f JOIN f.question q " +
    	       "WHERE f.subject.id = :subjectId " +
    	       "GROUP BY q.text")
    	List<QuestionAverageDTO> findQuestionWiseAverage(@Param("subjectId") Long subjectId);

    @Query("SELECT new com.yourpackage.dto.analytics.BatchAverageDTO(s.batchName, AVG(f.rating)) " +
    	       "FROM Feedback f JOIN f.student s " +
    	       "WHERE f.subject.id = :subjectId " +
    	       "GROUP BY s.batchName")
    	List<BatchAverageDTO> findAverageByBatch(@Param("subjectId") Long subjectId);

    @Query("SELECT new com.yourpackage.dto.analytics.SectionAverageDTO(s.sectionName, AVG(f.rating)) " +
    	       "FROM Feedback f JOIN f.student s " +
    	       "WHERE f.subject.id = :subjectId " +
    	       "GROUP BY s.sectionName")
    	List<SectionAverageDTO> findAverageBySection(@Param("subjectId") Long subjectId);

}
