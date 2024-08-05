package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.TestResult;

public interface TestResultRepository extends JpaRepository<TestResult, Integer> {

}
