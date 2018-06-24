package inciDashboard.inciRepository;

import java.util.HashMap;
import java.util.HashSet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inciDashboard.entities.Estado;
import inciDashboard.entities.Incidencia;
import inciDashboard.entities.Localizacion;
import inciDashboard.entities.Operator;

@Service
public class InsertSampleData {

	@Autowired
	private OperatorRepository operatorRepository;

	@Autowired
	private IncidenceRepository incidenceRepository;

	@PostConstruct
	public void init() {

		Operator operador = new Operator("1", "1", "Operador Dominguez");

		operatorRepository.save(operador);

		Incidencia inci = new Incidencia("Agente", "inci name", "incidencia desc", new HashSet<String>(),
				new HashMap<String, String>(), Estado.ABIERTA, new Localizacion(2.2, 2.2));

		inci.setCamposLista("prueba/test,campo2/algo");
		inci.setOperadorAsignado(operador);
		inci.setUrlMasInfo("si");
		
		incidenceRepository.save(inci);

	}

}
