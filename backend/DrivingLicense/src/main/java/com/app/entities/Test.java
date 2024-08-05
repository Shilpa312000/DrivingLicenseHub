
package com.app.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="test")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="test_id")
	private int testId;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Column(name="test_date")
	private LocalDate testdate;
	
	@Column(name="test_score")
	private int score;
	
	
	@OneToMany(mappedBy = "test")
	private List<RTOOfficer> officer;
	
	@OneToMany(mappedBy = "test")
	private List<TestResult> result;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
