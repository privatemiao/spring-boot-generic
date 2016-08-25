package org.mel;

import org.mel.framework.util.GenericMethod;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Throwable {
		System.out.println(GenericMethod.generateGirl("Generic System"));
		SpringApplication.run(Application.class, args);
	}
}
