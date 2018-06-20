package inciDashboard.inciRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import inciDashboard.entities.Incidencia;
import java.util.List;

@Repository
public interface IncidenceRepository extends CrudRepository<Incidencia, Long> {

	List<Incidencia> findAll();

}
