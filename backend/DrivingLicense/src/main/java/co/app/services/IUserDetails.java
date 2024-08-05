package co.app.services;

import java.io.IOException;

import co.app.dto.UserDTO;

public interface IUserDetails {
	
	public UserDTO registerUser(UserDTO user) throws IOException;
	}

