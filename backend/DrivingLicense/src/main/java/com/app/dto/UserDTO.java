
package com.app.dto;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.app.entities.RoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
	@NotBlank(message = "password must be supplied")
	private Long Id;
	
	@NotBlank(message = "email must be supplied")
	@Email(message = "Invalid email format")
	private String email;
	
	@JsonIgnore
	@NotBlank(message = "password must be supplied")
	private String password;
	
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String address;
	private MultipartFile profilePicture;
	@NotBlank(message = "password must be supplied")
	private Set<RoleEnum> userRoles;
	
		
	
	
	
}
