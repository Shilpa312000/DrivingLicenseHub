
package com.app.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="License")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class License {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="License_id")
	private int lid;
	
	@Column(name="IssueDate")
	private LocalDate Idate;
	
	@Column(name="Expiration_date")
	private LocalDate expiredate;
	
	@Column(length = 20,name = "LicenseNumber")
	private String Lnumber;
	
	@Column(length = 20,name = "LicenseClass")
	private String licenseClass;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
}
