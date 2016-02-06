package br.com.edifacil.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.edifacil.model.Occurrence;

public interface OccurrenceRepository extends CrudRepository<Occurrence, Long> {

}
