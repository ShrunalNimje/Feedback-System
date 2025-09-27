package com.mymood.feedbacksystem.Feedback.System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mymood.feedbacksystem.Feedback.System.Entity.BatchEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.SectionEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.SubjectEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.TeacherEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.TeacherSubjectAssignmentEntity;

@Repository
public interface TeacherSubjectAssignmentRepository extends JpaRepository<TeacherSubjectAssignmentEntity, Long>{

	boolean existsByTeacherAndSubjectAndSectionAndBatchAndSemester(TeacherEntity teacher, SubjectEntity subject,
			SectionEntity section, BatchEntity batch, Integer semester);

	@Query("SELECT t FROM TeacherSubjectAssignmentEntity t WHERE t.section = :section AND t.batch = :batch")
	List<TeacherSubjectAssignmentEntity> findBySectionAndBatch(@Param("section") SectionEntity section,
	                                                           @Param("batch") BatchEntity batch);

	@Query("SELECT a.subject FROM TeacherSubjectAssignmentEntity a WHERE a.teacher.teacherId = :teacherId")
	List<SubjectEntity> findSubjectsByTeacherId(@Param("teacherId") Long teacherId);

	
}
