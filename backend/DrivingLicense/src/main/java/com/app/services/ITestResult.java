package com.app.services;

import java.util.List;


import com.app.dto.TestResultDTO;
import com.app.entities.Test;

public interface ITestResult {
	public List<TestResultDTO> getAllTests();
	public TestResultDTO addNewTest(TestResultDTO test);
	public boolean deleteTestDetails(int testId);
	public Test getTestDetails(int testid);
	public TestResultDTO updateTestDetails(TestResultDTO test,int id);

}
