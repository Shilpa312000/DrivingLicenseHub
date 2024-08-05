
package com.app.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="officer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RTOOfficer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="officer_id")
	private int officerid;
	
	@Column(name="officer_name",length = 50)
	private String name;
	
	@Column(length = 40)
	private String position;
	
	@Column(name = "office_Location",length = 50)
	private String location;
	
	
	@ManyToOne
	@JoinColumn(name = "test_id")
	private Test test;
	
	@OneToMany(mappedBy = "officer")
	private List<TestResult> result;
	
	
}
