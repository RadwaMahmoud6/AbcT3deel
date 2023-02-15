package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.demo.repository")
@EntityScan("com.example.demo.entities")
@EnableAspectJAutoProxy(proxyTargetClass=true)  
@SpringBootApplication /* (exclude = {SecurityAutoConfiguration.class }) */
public class AbcBankPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcBankPlatformApplication.class, args);
	}

}
