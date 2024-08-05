package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="testResut")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TestResult {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="result_id")
	private int applicationId;
	
	@Column(name="Result")
	private boolean results;
	
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "test_id")
	private Test test;
	
	@ManyToOne
	@JoinColumn(name = "officer_id")
	private RTOOfficer officer;
	
	
}