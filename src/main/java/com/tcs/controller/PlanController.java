package com.tcs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.binding.SearchResult;
import com.tcs.entity.PlanName;
import com.tcs.entity.PlanStatus;
import com.tcs.entity.Plans;
import com.tcs.service.PlanService;

@RestController
@CrossOrigin
public class PlanController {

	@Autowired
	public PlanService planService;
	
	@GetMapping("/planName")
	public ResponseEntity<List<PlanName>> getAllPlanName(@RequestBody PlanName planName){	
		return ResponseEntity.ok(this.planService.getPlanName(planName));
	}
	
	@GetMapping("/planStatus")
	public ResponseEntity<List<PlanStatus>> getAllPlanStatus(@RequestBody PlanStatus planStatus){	
		return ResponseEntity.ok(this.planService.getPlanStatus(planStatus));
	}
	
	@GetMapping("/planName/{name}")
	public ResponseEntity<List<Plans>> getRecordsByName(@PathVariable ("name") String planName){
		List<Plans> name = planService.getRecordsByPlanName(planName);
		return ResponseEntity.ok(this.planService.getRecordsByPlanName(planName));
	}
	
	@GetMapping("/planStatus/{status}")
	public ResponseEntity<List<Plans>> getRecordsByStatus(@PathVariable ("status") String planStatus){	
		return ResponseEntity.ok(this.planService.getRecordsByPlanStatus(planStatus));
	}
	
	@GetMapping("/planName/{name}/{status}")
	public ResponseEntity<List<Plans>> getRecordsByNameAndStatus(@PathVariable String name, @PathVariable String status){	
		return ResponseEntity.ok(this.planService.getRecordsByPlanNameAndPlanStatus(name, status));
	}
}
