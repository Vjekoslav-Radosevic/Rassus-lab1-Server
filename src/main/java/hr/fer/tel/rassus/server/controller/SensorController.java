package hr.fer.tel.rassus.server.controller;

import hr.fer.tel.rassus.server.model.dto.SensorDTO;
import hr.fer.tel.rassus.server.services.SensorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sensors")
public class SensorController {

	private final SensorService sensorService;

	@GetMapping("")
	public List<SensorDTO> findAll() {
		return this.sensorService.findAll();
	}

	@PostMapping("")
	public ResponseEntity<SensorDTO> save(
		@Valid @RequestBody SensorDTO sensor
	) {
		SensorDTO savedSensorDTO = this.sensorService.save(sensor);

		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest() // http://localhost:8080/sensors
			.path("/{id}") // adds /{id} to the path
			.buildAndExpand(savedSensorDTO.getId()) // inserts savedSensorDTO's id in the place of {id}
			.toUri(); //converts to URI object

		return ResponseEntity.status(HttpStatus.CREATED)
			.header(HttpHeaders.LOCATION, location.toString())
			.body(savedSensorDTO);
	}

	@GetMapping("/{id}/nearest-sensor")
	public SensorDTO nearestSensor(
		@PathVariable Long id
	) {
		return this.sensorService.nearestSensor(id);
	}
}
