package br.com.edifacil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edifacil.model.OccurrenceType;
import br.com.edifacil.service.OccurrencesService;
import br.com.edifacil.vo.ReturnVO;

/**
 * The Class OccurrencesRestController.
 */
@RestController
public class OccurrencesRestController {

	/** The occurrences service. */
	@Autowired
	private OccurrencesService occurrencesService;
	
	/**
	 * List all occurrence types.
	 *
	 * @return the list
	 */
	@RequestMapping("/listAllOccurrenceTypes")
	public List<OccurrenceType> listAllOccurrenceTypes(){
		return occurrencesService.listAllOccurrenceTypes();
	}
	
	@RequestMapping("/saveOccurrence")
	public ReturnVO saveOccurrence(@RequestParam(value="description") String description, 
								   @RequestParam(value="occurrenceTypeId") Long occurrenceTypeId,
								   @RequestParam(value="userId") Long userId){
		return occurrencesService.save(description, occurrenceTypeId, userId);
	}
}
