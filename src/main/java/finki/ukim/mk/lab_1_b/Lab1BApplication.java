package finki.ukim.mk.lab_1_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Lab1BApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab1BApplication.class, args);
	}

}
