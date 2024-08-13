package com.app.services;

import java.util.List;

import com.app.dto.RTOOfficerDto;
import com.app.entities.RTOOfficer;

public interface IRTOOfficer {
	public List<RTOOfficerDto> getAllOfficers();
	public RTOOfficer addNewOfficer(RTOOfficer officerService);
	public boolean deleteOfficerDetails(int offcierId);
	public RTOOfficer getOfficerDetails(int offcierId);
	public RTOOfficer updateOfficerDetails(RTOOfficer officer,int id);
}
