package kg.itacademy.protection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan
@EnableScheduling
@SpringBootApplication
public class ProtectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProtectionApplication.class, args);
	}
// спросить про роли контроллер
	// childModel передавать Entity . как правильно?

}
