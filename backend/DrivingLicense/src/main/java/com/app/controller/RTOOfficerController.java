
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
import com.app.dto.RTOOfficerDto;
import com.app.entities.RTOOfficer;
import com.app.services.IRTOOfficer;

import io.swagger.v3.oas.annotations.parameters.RequestBody;




@RestController
@RequestMapping("/officers")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")


public class RTOOfficerController {
	
	@Autowired
	private IRTOOfficer officerService;
	
	@PostMapping("/addOfficer")
	public RTOOfficer addNewOfficer(@RequestBody RTOOfficer officer) {
		System.out.println("in add new addofficer " + officer);
		return officerService.addNewOfficer(officer);
	}

	
	@GetMapping("/AllOfficers")
	public ResponseEntity<ApiResponse<List<RTOOfficerDto>>> get(){
		return ResponseEntity.ok(new ApiResponse<>(officerService.getAllOfficers(), "", true));
	}
	
	@PutMapping("/updateOfficer/{id}")
	public ResponseEntity<ApiResponse<RTOOfficer>> updateOfficer(@PathVariable int id, @RequestBody RTOOfficer pet) {
		RTOOfficer updatedpet= officerService.updateOfficerDetails(pet, id);
		if(updatedpet != null) {
			return ResponseEntity.ok(new ApiResponse<>(updatedpet, "Officer updated Successfully", true));
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse<>(null, "Pet Not Found", false));
		}
	}
	
	@GetMapping("/Officerdetails/{id}")
	public ResponseEntity<ApiResponse<RTOOfficer>> getOfficerDetails(@PathVariable int officerid) 
	{
		RTOOfficer officerDTO=officerService.getOfficerDetails(officerid);
		if(officerDTO == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse<>(null,"Officer not Found",false));
		}else {
			return ResponseEntity.ok(new ApiResponse<>(officerDTO,"Officer retrieved Succesfully",true));
		}
	}
	
	@DeleteMapping("/deleteOfficer/{id}")
	public ResponseEntity<ApiResponse<Void>> deleteOfficer(@PathVariable int id){
		boolean isDeleted = officerService.deleteOfficerDetails(id);
		if(isDeleted) {
			return ResponseEntity.ok(new ApiResponse<>(null, "Officer record  deleted Successfully", true));
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse<>(null, "officer not Found", false));
		}
	}
}
