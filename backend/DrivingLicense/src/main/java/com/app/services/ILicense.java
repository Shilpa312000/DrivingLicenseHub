package com.app.services;

import java.util.List;

import com.app.dto.LisenceDTO;
import com.app.entities.License;

public interface ILicense {
	public List<LisenceDTO> getAllLicense();
	public LisenceDTO addNewLicense(LisenceDTO license);
	public boolean deleteLicense(int licenseid);
	public License getLicense(int licenseid);
	public LisenceDTO updateLicense(LisenceDTO license,int licenseid);
}
