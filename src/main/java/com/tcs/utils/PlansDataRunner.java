package com.tcs.utils;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tcs.entity.Plans;
import com.tcs.entity.PlanName;
import com.tcs.entity.PlanStatus;
import com.tcs.repository.PlanNameRepository;
import com.tcs.repository.PlanRepository;
import com.tcs.repository.PlanStatusRepository;

@Component
public class PlansDataRunner implements CommandLineRunner {

	@Autowired
	public PlanRepository planRepository;
	
	
	@Autowired
	public PlanStatusRepository planStatusRepository;
	
	@Autowired
	public PlanNameRepository planNameRepository;

	String line = "";

	@Override
	public void run(String... args) throws Exception {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data.csv"));
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				Plans plans = new Plans();
				plans.setPlanName(data[0]);
				plans.setPlanStatus(data[1]);
				plans.setHolderName(data[2]);
				plans.setBenefitAmount(data[3]);
				planRepository.save(plans);
				
				PlanName name=new PlanName();
				name.setPlanName(data[0]);
				planNameRepository.save(name);
				
				PlanStatus status=new PlanStatus();
				status.setPlanStatus(data[1]);
				planStatusRepository.save(status);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
