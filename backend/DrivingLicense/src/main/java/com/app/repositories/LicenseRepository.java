package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.LisenceDTO;
import com.app.entities.License;

public interface LicenseRepository extends JpaRepository<License, Integer> {

	LisenceDTO save(LisenceDTO license);

}
