package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ApiResponse.ApiResponse;
import com.app.dto.TestDTO;
import com.app.entities.Test;
import com.app.services.ITest;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/tests")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class TestController {
			
			@Autowired
			private ITest testService;
			
			@PostMapping("/addtest")
			public TestDTO addNewLicense(@RequestBody TestDTO test) {
				System.out.println("in add new addLicense " + test);
				return testService.addNewTest(test);
			}

			
			@GetMapping("/AllTest")
			public ResponseEntity<ApiResponse<List<TestDTO>>> get(){
				return ResponseEntity.ok(new ApiResponse<>(testService.getAllTests(), "", true));
			}
			
			@PutMapping("/updateTest/{id}")
			public ResponseEntity<ApiResponse<TestDTO>> updateTest(@PathVariable int id, @RequestBody TestDTO test) {
				TestDTO updatetest= testService.updateTestDetails(test, id);
				if(updatetest != null) {
					return ResponseEntity.ok(new ApiResponse<>(updatetest, "Test updated Successfully", true));
				}
				else {
					return ResponseEntity.status(HttpStatus.NOT_FOUND)
							.body(new ApiResponse<>(null, "Test Not Found", false));
				}
			}
			
			@GetMapping("/Testdetails/{id}")
			public ResponseEntity<ApiResponse<Test>> getTestDetails(@PathVariable int testid) 
			{
				Test testDTO=testService.getTestDetails(testid);
				if(testDTO == null) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND)
							.body(new ApiResponse<>(null,"license not Found",false));
				}else {
					return ResponseEntity.ok(new ApiResponse<>(testDTO,"Test retrieved Succesfully",true));
				}
			}
			
			@DeleteMapping("/deleteTest/{id}")
			public ResponseEntity<ApiResponse<Void>> deleteTest(@PathVariable int id){
				boolean isDeleted = testService.deleteTestDetails(id);
				if(isDeleted) {
					return ResponseEntity.ok(new ApiResponse<>(null, "Test record  deleted Successfully", true));
				}
				else {
					return ResponseEntity.status(HttpStatus.NOT_FOUND)
							.body(new ApiResponse<>(null, "Test not Found", false));
				}
			}
		}




