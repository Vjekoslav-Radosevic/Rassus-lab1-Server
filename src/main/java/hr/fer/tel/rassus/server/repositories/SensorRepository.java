package hr.fer.tel.rassus.server.repositories;

import hr.fer.tel.rassus.server.model.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
