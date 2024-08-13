package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RTOOfficerDto extends BaseDto {
	private String name;
	private String position;
	private String location;

}
