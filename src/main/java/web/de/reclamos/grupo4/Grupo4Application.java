package web.de.reclamos.grupo4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@EnableSwagger2
@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
public class Grupo4Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo4Application.class, args);
	}
}
