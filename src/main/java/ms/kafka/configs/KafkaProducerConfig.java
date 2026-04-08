package ms.kafka.configs;

import ms.kafka.producer.model.Food;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonSerializer;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class KafkaProducerConfig {
	
	@Value(value = "${spring.kafka.producer.bootstrap-servers}")
	private String bootstrapServers;
	
	@Bean
	public ProducerFactory<String, Food> producerFactory() {
		Map<String, Object> configurationProperties = new HashMap<>();
		configurationProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		configurationProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configurationProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JacksonJsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configurationProperties);
	}
	
	@Bean
	public KafkaTemplate<String, Food> kafkaFoodTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}
}