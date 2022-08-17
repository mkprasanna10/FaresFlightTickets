package com.brownfield.pss.fares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.brownfield.Logging.Loggable;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class DemoApplication {

	@Loggable
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
