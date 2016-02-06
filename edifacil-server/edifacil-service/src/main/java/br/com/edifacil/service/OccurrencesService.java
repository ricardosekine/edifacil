package br.com.edifacil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edifacil.model.OccurrenceType;
import br.com.edifacil.model.repository.OccurrenceRepository;
import br.com.edifacil.model.repository.OccurrenceTypeRepository;

/**
 * The Class OccurrencesService.
 */
@Service
public class OccurrencesService {

	@Autowired
	private OccurrenceRepository occurrenceRepository;
	
	@Autowired
	private OccurrenceTypeRepository occurrenceTypeRepository;
	
	/**
	 * List all occurrence types.
	 *
	 * @return the list
	 */
	public List<OccurrenceType> listAllOccurrenceTypes(){
		List<OccurrenceType> occurrenceTypes = new ArrayList<>();
		occurrenceTypes = (List<OccurrenceType>) occurrenceTypeRepository.findAll(); 
		return occurrenceTypes;
	}
	
}
