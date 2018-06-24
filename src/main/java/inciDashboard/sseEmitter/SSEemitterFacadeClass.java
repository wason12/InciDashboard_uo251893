package inciDashboard.sseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Component
public class SSEemitterFacadeClass implements SSEemitterFacade {

	public List<SseEmitter> emitters = Collections.synchronizedList(new ArrayList<SseEmitter>());
	private long timeout = Long.MAX_VALUE;

	@Override
	public SseEmitter RegisterOperator() {
		SseEmitter emitter = new SseEmitter(timeout);

		emitter.onCompletion(() -> emitters.remove(emitter));
		emitter.onTimeout(() -> emitters.remove(emitter));

		emitters.add(emitter);

		return emitter;
	}

	@Override
	public void UpdateViews(String incidencia) {
		synchronized (this.emitters) {
			for (Iterator<SseEmitter> iter = emitters.iterator() ; iter.hasNext() ; ) {
				SseEmitter emitter = iter.next();
				try {
					emitter.send(incidencia, MediaType.APPLICATION_JSON);
				} catch (IOException e) {
					emitter.complete();
				}
			}
		}
	}

}
