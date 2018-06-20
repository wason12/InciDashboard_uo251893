package inciDashboard.inciRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import inciDashboard.entities.Incidencia;
import inciDashboard.entities.Operator;

@Service
public class InciRepositoryFacadeClass implements InciRepositoryFacade {

	@Autowired
	private IncidenceRepository inciRepo;

	@Autowired
	private OperatorRepository operatorRepo;

	@Override
	public List<Incidencia> IncidencesInfo() {
		return inciRepo.findAll();
	}

	@Override
	public void UpdateIncidence(Incidencia incidence) {
		inciRepo.save(incidence);
	}

	@Override
	public Operator checkOperador(Operator operador) {
		Operator saved = operatorRepo.findByEmail(operador.getEmail());
		
		if(saved == null || operador.getPassword().equals(saved.getPassword()))
			return saved;
		
		return null;
	}

}
