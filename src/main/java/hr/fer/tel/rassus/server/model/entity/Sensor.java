package hr.fer.tel.rassus.server.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sensor")
public class Sensor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Float latitude;

	@Column(nullable = false)
	private Float longitude;

	@Column(nullable = false)
	private String ip;

	@Column(nullable = false)
	private Integer port;

	@OneToMany(mappedBy = "sensor")
	private Set<Reading> readings;
}
