package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer>{

}
