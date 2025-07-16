package hr.fer.tel.rassus.server.mapper;

import hr.fer.tel.rassus.server.model.dto.ReadingDTO;
import hr.fer.tel.rassus.server.model.entity.Reading;
import org.springframework.stereotype.Component;

@Component
public class ReadingMapper {

	public ReadingDTO toDTO(Reading reading) {
		ReadingDTO dto = new ReadingDTO();
		dto.setId(reading.getId());
		dto.setTemperature(reading.getTemperature());
		dto.setHumidity(reading.getHumidity());
		dto.setPressure(reading.getPressure());
		dto.setCo(reading.getCo());
		dto.setNo2(reading.getNo2());
		dto.setSo2(reading.getSo2());
		return dto;
	}

	public Reading toEntity(ReadingDTO dto) {
		Reading reading = new Reading();
		reading.setTemperature(dto.getTemperature());
		reading.setHumidity(dto.getHumidity());
		reading.setPressure(dto.getPressure());
		reading.setCo(dto.getCo());
		reading.setNo2(dto.getNo2());
		reading.setSo2(dto.getSo2());
		return reading;
	}
}
