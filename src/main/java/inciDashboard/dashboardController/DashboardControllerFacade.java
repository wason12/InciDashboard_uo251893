package inciDashboard.dashboardController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import inciDashboard.entities.Incidencia;
import inciDashboard.entities.Operator;

public interface DashboardControllerFacade {
	
	public List<Incidencia> getIncidences(Operator operario, HttpServletResponse response);
	public String ChangeState(Incidencia incidencia, Operator operario);
	public SseEmitter subscribe();

}
