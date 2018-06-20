package inciDashboard.inciRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import inciDashboard.entities.Operator;

@Repository
public interface OperatorRepository extends CrudRepository<Operator, Long> {

	Operator findByEmail(String email);

}
