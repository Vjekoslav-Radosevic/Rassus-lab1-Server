package hr.fer.tel.rassus.server.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reading")
public class Reading {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Double temperature;

	@Column(nullable = false)
	private Double pressure;

	@Column(nullable = false)
	private Double humidity;

	@Column
	private Double co;

	@Column
	private Double no2;

	@Column
	private Double so2;

	@ManyToOne
	@JoinColumn(name = "sensor_id", nullable = false)
	private Sensor sensor;
}
