package com.mymood.feedbacksystem.Feedback.System.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mymood.feedbacksystem.Feedback.System.Entity.BatchEntity;

@Repository
public interface BatchRepository extends JpaRepository<BatchEntity, Long>{

	boolean existsByName(String name);
	
	@Query("SELECT b FROM BatchEntity b WHERE b.name = :name AND b.section.sectionId = :sectionId")
	Optional<BatchEntity> findByNameAndSectionId(@Param("name") String name, @Param("sectionId") Long sectionId);

}
