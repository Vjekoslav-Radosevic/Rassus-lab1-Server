package hr.fer.tel.rassus.server.services;

import hr.fer.tel.rassus.server.model.dto.SensorDTO;

import java.util.List;

public interface SensorService {

	List<SensorDTO> findAll();

	SensorDTO save(SensorDTO sensorDTO);

	SensorDTO nearestSensor(Long id);
}
