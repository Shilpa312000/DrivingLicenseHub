package com.app.services;

import java.util.List;

import com.app.dto.TestDTO;
import com.app.entities.Test;

public interface ITest {

	public List<TestDTO> getAllTests();
	public TestDTO addNewTest(TestDTO test);
	public boolean deleteTestDetails(int testId);
	public Test getTestDetails(int testid);
	public TestDTO updateTestDetails(TestDTO test,int id);
}
