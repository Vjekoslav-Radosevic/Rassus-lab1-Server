package hr.fer.tel.rassus.server.controller;

import hr.fer.tel.rassus.server.util.SensorException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(SensorException.class)
	public ResponseEntity<Map<String, String>> handleSensorNotFoundException(SensorException ex) {
		Map<String, String> response = new HashMap<>();
		response.put("error", ex.getMessage());

		return ResponseEntity.status(ex.getStatus()).body(response);
	}
}
