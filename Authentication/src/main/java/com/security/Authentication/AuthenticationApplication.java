package com.security.Authentication;

import com.security.Authentication.models.AppUser;
import com.security.Authentication.models.Role;
import com.security.Authentication.repository.RoleRepo;
import com.security.Authentication.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
		System.out.println("AUTHENTICATION-SERVICE INITIALIZED SUCCESSFULLY ON " + new Date());
	}

	@Bean
	CommandLineRunner run(RoleRepo roleRepo, UserRepo userRepo, PasswordEncoder passwordEncoder){
		return args -> {
			if(roleRepo.findByAuthority("ADMIN").isPresent()) return;

			Role adminRole = roleRepo.save(new Role(100,"ADMIN"));
			roleRepo.save(new Role(60, "USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			AppUser admin = new AppUser( 60,"admin", passwordEncoder.encode("password"), roles);
			userRepo.save(admin);
		};

	}
}
