package domicilios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domicilios.model.Domicilio;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
	//implementamos save, delete, findall, 
}
