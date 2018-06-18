package inciDashboard.sseEmitter;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import inciDashboard.entities.Incidencia;

public interface SSEemitterFacade {
	
	public SseEmitter RegisterOperator();
	public void UpdateViews(Incidencia incidencia);

}
