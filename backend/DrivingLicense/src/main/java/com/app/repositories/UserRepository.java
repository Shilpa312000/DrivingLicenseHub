package com.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select u from User u join fetch u.userRoles where u.email=?1")
	Optional<User> findByEmail(String email);
}
