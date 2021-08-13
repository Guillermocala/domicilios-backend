package domicilios.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domicilios.model.Domicilio;
import domicilios.repository.DomicilioRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class DomicilioController {

	
	@Autowired
	private DomicilioRepository domicilioRep;
	
	@GetMapping("/domicilios")
	public ResponseEntity<List<Domicilio>> getAllDomicilios() {
		List<Domicilio> listaDomicilios = domicilioRep.findAll();
		if (listaDomicilios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(listaDomicilios, HttpStatus.OK);
		}
	}
	
	@GetMapping("/domicilios/{id}")
	public ResponseEntity<Domicilio> getDomicilio(@PathVariable("id") Long id) {
		Optional<Domicilio> domicilio = domicilioRep.findById(id);
		if (domicilio.isPresent()) {
			return new ResponseEntity<>(domicilio.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/domicilios")
	public ResponseEntity<Domicilio> createDomicilio(@RequestBody Domicilio p) {
		try {
			Domicilio domicilio = domicilioRep.save(p);
			return new ResponseEntity<>(domicilio, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/domicilios/{id}")
	public ResponseEntity<Domicilio> updateDomicilio(@PathVariable("id") Long id, @RequestBody Domicilio p) {
		Optional<Domicilio> datosDomicilio= domicilioRep.findById(id);
		if (datosDomicilio.isPresent()) {
			Domicilio domicilio = datosDomicilio.get();
			//domicilio.setSolicitante(p.getSolicitante());
			//domicilio.setDestinatario(p.getDestinatario());
			domicilio.setDescripcionPaquete(p.getDescripcionPaquete());
			domicilio.setMensajero(p.getMensajero());
			domicilio.setEstado(p.isEstado());
			Domicilio nuevoDomicilio= domicilioRep.save(domicilio);
			return new ResponseEntity<>(nuevoDomicilio, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/domicilios/{id}")
	public ResponseEntity<HttpStatus> deleteDomicilio(@PathVariable("id") Long id) {
		try {
			domicilioRep.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
