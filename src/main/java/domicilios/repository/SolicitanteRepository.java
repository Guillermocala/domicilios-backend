package domicilios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domicilios.model.Solicitante;

@Repository
public interface SolicitanteRepository extends JpaRepository<Solicitante, Long> {

}
