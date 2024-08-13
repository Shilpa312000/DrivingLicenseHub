package com.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.RTOOfficerDto;
import com.app.dto.TestDTO;
import com.app.entities.RTOOfficer;
import com.app.entities.Test;
import com.app.repositories.TestRepository;

@Service
public class TestDetails implements ITest{
	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<TestDTO> getAllTests() {
		return testRepository.findAll() 
				.stream() 
				.map(test -> 
				modelMapper.map(test,TestDTO.class)) 
				.collect(Collectors.toList());
	}
		
	@Override
	public TestDTO addNewTest(TestDTO test) {
		return testRepository.save(test);
		
	}

	@Override
	public boolean deleteTestDetails(int testId) {
		if (testRepository.existsById(testId)) {
			// API of CrudRepo - public void deleteById(ID id)
			testRepository.deleteById(testId);
			return true;
		}		
		return false;
	}

	@Override
	public Test getTestDetails(int testid) {
		Optional<Test> optional = testRepository.findById(testid);
		return optional.orElseThrow(() -> 
		new ResourceNotFoundException("Invalid Category ID!!!!"));		
		
	}

	@Override
	public TestDTO updateTestDetails(TestDTO test, int id) {
		Test existingtest = testRepository.findById(id)
			       .orElseThrow(() -> new ResourceNotFoundException("test not found with id " + id));
		existingtest.setType(test.getType());;
		existingtest.setOfficer(test.getOfficer());;
		existingtest.setTestdate(test.getTestdate());;
		existingtest.setUser(test.getUser());
		existingtest.setScore(test.getScore());
		
		return testRepository.save(test);
	}

}
