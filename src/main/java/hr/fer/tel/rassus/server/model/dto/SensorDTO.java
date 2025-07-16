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
public class SensorDTO {

	private Long id;

	@NotNull(message = "Latitude is required")
	private Float latitude;

	@NotNull(message = "Longitude is required")
	private Float longitude;

	@NotNull(message = "IP address is required")
	private String ip;

	@NotNull(message = "Port is required")
	private Integer port;
}
