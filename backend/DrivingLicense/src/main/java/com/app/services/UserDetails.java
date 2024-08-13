package com.app.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Clock;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.UserDTO;
import com.app.entities.User;
import com.app.repositories.RoleRepository;
import com.app.repositories.UserRepository;
import com.app.security.CustomUserDetails;

@Service
public class UserDetails implements IUserDetails,UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private ModelMapper mapper;

	@Value("${file.profile.upload.location}")
	private String profilePictureFolderPath;

	@Override
	public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Invalid Email ID !!"));
		return new CustomUserDetails(user);
	}

	@Override
	public UserDTO registerUser(UserDTO userDto) throws IOException {
		User userEntity = mapper.map(userDto, User.class);
		Clock clock = Clock.systemDefaultZone();
		long milliSeconds = clock.millis();
		MultipartFile profilePictureFile = userDto.getProfilePicture();
		String completePath = profilePictureFolderPath + File.separator + milliSeconds
				+ profilePictureFile.getOriginalFilename();
		Files.copy(profilePictureFile.getInputStream(), Paths.get(completePath), StandardCopyOption.REPLACE_EXISTING);

		userEntity.setProfilePicPath(completePath);
		userEntity.setUserRoles(roleRepo.findByRoleNameIn(userDto.getUserRoles()));
		userEntity.setPassword(encoder.encode(userDto.getPassword()));

		User persistentUser = userRepository.save(userEntity);
		return userDto;
		}
	
	



	
	
	}


