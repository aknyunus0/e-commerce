package com.yunusakin.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "yunus1234";
		String encodedPassword = encoder.encode(rawPassword);

		System.out.println(encodedPassword);
	}

}
