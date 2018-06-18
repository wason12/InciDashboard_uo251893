package inciDashboard.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import inciDashboard.dashboardController.NewIncidence;

import javax.annotation.ManagedBean;

@ManagedBean
public class Listener {
	
	@Autowired
	private NewIncidence newIncidence;
	
	@KafkaListener(topics = "incidencia")
    public void listen(String data) {
        System.out.println("New message received: \"" + data + "\"");
        newIncidence.notify(data);
}

}
