package hr.fer.tel.rassus.server.services.impl;

import hr.fer.tel.rassus.server.mapper.ReadingMapper;
import hr.fer.tel.rassus.server.model.dto.ReadingDTO;
import hr.fer.tel.rassus.server.model.entity.Reading;
import hr.fer.tel.rassus.server.model.entity.Sensor;
import hr.fer.tel.rassus.server.repositories.ReadingRepository;
import hr.fer.tel.rassus.server.repositories.SensorRepository;
import hr.fer.tel.rassus.server.services.ReadingService;
import hr.fer.tel.rassus.server.util.SensorException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReadingServiceImpl implements ReadingService {

	private final ReadingRepository readingRepository;
	private final SensorRepository sensorRepository;
	private final ReadingMapper readingMapper;


	public List<ReadingDTO> findAll(Long sensorId) {
		Optional<Sensor> sensor = this.sensorRepository.findById(sensorId);

		if (sensor.isEmpty()) {
			throw new SensorException(HttpStatus.NO_CONTENT, "Sensor with ID " + sensorId + " not found");
		}

		List<Reading> readings = this.readingRepository.findBySensor(sensor.get());

		return readings.stream()
			.map(readingMapper::toDTO)
			.collect(Collectors.toList());
	}

	public ReadingDTO save(Long sensorId, ReadingDTO readingDTO) {
		Sensor sensor = this.sensorRepository.findById(sensorId)
			.orElseThrow(() -> new SensorException(HttpStatus.NO_CONTENT, "Sensor with ID " + sensorId + " not found"));

		Reading reading = this.readingMapper.toEntity(readingDTO);
		reading.setSensor(sensor);

		Reading savedReading = this.readingRepository.save(reading);
		return this.readingMapper.toDTO(savedReading);
	}
}
