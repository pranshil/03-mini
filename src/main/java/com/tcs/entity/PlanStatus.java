package com.tcs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PlanStatus {

	@Id
	@Column(name="PLAN_STATUS")
	private String planStatus;
	
}
