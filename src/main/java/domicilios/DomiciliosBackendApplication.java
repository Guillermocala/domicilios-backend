package domicilios;
/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import domicilios.model.Domicilio;
import domicilios.model.Mensajero;
*/
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

	//private static final Logger log = LoggerFactory.getLogger(DomiciliosBackendApplication.class);
	
	@Bean
	public CommandLineRunner loadData(DomicilioRepository domicilioRep) {
		return(args)-> {
			/*
			Mensajero mensajero = new Mensajero(null, "pancracio", "cra 15", 2300021, 1095090, "str341");
			Domicilio domicilio = new Domicilio(null, "nombreSol", "123sdf", 12312, "12:23", "nombreDest", "avenida", 46545, "descripcion", mensajero); 
			log.info(mensajero.toString());
			domicilioRep.save(domicilio);
			
			log.info("domicilio ingresado");*/
		};
	}
}
