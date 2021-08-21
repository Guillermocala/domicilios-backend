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
import domicilios.model.Mensajero;
import domicilios.repository.DomicilioRepository;
import domicilios.repository.MensajeroRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
public class DomicilioController {

	
	@Autowired
	private DomicilioRepository domicilioRep;
	
	@Autowired
	private MensajeroRepository mensajeroRep;
	
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
	
	@PostMapping("/domicilios/adddomicilio/{id}")
	public ResponseEntity<Domicilio> createDomicilio(@PathVariable("id") Long id, @RequestBody Domicilio d) {
		Optional<Mensajero> mensajero = mensajeroRep.findById(id);
		if (mensajero.isPresent()) {
			d.setMensajero(mensajero.get());
			Domicilio crearDomicilio = domicilioRep.save(d);
			return new ResponseEntity<>(crearDomicilio, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/domicilios/editdomicilio/{id}")
	public ResponseEntity<Domicilio> updateDomicilio(@PathVariable("id") Long id, @RequestBody Domicilio d) {
		Optional<Domicilio> datosDomicilio= domicilioRep.findById(id);
		if (datosDomicilio.isPresent()) {
			Domicilio domicilio = datosDomicilio.get();
			domicilio.setNombreSolicitante(d.getNombreSolicitante());
			domicilio.setDirSolicitante(d.getDirSolicitante());
			domicilio.setCelSolicitante(d.getCelSolicitante());
			domicilio.setHoraSolicitante(d.getHoraSolicitante());
			domicilio.setNombreDestinatario(d.getNombreDestinatario());
			domicilio.setDirDestinatario(d.getDirDestinatario());
			domicilio.setCelDestinatario(d.getCelDestinatario());
			domicilio.setDescripcionPaquete(d.getDescripcionPaquete());
			domicilio.setMensajero(d.getMensajero());
			domicilio.setEstado(d.isEstado());
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
