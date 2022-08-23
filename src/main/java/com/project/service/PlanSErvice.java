package com.project.service;

import java.util.List;
import java.util.Map;

import com.project.entities.Plan;

public interface PlanSErvice {
	public Map<Integer, String> getPlanCategory();
	public boolean savePlan(Plan plan);
	public List<Plan> getPlans();
	public Plan getPlanById(Integer planId);
	public boolean updatePlan(Plan plan);
	public boolean deletePlanById(Integer planId);
	public boolean planStatusChange(Integer planId,String status);
}
