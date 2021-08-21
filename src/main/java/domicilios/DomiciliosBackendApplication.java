package domicilios;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import domicilios.repository.DomicilioRepository;

@SpringBootApplication
public class DomiciliosBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomiciliosBackendApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(DomicilioRepository domicilioRep) {
		return(args)-> {		
			
		};
	}
}
