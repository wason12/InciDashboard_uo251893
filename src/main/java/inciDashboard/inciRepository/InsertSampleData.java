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
		
		//Coordenadas entre lAtitud: 36 / 43  Longitud: -8 / 3

		Operator operador = new Operator("operador@gmail.com", "1234", "Operador Dominguez");

		operatorRepository.save(operador);

		Incidencia inci = new Incidencia("Paco", "Fuego", "Pues que hay fuego", new HashSet<String>(),
				new HashMap<String, String>(), Estado.ABIERTA, new Localizacion(36, -8));

		inci.setCamposLista("fuego/mucho, temperatura/alta");
		inci.setOperadorAsignado(operador);
		inci.setUrlMasInfo("no");
		
		Incidencia inci1 = new Incidencia("Juan", "Nieve", "Hay nieve", new HashSet<String>(),
				new HashMap<String, String>(), Estado.ANULADA, new Localizacion(37, -8));

		inci1.setCamposLista("john/nieve,john/el mejor");
		inci1.setOperadorAsignado(operador);
		inci1.setUrlMasInfo("no");
		
		Incidencia inci2 = new Incidencia("David", "Carretera cortada", "La carretera esta cortada", new HashSet<String>(),
				new HashMap<String, String>(), Estado.CERRADA, new Localizacion(38, -5));

		inci2.setCamposLista("carretera/cortada, prisa/mucha");
		inci2.setOperadorAsignado(operador);
		inci2.setUrlMasInfo("no");
		
		Incidencia inci3 = new Incidencia("Enrique", "Derrumbamiento", "Se ha derrumbado un piso", new HashSet<String>(),
				new HashMap<String, String>(), Estado.EN_RPOCESO, new Localizacion(39, -4.1232));

		inci3.setCamposLista("edificio/caido");
		inci3.setOperadorAsignado(operador);
		inci3.setUrlMasInfo("no");
		
		Incidencia inci4 = new Incidencia("Alex", "Broma", "Esto es una broma", new HashSet<String>(),
				new HashMap<String, String>(), Estado.ANULADA, new Localizacion(40, 0));

		inci4.setOperadorAsignado(operador);
		inci4.setUrlMasInfo("no");
		
		Incidencia inci5 = new Incidencia("Yo", "Incidencia", "Descripcion d ela incidencia", new HashSet<String>(),
				new HashMap<String, String>(), Estado.EN_RPOCESO, new Localizacion(41, 2));

		inci5.setCamposLista("incidencia/incidencia");
		inci5.setOperadorAsignado(operador);
		inci5.setUrlMasInfo("no");
		
		Incidencia inci6 = new Incidencia("Jose Luis", "Parque en llamas", "El parque tal esta en llamas", new HashSet<String>(),
				new HashMap<String, String>(), Estado.ABIERTA, new Localizacion(42, 2));

		inci6.setCamposLista("parque/caliente");
		inci6.setOperadorAsignado(operador);
		inci6.setUrlMasInfo("no");
		
		Incidencia inci7 = new Incidencia("Mariano", "Olas grandes", "Holas de 20 metros", new HashSet<String>(),
				new HashMap<String, String>(), Estado.ABIERTA, new Localizacion(43, 2.321312));

		inci7.setCamposLista("olas/grandes,mar/revuelto");
		inci7.setOperadorAsignado(operador);
		inci7.setUrlMasInfo("no");
		
		Incidencia inci8 = new Incidencia("Mirian", "Huracan", "Viento huracanado", new HashSet<String>(),
				new HashMap<String, String>(), Estado.ABIERTA, new Localizacion(36.231321, 1.9999));

		inci8.setCamposLista("viento(muy fuerte, fuerza/mucha");
		inci8.setOperadorAsignado(operador);
		inci8.setUrlMasInfo("no");
		
		Incidencia inci9 = new Incidencia("Luisa", "No se me ocurren mas", "De verdad", new HashSet<String>(),
				new HashMap<String, String>(), Estado.ANULADA, new Localizacion(39.312321, 1.123312));

		inci9.setCamposLista("prueba/test,campo2/algo");
		inci9.setOperadorAsignado(operador);
		inci9.setUrlMasInfo("no");
		
		Incidencia inci10 = new Incidencia("Maria", "Incidencia", "incidencia desc", new HashSet<String>(),
				new HashMap<String, String>(), Estado.CERRADA, new Localizacion(39.4214, 0.1432));

		inci10.setCamposLista("prueba/test,campo2/algo");
		inci10.setOperadorAsignado(operador);
		inci10.setUrlMasInfo("no");
		
		Incidencia inci11 = new Incidencia("Maria", "Incidencia", "incidencia desc", new HashSet<String>(),
				new HashMap<String, String>(), Estado.CERRADA, new Localizacion(42.32132141, 3));

		inci11.setCamposLista("prueba/test,campo2/algo");
		inci11.setOperadorAsignado(operador);
		inci11.setUrlMasInfo("no");

		incidenceRepository.save(inci);
		incidenceRepository.save(inci1);
		incidenceRepository.save(inci2);
		incidenceRepository.save(inci3);
		incidenceRepository.save(inci4);
		incidenceRepository.save(inci5);
		incidenceRepository.save(inci6);
		incidenceRepository.save(inci7);
		incidenceRepository.save(inci8);
		incidenceRepository.save(inci9);
		incidenceRepository.save(inci10);
		incidenceRepository.save(inci11);

	}

}
