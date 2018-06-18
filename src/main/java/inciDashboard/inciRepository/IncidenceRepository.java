package inciDashboard.inciRepository;

import org.springframework.data.repository.CrudRepository;

import inciDashboard.entities.Incidencia;
import java.util.List;

public interface IncidenceRepository extends CrudRepository<Incidencia, Long> {

	List<Incidencia> findAll();

}
