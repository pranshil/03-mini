package com.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.binding.SearchResult;
import com.tcs.entity.PlanName;
import com.tcs.entity.PlanStatus;
import com.tcs.entity.Plans;
import com.tcs.repository.PlanNameRepository;
import com.tcs.repository.PlanRepository;
import com.tcs.repository.PlanStatusRepository;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	public PlanRepository planRepository;

	@Autowired
	public PlanNameRepository planNameRepository;

	@Autowired
	public PlanStatusRepository planStatusRepository;

	@Override
	public List<PlanName> getPlanName(PlanName planName) {
		return planNameRepository.findAll();
	}

	@Override
	public List<PlanStatus> getPlanStatus(PlanStatus planStatus) {
		return planStatusRepository.findAll();
	}

	@Override
	public List<Plans> getRecordsByPlanName(String planName) {
		List<Plans> byPlanName = planRepository.findAllByPlanName(planName);
		if (!byPlanName.isEmpty()) {
			return byPlanName;
		}
		return null;
	}

	@Override
	public List<Plans> getRecordsByPlanStatus(String planStatus) {
		List<Plans> byPlanStatus = planRepository.findAllByPlanStatus(planStatus);
		if (!byPlanStatus.isEmpty()) {
			return byPlanStatus;
		}
		return null;
	}

	@Override
	public List<Plans> getRecordsByPlanNameAndPlanStatus(String planName, String planStatus) {
		List<Plans> byPlanStatus = planRepository.findAllByPlanNameAndPlanStatus(planName, planStatus);
		List<Plans> all = planRepository.findAll();
		if (!planName.isEmpty() & !planStatus.isEmpty()) {
			return byPlanStatus;
		}
		if (planName.isEmpty() & planStatus.isEmpty()) {
			return all;
		}
		return null;
	}

	@Override
	public String getExcelFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPdfFile() {
		// TODO Auto-generated method stub
		return null;
	}
}
