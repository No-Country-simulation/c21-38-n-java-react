package com.encuentratumascota.shelter;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.encuentratumascota.shelter", "mapper"})
@OpenAPIDefinition(info = @Info(title = "Shelter API", version = "v1", description = "API para encontrar a tu próxima mascota"))
public class ShelterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShelterApplication.class, args);
	}

}
