package br.com.edifacil.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.edifacil.model.Occurrence;
import br.com.edifacil.model.User;

/**
 * The Interface OccurrenceRepository.
 */
public interface OccurrenceRepository extends CrudRepository<Occurrence, Long> {

	/**
	 * Find by user.
	 *
	 * @param user the user
	 * @return the occurrence
	 */
	public List<Occurrence> findByUser(User user);
	
}
