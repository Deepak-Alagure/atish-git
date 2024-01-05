package com.atish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AtishApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtishApplication.class, args);
	}

		@Bean
		public PasswordEncoder passwordEncoder(){
			return new BCryptPasswordEncoder();
		}
		// 01.bean class will be created within the configaration class.
	// 02.you can also create this menthod in securityConfig class
	// beacause there we use the config anotation.
	//03. the questions arises that where did we used config annotation in this class(application class)
	 //this class consists of inbuilt @config anotation in springBootApplication.


}
