package com.app.dto;

import java.time.LocalDate;
import java.util.List;

import com.app.entities.RTOOfficer;
import com.app.entities.TestResult;
import com.app.entities.Type;
import com.app.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TestDTO {
public int testid;
private Type type;
private LocalDate testdate;
private int score;
private List<RTOOfficer> officer;
private List<TestResult> result;
private User user;
}
