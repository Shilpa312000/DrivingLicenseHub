
package com.app;

import java.io.File;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.repositories.RoleRepository;

@SpringBootApplication

public class DrivingLicenseApplication implements CommandLineRunner {
	@Value("${file.profile.upload.location}")
	private String profilePictureFolderPath;
	
	@Autowired
	private RoleRepository roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(DrivingLicenseApplication.class, args);
	}
	
	@Bean
	public ModelMapper mapper()
	{
		 ModelMapper modelMapper = new ModelMapper();
		 modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		 return modelMapper;
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void run(String... args) throws Exception {
		File dir = new File(profilePictureFolderPath);
		if (!dir.exists())
			dir.mkdirs();
			}
	

}
