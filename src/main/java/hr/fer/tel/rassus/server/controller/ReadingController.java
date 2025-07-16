package hr.fer.tel.rassus.server.controller;

import hr.fer.tel.rassus.server.model.dto.ReadingDTO;
import hr.fer.tel.rassus.server.services.ReadingService;
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
public class ReadingController {

	private final ReadingService readingService;

	@GetMapping("/{sensorId}/readings")
	public List<ReadingDTO> findAll(
		@PathVariable Long sensorId
	) {
		return this.readingService.findAll(sensorId);
	}

	@PostMapping("/{sensorId}/readings")
	public ResponseEntity<ReadingDTO> save(
		@PathVariable Long sensorId,
		@Valid @RequestBody ReadingDTO readingDTO
	) {
		ReadingDTO savedReadingDTO = this.readingService.save(sensorId, readingDTO);

		URI location = ServletUriComponentsBuilder
			.fromCurrentContextPath() // http://localhost:8080
			.path("/readings/{id}")   // adds /readings/{id} to the path
			.buildAndExpand(savedReadingDTO.getId())
			.toUri(); // converts to URI object

		return ResponseEntity.status(HttpStatus.CREATED)
			.header(HttpHeaders.LOCATION, location.toString())
			.body(savedReadingDTO);
	}
}
