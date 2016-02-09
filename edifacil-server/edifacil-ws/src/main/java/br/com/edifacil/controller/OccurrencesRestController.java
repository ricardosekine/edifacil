package br.com.edifacil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edifacil.model.Occurrence;
import br.com.edifacil.model.OccurrenceType;
import br.com.edifacil.service.OccurrencesService;
import br.com.edifacil.vo.CrudReturnVO;
import br.com.edifacil.vo.ListReturnVO;

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
	
	/**
	 * Save occurrence.
	 *
	 * @param description the description
	 * @param occurrenceTypeId the occurrence type id
	 * @param userId the user id
	 * @return the crud return vo
	 */
	@RequestMapping("/saveOccurrence")
	public CrudReturnVO saveOccurrence(@RequestParam(value="description") String description, 
								   @RequestParam(value="occurrenceTypeId") Long occurrenceTypeId,
								   @RequestParam(value="userId") Long userId){
		return occurrencesService.save(description, occurrenceTypeId, userId);
	}
	
	/**
	 * List occurrences by user.
	 *
	 * @param userId the user id
	 * @return the list return vo
	 */
	@RequestMapping("/listOccurrencesByUser")
	public ListReturnVO<Occurrence> listOccurrencesByUser(@RequestParam(value="userId") Long userId){
		return occurrencesService.findOccurrencesByUser(userId);
	}
	
	/**
	 * List all occurrences.
	 *
	 * @return the list
	 */
	@RequestMapping("/listAllOccurrences")
	public List<Occurrence> listAllOccurrences(){
		return occurrencesService.listAllOccurrences();
	}
	
	/**
	 * Update occurrence status.
	 *
	 * @param occurrenceId the occurrence id
	 * @param status the status
	 * @return the crud return vo
	 */
	@RequestMapping("/updateOccurrenceStatus")
	public CrudReturnVO updateOccurrenceStatus(@RequestParam(value="occurenceId") Long occurrenceId, @RequestParam(value="status") String status){
		return occurrencesService.updateStatus(occurrenceId, status);
	}
}
