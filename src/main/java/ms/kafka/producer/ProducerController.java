package ms.kafka.producer;

import lombok.RequiredArgsConstructor;
import ms.kafka.producer.model.Food;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController implements ProducerAPI {
	
	private final ProducerService service;
	
	@Override
	public void publishMessageToTopic(Food food) {
		service.publishToKafkaTopic(food);
	}
}
