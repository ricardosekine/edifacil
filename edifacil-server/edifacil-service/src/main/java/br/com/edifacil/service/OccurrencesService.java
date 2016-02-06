package br.com.edifacil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.edifacil.model.OccurrenceType;

/**
 * The Class OccurrencesService.
 */
@Service
public class OccurrencesService {

	/**
	 * List all occurrence types.
	 *
	 * @return the list
	 */
	public List<OccurrenceType> listAllOccurrenceTypes(){
		
		List<OccurrenceType> occurrenceTypes = new ArrayList<>();
		
		return occurrenceTypes;
	}
	
}
