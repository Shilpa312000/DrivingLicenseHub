package com.app.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@AllArgsConstructor
@Getter
@Setter
public class User extends BaseEntity{
			
	@Column(length = 35, unique = true)
	private String name;
	
	@Column(name="dob")
	private LocalDate dob;
	private String password;
	private String address;
	private String phone;
	private String email;	
	private String profilePicPath;
	
	public User() {
		super();
	}
	
	
	@ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role_name")
    private Set<Role> userRoles;
	
	
	
	
	@OneToMany(mappedBy = "user")
	private List<Test> test;
	
	@OneToOne
	@JoinColumn(name = "result_id")
	private TestResult testResult;
	
	@OneToMany(mappedBy = "user")
	private List<License>license;
}
	
	