package com.cos.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.BlogApplication;

@RestController
@SpringBootApplication
public class BlogApplication extends SpringBootServletInitializer {
	@GetMapping
	public String test() {
		return " eeee!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BlogApplication.class);
	}

}
