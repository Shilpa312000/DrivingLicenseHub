package com.app.dto;

import com.app.entities.RTOOfficer;
import com.app.entities.Test;
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
public class TestResultDTO {
public int testresultid;
private boolean results;
private User user;
private Test test;
private RTOOfficer officer;
}
