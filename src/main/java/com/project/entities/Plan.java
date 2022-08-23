package com.project.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "plan_manager")
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "plan_id")
	private Integer planId;
	@Column(name = "plan_name")
	private String planName;

	@Column(name = "plan_starting_date")
	private LocalDate planStartingDate;
	@Column(name = "plan_ending_date")
	private LocalDate planEndingDate;

	@Column(name = "active_switch")
	private String activeSwitch;
	@Column(name = "plan_category_id")
	private Integer planCategoryId;

	@Column(name = "created_by")
	private String cratedBy;
	@Column(name = "updated_by")
	private String updatedBy;
	@Column(name = "created_date")
	private LocalDate createdDate;
	@Column(name = "updated_date")
	private LocalDate updatedDate;
}
