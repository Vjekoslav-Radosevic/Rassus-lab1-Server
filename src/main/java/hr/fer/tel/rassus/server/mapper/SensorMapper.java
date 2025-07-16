package hr.fer.tel.rassus.server.mapper;

import hr.fer.tel.rassus.server.model.dto.SensorDTO;
import hr.fer.tel.rassus.server.model.entity.Sensor;
import org.springframework.stereotype.Component;

@Component
public class SensorMapper {

	// it would be better if methods below were static

	public SensorDTO toDTO(Sensor sensor) {
		SensorDTO dto = new SensorDTO();
		dto.setId(sensor.getId());
		dto.setLatitude(sensor.getLatitude());
		dto.setLongitude(sensor.getLongitude());
		dto.setIp(sensor.getIp());
		dto.setPort(sensor.getPort());
		return dto;
	}

	public SensorDTO toDTOWithoutId(Sensor sensor) {
		SensorDTO dto = new SensorDTO();
		dto.setLatitude(sensor.getLatitude());
		dto.setLongitude(sensor.getLongitude());
		dto.setIp(sensor.getIp());
		dto.setPort(sensor.getPort());
		return dto;
	}

	public Sensor toEntity(SensorDTO dto) {
		Sensor sensor = new Sensor();
		sensor.setLatitude(dto.getLatitude());
		sensor.setLongitude(dto.getLongitude());
		sensor.setIp(dto.getIp());
		sensor.setPort(dto.getPort());
		return sensor;
	}
}
