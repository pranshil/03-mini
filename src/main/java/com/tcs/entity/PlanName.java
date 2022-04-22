package com.tcs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PlanName {

	@Id
	@Column(name="PLAN_NAME")
	private String planName;
		
}
