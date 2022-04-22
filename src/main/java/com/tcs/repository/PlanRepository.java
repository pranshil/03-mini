package com.tcs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tcs.entity.Plans;

public interface PlanRepository extends JpaRepository<Plans, Integer>{
	
	public List<Plans> findAllByPlanName(String planName);
	
	public List<Plans> findAllByPlanStatus(String planStatus);
	
	@Query("SELECT p FROM Plans p WHERE p.planName = ?1 and p.planStatus = ?2")
	public List<Plans> findAllByPlanNameAndPlanStatus(String name, String status);

}