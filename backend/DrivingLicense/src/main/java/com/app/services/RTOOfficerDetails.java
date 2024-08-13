package com.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.RTOOfficerDto;
import com.app.entities.RTOOfficer;
import com.app.repositories.RTOOfficerRepository;

@Service 
@Transactional 
public class RTOOfficerDetails implements IRTOOfficer {
	
	@Autowired
	private RTOOfficerRepository officerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<RTOOfficerDto> getAllOfficers() {
		
		return officerRepository.findAll() 
				.stream() 
				.map(officer -> 
				modelMapper.map(officer,RTOOfficerDto.class)) 
				.collect(Collectors.toList());
	}
	@Override
	public RTOOfficer addNewOfficer(RTOOfficer newofficer) {
		return officerRepository.save(newofficer);

	}
	@Override
	public boolean deleteOfficerDetails(int offcierId) {
		if (officerRepository.existsById(offcierId)) {
			// API of CrudRepo - public void deleteById(ID id)
			officerRepository.deleteById(offcierId);
			return true;
		}		
		return false;
	}
	@Override
	public RTOOfficer getOfficerDetails(int offcierId) {
		Optional<RTOOfficer> optional = officerRepository.findById(offcierId);
		return optional.orElseThrow(() -> 
		new ResourceNotFoundException("Invalid Officer ID!!!!"));		
		
	}
	@Override
	public RTOOfficer updateOfficerDetails(RTOOfficer officer,int id) {
		RTOOfficer existingofficer = officerRepository.findById(id)
			       .orElseThrow(() -> new ResourceNotFoundException("Officer not found with id " + id));
		existingofficer.setName(officer.getName());
		existingofficer.setPosition(officer.getPosition());
		existingofficer.setLocation(officer.getLocation());
		existingofficer.setResult(officer.getResult());
		existingofficer.setTest(officer.getTest());
		officerRepository.save(existingofficer);
		return officerRepository.save(officer);
	}

	

	

	
	
	

}
