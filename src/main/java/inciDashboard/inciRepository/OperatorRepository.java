package inciDashboard.inciRepository;

import org.springframework.data.repository.CrudRepository;

import inciDashboard.entities.Operator;

public interface OperatorRepository extends CrudRepository<Operator, Long> {
	
	Operator findByEmail(String email);

}
