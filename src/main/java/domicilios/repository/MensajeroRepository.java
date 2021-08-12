package domicilios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domicilios.model.Mensajero;

@Repository
public interface MensajeroRepository extends JpaRepository<Mensajero, Long> {

}
