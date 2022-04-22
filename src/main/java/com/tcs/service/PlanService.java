package com.tcs.service;

import java.util.List;
import java.util.Map;

import com.tcs.entity.PlanName;
import com.tcs.entity.PlanStatus;
import com.tcs.entity.Plans;

public interface PlanService {

	public List<PlanName> getPlanName(PlanName planName);
	
	public List<PlanStatus> getPlanStatus(PlanStatus planStatus);
	
	public List<Plans> getRecordsByPlanName(String planName);
	
	public List<Plans> getRecordsByPlanStatus(String planStatus);
	
	public List<Plans> getRecordsByPlanNameAndPlanStatus(String planStatus, String planName);
	
	public String getExcelFile();
	
	public String getPdfFile();

	
}
