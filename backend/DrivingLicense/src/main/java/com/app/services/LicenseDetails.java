package com.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.LisenceDTO;
import com.app.entities.License;
import com.app.repositories.LicenseRepository;

@Service
public class LicenseDetails implements ILicense{

	@Autowired
	private LicenseRepository licenseRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<LisenceDTO> getAllLicense() {
		return licenseRepository.findAll() 
				.stream() 
				.map(license -> 
				modelMapper.map(license,LisenceDTO.class)) 
				.collect(Collectors.toList());
	}
	
	@Override
	public LisenceDTO addNewLicense(LisenceDTO license) {
		return licenseRepository.save(license);
	}

	@Override
	public boolean deleteLicense(int licenseid) {
		if (licenseRepository.existsById(licenseid)) {
			// API of CrudRepo - public void deleteById(ID id)
			licenseRepository.deleteById(licenseid);
			return true;
		}		
		return false;
	}

	@Override
	public License getLicense(int licenseid) {
		Optional<License> optional = licenseRepository.findById(licenseid);
		return optional.orElseThrow(() -> 
		new ResourceNotFoundException("Invalid Officer ID!!!!"));		
		
	}

	@Override
	public LisenceDTO updateLicense(LisenceDTO license, int licenseid) {
		License existinglicense = licenseRepository.findById(licenseid)
			       .orElseThrow(() -> new ResourceNotFoundException("Officer not found with id " + licenseid));
		existinglicense.setUser(license.getUser());
		existinglicense.setLnumber(license.getLicenseClass());
		existinglicense.setIdate(license.getIdate());
		existinglicense.setExpiredate(license.getExpiredate());
		existinglicense.setLicenseClass(license.getLicenseClass());
		return licenseRepository.save(license);
	}

}
