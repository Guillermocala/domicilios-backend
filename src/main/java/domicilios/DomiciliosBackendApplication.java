package domicilios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import domicilios.model.Destinatario;
import domicilios.model.Domicilio;
import domicilios.model.Mensajero;
import domicilios.model.Solicitante;
import domicilios.repository.DestinatarioRepository;
import domicilios.repository.DomicilioRepository;
import domicilios.repository.SolicitanteRepository;

@SpringBootApplication
public class DomiciliosBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomiciliosBackendApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(DomiciliosBackendApplication.class);
	
	@Bean
	public CommandLineRunner loadData(DomicilioRepository domicilioRep, SolicitanteRepository solicitanteRep, DestinatarioRepository destinatarioRep) {
		return(args)-> {
			
			Solicitante solicitante = new Solicitante(null, "nombresol", "cra 1", 123, "2123", null);
			Destinatario destinatario = new Destinatario(null, "nombredes", "cra2", 1345, null);
			Mensajero mensajero = new Mensajero(null, "pancracio", "cra 15", 2300021, 1095090, "str341");
			log.info(solicitante.toString());
			log.info(destinatario.toString());
			log.info(mensajero.toString());
			
			//solicitanteRep.save(solicitante);
			//destinatarioRep.save(destinatario);
			Domicilio domicilio = new Domicilio(null, solicitante, destinatario, "descripcion", mensajero, true);
			//log.info(domicilio.toString());
			
			
			domicilioRep.save(domicilio);
			log.info("domicilio ingresado");
		};
	}
}
