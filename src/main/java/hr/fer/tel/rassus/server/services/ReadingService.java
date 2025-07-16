package hr.fer.tel.rassus.server.services;

import hr.fer.tel.rassus.server.model.dto.ReadingDTO;

import java.util.List;

public interface ReadingService {

	List<ReadingDTO> findAll(Long id);

	ReadingDTO save(Long id, ReadingDTO readingDTO);
}
