package inciDashboard.inciRepository;

import java.util.List;

import inciDashboard.entities.Incidencia;
import inciDashboard.entities.Operator;

public interface InciRepositoryFacade {

	public List<Incidencia> IncidencesInfo();

	public void UpdateIncidence(Incidencia incidence);

	public Operator checkOperador(Operator operador);

}
