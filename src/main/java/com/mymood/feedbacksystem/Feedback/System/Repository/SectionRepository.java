package com.mymood.feedbacksystem.Feedback.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mymood.feedbacksystem.Feedback.System.Entity.SectionEntity;

@Repository
public interface SectionRepository extends JpaRepository<SectionEntity, Long>{
	
}
