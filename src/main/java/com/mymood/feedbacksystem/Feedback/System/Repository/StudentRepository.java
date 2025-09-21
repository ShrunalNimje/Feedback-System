package com.mymood.feedbacksystem.Feedback.System.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mymood.feedbacksystem.Feedback.System.DTO.Response.SubmissionStatusDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long>{

	Optional<StudentEntity> findByEnrollmentId(String enrollmentId);
	
	@Query("""
		    SELECT new com.mymood.feedbacksystem.dto.response.SubmissionStatusDTO(
		        s.enrollmentId,
		        CASE WHEN f.id IS NOT NULL THEN true ELSE false END
		    )
		    FROM StudentEntity s
		    LEFT JOIN FeedbackEntity f
		        ON f.student.id = s.id
		        AND f.subject.id = :subjectId
		        AND f.semester = :semester
		    WHERE s.batch.id = :batchId
		""")
		List<SubmissionStatusDTO> getFeedbackSubmissionStatus(
		        @Param("subjectId") Long subjectId,
		        @Param("semester") Integer semester,
		        @Param("batchId") Long batchId);

}
