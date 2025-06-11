package cz.fei.upce.language_learning_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "cz.fei.upce.language_learning_system.mapper")
@SpringBootApplication(scanBasePackages = "cz.fei.upce.language_learning_system")
public class VyukovySystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(VyukovySystemApplication.class, args);
	}
}
