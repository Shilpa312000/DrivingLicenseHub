package com.app.services;

import java.io.IOException;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.app.dto.UserDTO;
import com.app.security.CustomUserDetails;

public interface IUserDetails {
	public UserDTO registerUser(UserDTO user) throws IOException;

	CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

	
}
