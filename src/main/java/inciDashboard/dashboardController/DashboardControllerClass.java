package inciDashboard.dashboardController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import inciDashboard.entities.Incidencia;
import inciDashboard.entities.Operator;
import inciDashboard.inciRepository.InciRepositoryFacade;
import inciDashboard.sseEmitter.SSEemitterFacade;

@RestController
public class DashboardControllerClass implements DashboardControllerFacade, NewIncidence {

	@Autowired 
	private SSEemitterFacade sseEmitter;
	
	@Autowired
	private InciRepositoryFacade inciRepository;

	@Override
	@RequestMapping(value = "/getincidences")
	public List<Incidencia> getIncidences(@RequestBody Operator operario, HttpServletResponse response) {
		System.out.println(operario);
		Operator savedOperator = inciRepository.checkOperador(operario);
		if(savedOperator != null) {
			List<Incidencia> incidencias = inciRepository.IncidencesInfo();
			
			response.setStatus(202);
			
			return incidencias;
		}
		
		response.setStatus(404);
		response.setHeader("error", "Email o password incorrectos");
		
		return null;
	}

	@Override
	@RequestMapping(value = "/changestate", method = RequestMethod.PUT)
	public String ChangeState(Incidencia incidencia, Operator operario) {
		Operator savedOperator = inciRepository.checkOperador(operario);
		if(savedOperator != null) {
			inciRepository.UpdateIncidence(incidencia);
			
			return "exito";
		}
		
		
		return "error";
	}

	@Override
	public SseEmitter subscribe() {
		SseEmitter emitter = sseEmitter.RegisterOperator();
		
		return emitter;
	}
	
	@Override
	public void notify(String incidencia) {
		sseEmitter.UpdateViews(incidencia);
	}

}
