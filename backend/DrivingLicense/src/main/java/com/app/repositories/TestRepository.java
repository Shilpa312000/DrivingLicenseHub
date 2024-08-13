package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.TestDTO;
import com.app.entities.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {

	TestDTO save(TestDTO test);

}
