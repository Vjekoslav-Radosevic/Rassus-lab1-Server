package hr.fer.tel.rassus.server.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReadingDTO {

	private Long id;

	@NotNull(message = "Temperature is required")
	private Double temperature;

	@NotNull(message = "Pressure is required")
	private Double pressure;

	@NotNull(message = "Humidity is required")
	private Double humidity;

	private Double co;

	private Double no2;

	private Double so2;
}
