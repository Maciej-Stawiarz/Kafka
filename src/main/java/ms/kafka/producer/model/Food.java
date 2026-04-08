package ms.kafka.producer.model;

public record Food(
		Long id,
		String name,
		Double price,
		Taste taste) {

}