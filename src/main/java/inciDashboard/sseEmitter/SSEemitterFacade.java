package inciDashboard.sseEmitter;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;


public interface SSEemitterFacade {
	
	public SseEmitter RegisterOperator();
	public void UpdateViews(String incidencia);

}
