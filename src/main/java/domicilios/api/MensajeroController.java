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

import domicilios.model.Mensajero;
import domicilios.repository.MensajeroRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
public class MensajeroController {

	@Autowired
	private MensajeroRepository mensajeroRep;
	
	@GetMapping("/mensajeros")
	public ResponseEntity<List<Mensajero>> getAllMensajeros() {
		List<Mensajero> listaMensajeros= mensajeroRep.findAll();
		if (listaMensajeros.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(listaMensajeros, HttpStatus.OK);
		}
	}
	
	@GetMapping("/mensajeros/{id}")
	public ResponseEntity<Mensajero> getMensajero(@PathVariable("id") Long id) {
		Optional<Mensajero> mensajero = mensajeroRep.findById(id);
		if (mensajero.isPresent()) {
			return new ResponseEntity<>(mensajero.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/mensajeros")
	public ResponseEntity<Mensajero> createMensajero(@RequestBody Mensajero p) {
		try {
			Mensajero mensajero = mensajeroRep.save(p);
			return new ResponseEntity<>(mensajero, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/mensajeros/{id}")
	public ResponseEntity<Mensajero> updateMensajero(@PathVariable("id") Long id, @RequestBody Mensajero p) {
		Optional<Mensajero> datosMensajero= mensajeroRep.findById(id);
		if (datosMensajero.isPresent()) {
			Mensajero mensajero = datosMensajero.get();
			mensajero.setNombre(p.getNombre());
			mensajero.setDireccion(p.getDireccion());
			mensajero.setCel(p.getCel());
			mensajero.setCedula(p.getCedula());
			mensajero.setPlaca(p.getPlaca());
			Mensajero nuevoMensajero = mensajeroRep.save(mensajero);
			return new ResponseEntity<>(nuevoMensajero, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/mensajeros/{id}")
	public ResponseEntity<HttpStatus> deleteMensajero(@PathVariable("id") Long id) {
		try {
			mensajeroRep.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
