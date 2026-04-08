package ms.kafka.producer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductErrorAdvisor {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> illegalArgumentExceptionHandler(Throwable throwable) {
		return new ResponseEntity<>(
				"This is a message from exception handler!",
				HttpStatus.BAD_REQUEST
		);
	}
}