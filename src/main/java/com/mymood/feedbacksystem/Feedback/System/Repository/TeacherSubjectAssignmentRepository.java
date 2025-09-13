package com.mymood.feedbacksystem.Feedback.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mymood.feedbacksystem.Feedback.System.Entity.BatchEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.SectionEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.SubjectEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.TeacherEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.TeacherSubjectAssignmentEntity;

@Repository
public interface TeacherSubjectAssignmentRepository extends JpaRepository<TeacherSubjectAssignmentEntity, Long>{

	boolean existsByTeacherAndSubjectAndSectionAndBatchAndYearAndSemester(TeacherEntity teacher, SubjectEntity subject,
			SectionEntity section, BatchEntity batch, Integer year, Integer semester);
	
}
