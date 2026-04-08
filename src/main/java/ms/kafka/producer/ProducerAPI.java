package ms.kafka.producer;

import ms.kafka.producer.model.Food;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("producer")
public interface ProducerAPI {
	
	@PostMapping("publish")
	void publishMessageToTopic(@RequestBody Food food);
}
