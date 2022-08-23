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

import com.project.entities.Plan;
import com.project.service.PlanSErvice;


@RestController
public class PlanRestController {
	@Autowired
	private PlanSErvice service;

	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> showPlanCategories() {
		Map<Integer, String> categories = service.getPlanCategory();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
		String resMessage = "";
		boolean isSaved = service.savePlan(plan);
		if (isSaved) {
			resMessage = "plan saved sucessfully";
		} else {
			resMessage = "plan Not saved ";
		}
		return new ResponseEntity<>(resMessage, HttpStatus.CREATED);
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
		String resMessage = "";
		if (isUpddated) {
			resMessage = "plan upadated sucessfully";
		} else {
			resMessage = "plna not updated";
		}
		return new ResponseEntity<>(resMessage, HttpStatus.OK);
	}

	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
		String resMessage = "";
		boolean isdeleted = service.deletePlanById(planId);
		if (isdeleted) {
			resMessage = "plan with planId " + planId + "deleted sucessfully ";
		} else {
			resMessage = "plan not deleted ";
		}
		return new ResponseEntity<>(resMessage, HttpStatus.OK);
	}

	@PutMapping("/change-status/{planId}/{status}")
	public ResponseEntity<String> changeStatus(@PathVariable Integer planId,@PathVariable String status) {
		String resMessage = "";
		boolean isStatusChanged = service.planStatusChange(planId, status);
		if (isStatusChanged) {
			resMessage = "status changed";
		} else {
			resMessage = "sttatus not changed";
		}
		return new ResponseEntity<String>(resMessage, HttpStatus.OK);
	}

}
