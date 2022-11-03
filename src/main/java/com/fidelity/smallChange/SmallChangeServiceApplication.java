package com.fidelity.smallChange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class SmallChangeServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SmallChangeServiceApplication.class, args);
	}

	/**
	 * This method allows Loggers to be autowired in other classes:
	 *    @Autowired private Logger logger;
	 */
	@Bean
	@Scope("prototype")
	public Logger createLogger(InjectionPoint ip) {
	    Class<?> classThatWantsALogger = ip.getField().getDeclaringClass();
	    return LoggerFactory.getLogger(classThatWantsALogger);
	}

}
