package com.mymood.feedbacksystem.Feedback.System.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mymood.feedbacksystem.Feedback.System.Entity.BranchEntity;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity, Long>{

	boolean existsByName(String name);

	@Query("SELECT b FROM BranchEntity b WHERE b.name = :name AND b.department.departmentId = :departmentId")
	Optional<BranchEntity> findByNameAndDepartmentId(@Param("name") String name, @Param("departmentId") Long departmentId);
	
}
