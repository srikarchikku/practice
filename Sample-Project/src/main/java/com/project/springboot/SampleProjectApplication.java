package com.project.springboot;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class SampleProjectApplication {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SampleProjectApplication.class, args);

	}

	@Bean("AsyncMethod")
	public Executor Taskexecutor(){
		ThreadPoolTaskExecutor threadPoolTaskExecutor= new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(3);
		threadPoolTaskExecutor.setMaxPoolSize(10);
		threadPoolTaskExecutor.setQueueCapacity(2);
		threadPoolTaskExecutor.setThreadNamePrefix("My Thread - ");
		threadPoolTaskExecutor.initialize();
		return threadPoolTaskExecutor;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}





//		JwtUtil jwtUtil = new JwtUtil();
//
//		String token= jwtUtil.createToken("FW1", "Srikar");
//		System.out.println(token);
////		Claims c=jwtUtil.getTokendata(token, key);
////		System.out.println(c.getId());
////		System.out.println(c.getSubject());
////		System.out.println(c.getIssuer());
////		System.out.println(c.getIssuedAt());
////		System.out.println(c.getExpiration());
//
//		boolean validation = jwtUtil.isValid(token);
//		System.out.println(validation);