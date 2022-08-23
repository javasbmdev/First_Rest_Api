package com.project.entities;

import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Data;

@Data
@Entity
@Table(name = "plan_category")
public class PlanCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "category_id")
	private Integer categoryId;
	@Column(name = "category_name")
	private String categoryName;
	@Column(name = "active_switch")
	private String activeSwitch;

	@Column(name = "created_by")
	private String cratedBy;
	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "created_date")
	private LocalDate createdDate;
	@Column(name = "updated_date")
	private LocalDate updatedDate;
}
