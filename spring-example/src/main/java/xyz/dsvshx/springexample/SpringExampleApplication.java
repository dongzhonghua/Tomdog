package xyz.dsvshx.springexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import xyz.dsvshx.springexample.service.impl.ServiceA;

@SpringBootApplication
public class SpringExampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringExampleApplication.class, args);
		ServiceA serviceA = run.getBean(ServiceA.class);
		serviceA.a();
	}

}
