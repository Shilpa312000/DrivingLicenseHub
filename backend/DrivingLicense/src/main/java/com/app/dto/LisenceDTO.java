package com.app.dto;

import java.time.LocalDate;

import com.app.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LisenceDTO {
	private int lid;
	private User user;
	private LocalDate Idate;
	private LocalDate expiredate;
	private String Lnumber;
	private String licenseClass;
}
