package hr.fer.tel.rassus.server.services.impl;

import hr.fer.tel.rassus.server.mapper.SensorMapper;
import hr.fer.tel.rassus.server.model.dto.SensorDTO;
import hr.fer.tel.rassus.server.model.entity.Sensor;
import hr.fer.tel.rassus.server.repositories.SensorRepository;
import hr.fer.tel.rassus.server.services.SensorService;
import hr.fer.tel.rassus.server.util.SensorException;
import hr.fer.tel.rassus.server.util.SensorUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SensorServiceImpl implements SensorService {

	private final SensorRepository sensorRepository;
	private final SensorMapper sensorMapper;

	public List<SensorDTO> findAll() {
		List<Sensor> sensors = sensorRepository.findAll();
		return sensors.stream()
			.map(sensorMapper::toDTO)
			.collect(Collectors.toList());
	}

	public SensorDTO save(SensorDTO sensorDTO) {
		Sensor sensor = this.sensorMapper.toEntity(sensorDTO);
		Sensor savedSensor = this.sensorRepository.save(sensor);
		return this.sensorMapper.toDTO(savedSensor);
	}

	public SensorDTO nearestSensor(Long id) {
		List<Sensor> sensorList = this.sensorRepository.findAll();

		Optional<Sensor> mainSensor = sensorList
			.stream()
			.filter(element -> element.getId().equals(id))
			.findFirst();

		if (mainSensor.isEmpty()) {
			throw new SensorException(HttpStatus.NOT_FOUND, "Sensor with ID " + id + " not found");
		}

		sensorList.removeIf(element -> element.getId().equals(id));

		if (sensorList.isEmpty()) {
			throw new SensorException(HttpStatus.NO_CONTENT, "No other sensors available");
		}

		Sensor nearestSensor = sensorList.stream()
			.min(Comparator.comparingDouble(s -> SensorUtils.haversine(mainSensor.get(), s)))
			.orElseThrow(() -> new SensorException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to find the nearest sensor"));

		return this.sensorMapper.toDTOWithoutId(nearestSensor);
	}
}
