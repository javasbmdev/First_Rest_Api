package com.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.Plan;
import com.project.entities.PlanCategory;
import com.project.repository.PlanCategoryRepository;
import com.project.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanSErvice {
	@Autowired
	private PlanRepository planRepository;
	@Autowired
	private PlanCategoryRepository categoryRepository;

	@Override
	public Map<Integer, String> getPlanCategory() {
		List<PlanCategory> categories = categoryRepository.findAll();
		Map<Integer, String> categoryMap = new HashMap<>();
		categories.forEach(category -> {
			categoryMap.put(category.getCategoryId(), category.getCategoryName());
		});
		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		Plan savedPlan = planRepository.save(plan);
		return savedPlan.getPlanId() != null;
	}

	@Override
	public List<Plan> getPlans() {
		return planRepository.findAll();
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> planById = planRepository.findById(planId);
		if (planById.isEmpty()) {
			return null;
		} else {
			return planById.get();
		}
	}

	@Override
	public boolean updatePlan(Plan plan) {
		Plan updated = planRepository.save(plan);
		return updated.getPlanId() != null;
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		boolean deleteStatus = false;
		try {
			planRepository.deleteById(planId);
			deleteStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteStatus;
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {
		Optional<Plan> planById = planRepository.findById(planId);
		if (planById.isEmpty()) {
			return false;
		} else {
			Plan plan = planById.get();
			plan.setActiveSwitch(status);
			planRepository.save(plan);
			return true;
		}
	}

}
