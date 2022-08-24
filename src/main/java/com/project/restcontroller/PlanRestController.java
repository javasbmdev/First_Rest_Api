package com.project.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.constant.ApplicationConstants;
import com.project.entities.Plan;
import com.project.props.ApplicationProperty;
import com.project.service.PlanSErvice;

@RestController
public class PlanRestController {
	private PlanSErvice service;
	Map<String, String> messages = null;

	public PlanRestController(PlanSErvice service, ApplicationProperty applicationProperty) {
		this.service = service;
		messages = applicationProperty.getMessage();
	}

	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> showPlanCategories() {
		Map<Integer, String> categories = service.getPlanCategory();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
		String message = ApplicationConstants.EMPTY_STR;
		boolean isSaved = service.savePlan(plan);
		if (isSaved) {
			message = ApplicationConstants.PLAN_SAVE_SUCESS;
		} else {
			message = ApplicationConstants.PLAN_SAVE_FAIL;
		}
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}

	@GetMapping("/show-plans")
	public ResponseEntity<List<Plan>> showPlans() {
		List<Plan> plans = service.getPlans();
		return new ResponseEntity<>(plans, HttpStatus.OK);
	}

	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId) {
		Plan plan = service.getPlanById(planId);
		return new ResponseEntity<>(plan, HttpStatus.OK);
	}

	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan) {
		boolean isUpddated = service.updatePlan(plan);
		String resMessage = ApplicationConstants.EMPTY_STR;
		if (isUpddated) {
			resMessage = ApplicationConstants.PLAN_UPDATE_SUCESS;
		} else {
			resMessage = ApplicationConstants.PLAN_UPDATE_FAIL;
		}
		return new ResponseEntity<>(resMessage, HttpStatus.OK);
	}

	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
		String resMessage = ApplicationConstants.EMPTY_STR;
		boolean isdeleted = service.deletePlanById(planId);
		if (isdeleted) {
			resMessage = ApplicationConstants.PLAN_DELETE_SUCESS;
		} else {
			resMessage = ApplicationConstants.PLAN_DELETE_FAIL;
		}
		return new ResponseEntity<>(resMessage, HttpStatus.OK);
	}

	@PutMapping("/change-status/{planId}/{status}")
	public ResponseEntity<String> changeStatus(@PathVariable Integer planId, @PathVariable String status) {
		String resMessage = ApplicationConstants.EMPTY_STR;
		boolean isStatusChanged = service.planStatusChange(planId, status);
		if (isStatusChanged) {
			resMessage = ApplicationConstants.PLAN_STATUS_CHANGE_SUCESS;
		} else {
			resMessage = ApplicationConstants.PLAN_STATUS_CHANGE_FAIL;
		}
		return new ResponseEntity<String>(resMessage, HttpStatus.OK);
	}

}
