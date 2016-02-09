package br.com.edifacil.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edifacil.exception.EdifacilException;
import br.com.edifacil.model.Occurrence;
import br.com.edifacil.model.OccurrenceType;
import br.com.edifacil.model.User;
import br.com.edifacil.model.repository.OccurrenceRepository;
import br.com.edifacil.model.repository.OccurrenceTypeRepository;
import br.com.edifacil.model.repository.UserRepository;
import br.com.edifacil.vo.CrudReturnVO;
import br.com.edifacil.vo.ListReturnVO;

/**
 * The Class OccurrencesService.
 */
@Service
public class OccurrencesService {

	/** The occurrence repository. */
	@Autowired
	private OccurrenceRepository occurrenceRepository;
	
	/** The occurrence type repository. */
	@Autowired
	private OccurrenceTypeRepository occurrenceTypeRepository;
	
	/** The user service. */
	@Autowired
	private UserRepository userRepository;
	
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
	
	/**
	 * List all occurrences.
	 *
	 * @return the list
	 */
	public List<Occurrence> listAllOccurrences(){
		List<Occurrence> occurrences = new ArrayList<>();
		occurrences = (List<Occurrence>) occurrenceRepository.findAll();
		for (Occurrence occurrence : occurrences) {
			occurrence.setUser(null);
		}
		return occurrences;
	}
	
	/**
	 * Save.
	 *
	 * @param description the description
	 * @param occurrenceTypeId the occurrence type id
	 * @param userId the user id
	 * @return the return vo
	 */
	public CrudReturnVO save(String description, Long occurrenceTypeId, Long userId){
		
		CrudReturnVO returnVO = new CrudReturnVO();
		returnVO.setSuccess(false);
		
		try {
			
			if(null==description || description.isEmpty()){
				throw new EdifacilException("Favor preencher a descrição");
			}
			
			if (null==occurrenceTypeId) {
				throw new EdifacilException("Tipo de ocorrência inválido");
			}
			
			if(null==userId){
				throw new EdifacilException("Usuário inválido");
			}
			
			Occurrence occurrence = new Occurrence();
			occurrence.setCreationDate(new Date());
			occurrence.setDescription(description);
			occurrence.setStatus("Em aberto");
			
			OccurrenceType occurrenceType = occurrenceTypeRepository.findOne(occurrenceTypeId);
			occurrence.setOccurrenceType(occurrenceType);
			
			User user = userRepository.findOne(userId);
			occurrence.setUser(user);
			
			occurrenceRepository.save(occurrence);
			
			returnVO.setMessage("Ocorrência cadastrada com sucesso!");
			returnVO.setSuccess(true);

		} catch (EdifacilException e) {
			returnVO.setMessage(e.getMessage());
		} catch (Exception e) {
			returnVO.setMessage("Erro ao executar a requisição, por favor tente mais tarde.");
		}
		return returnVO;
	}
	
	
	/**
	 * Find.
	 *
	 * @param userId the user id
	 * @return the list
	 */
	public ListReturnVO<Occurrence> findOccurrencesByUser(final Long userId){
		
		ListReturnVO<Occurrence> listReturnVO = new ListReturnVO<>();
		
		try {
			
			if(null==userId){
				throw new EdifacilException("Usuário inválido");
			}
			
			User user = userRepository.findOne(userId);
			List<Occurrence> occurrences = occurrenceRepository.findByUser(user);
			for (Occurrence occurrence : occurrences) {
				occurrence.setUser(null);
			}
			listReturnVO.setReturnList(occurrences);
			
		} catch(EdifacilException e){
			listReturnVO.setMessage(e.getMessage());
		} catch (Exception e) {
			listReturnVO.setMessage("Erro ao executar a requisição, por favor tente mais tarde.");
		}
		return listReturnVO;
	}
	
	
	/**
	 * Update status.
	 *
	 * @param occurenceId the occurence id
	 * @param status the status
	 * @return the crud return vo
	 */
	public CrudReturnVO updateStatus(Long occurenceId, String status){
		
		CrudReturnVO returnVO = new CrudReturnVO();
		returnVO.setSuccess(false);
		
		try {
			
			Occurrence occurrenceToUpdate = occurrenceRepository.findOne(occurenceId);
			occurrenceToUpdate.setStatus(status);
			occurrenceRepository.save(occurrenceToUpdate);
						
		} catch (Exception e) {
			returnVO.setMessage("Erro ao executar a requisição, por favor tente mais tarde.");
		}
		return returnVO;
	}
}
