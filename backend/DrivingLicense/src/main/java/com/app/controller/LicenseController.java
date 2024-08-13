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
import com.app.dto.LisenceDTO;
import com.app.entities.License;
import com.app.services.ILicense;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/licenses")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class LicenseController {
		
		@Autowired
		private ILicense licenseService;
		
		@PostMapping("/addLicense")
		public LisenceDTO addNewLicense(@RequestBody LisenceDTO license) {
			System.out.println("in add new addLicense " + license);
			return licenseService.addNewLicense(license);
		}

		
		@GetMapping("/AllLicense")
		public ResponseEntity<ApiResponse<List<LisenceDTO>>> get(){
			return ResponseEntity.ok(new ApiResponse<>(licenseService.getAllLicense(), "", true));
		}
		
		@PutMapping("/updateLicense/{id}")
		public ResponseEntity<ApiResponse<LisenceDTO>> updateOfficer(@PathVariable int id, @RequestBody LisenceDTO license) {
			LisenceDTO updatelicense= licenseService.updateLicense(license, id);
			if(updatelicense != null) {
				return ResponseEntity.ok(new ApiResponse<>(updatelicense, "License updated Successfully", true));
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ApiResponse<>(null, "License Not Found", false));
			}
		}
		
		@GetMapping("/Licensedetails/{id}")
		public ResponseEntity<ApiResponse<License>> getLicenseDetails(@PathVariable int licenseid) 
		{
			License licenseDTO=licenseService.getLicense(licenseid);
			if(licenseDTO == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ApiResponse<>(null,"license not Found",false));
			}else {
				return ResponseEntity.ok(new ApiResponse<>(licenseDTO,"licensee retrieved Succesfully",true));
			}
		}
		
		@DeleteMapping("/deleteLicense/{id}")
		public ResponseEntity<ApiResponse<Void>> deleteLicense(@PathVariable int id){
			boolean isDeleted = licenseService.deleteLicense(id);
			if(isDeleted) {
				return ResponseEntity.ok(new ApiResponse<>(null, "License record  deleted Successfully", true));
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ApiResponse<>(null, "license not Found", false));
			}
		}
	}


