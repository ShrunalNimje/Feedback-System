package com.mymood.feedbacksystem.Feedback.System.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mymood.feedbacksystem.Feedback.System.Entity.AttendanceEntity;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long>{
	
	Optional<AttendanceEntity> findByStudent_StudentId(Long studentId);
}
