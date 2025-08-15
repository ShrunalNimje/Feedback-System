package com.mymood.feedbacksystem.Feedback.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mymood.feedbacksystem.Feedback.System.Entity.FeedbackEntity;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Long>{
	
}
