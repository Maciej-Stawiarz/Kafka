package ms.kafka.producer;

import lombok.RequiredArgsConstructor;
import ms.kafka.producer.model.Food;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {
	
	@Value(value = "${spring.kafka.producer.topic-name}")
	private String producerTopicName;
	private final KafkaTemplate<String, Food> kafkaFoodTemplate;
	
	public void publishToKafkaTopic(Food food) {
		System.out.println("\nKafka topic: " + producerTopicName);
		kafkaFoodTemplate.send(producerTopicName, food);
	}
}
