package hr.fer.tel.rassus.server.util;

import org.springframework.http.HttpStatus;

public class SensorException extends RuntimeException {
	private final HttpStatus status;

	public SensorException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
