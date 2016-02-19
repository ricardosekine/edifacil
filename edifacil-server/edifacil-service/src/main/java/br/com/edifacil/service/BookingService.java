package br.com.edifacil.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edifacil.exception.EdifacilException;
import br.com.edifacil.model.Booking;
import br.com.edifacil.model.BookingType;
import br.com.edifacil.model.User;
import br.com.edifacil.model.repository.BookingRepository;
import br.com.edifacil.model.repository.BookingTypeRepository;
import br.com.edifacil.model.repository.UserRepository;
import br.com.edifacil.vo.CrudReturnVO;
import br.com.edifacil.vo.ListReturnVO;

/**
 * The Class BookingService.
 */
@Service
public class BookingService {
	
	
	/** The date pattern. */
	private static final String DATE_PATTERN = "yyyy/MM/dd";
	
	/** The booking type repository. */
	@Autowired
	private BookingTypeRepository bookingTypeRepository;
	
	/** The booking repository. */
	@Autowired
	private BookingRepository bookingRepository;
	
	/** The user repository. */
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * List all booking types.
	 *
	 * @return the list
	 */
	public List<BookingType> listAllBookingTypes()
	{
		List<BookingType> bookingTypes = new ArrayList<>();
		bookingTypes = (List<BookingType>) bookingTypeRepository.findAll(); 		
		return bookingTypes;
	}
	
	/**
	 * Save.
	 *
	 * @param userId the user id
	 * @param bookingTypeId the booking type id
	 * @param date the date
	 * @param hour the hour
	 * @return the crud return vo
	 */
	public CrudReturnVO save(Long userId, Long bookingTypeId, String date, String hour)
	{
		CrudReturnVO returnVO = new CrudReturnVO();
		returnVO.setSuccess(false);
		
		try
		{
			if(null==userId){
				throw new EdifacilException("Usuário inválido");
			}
			
			if(null == bookingTypeId){
				throw new EdifacilException("Tipo de reserva inválido");
			}
			
			if(null == date || date.isEmpty()){
				throw new EdifacilException("Data inválida");
			}
			
			if(null == hour || hour.isEmpty()){
				throw new EdifacilException("Hora inválida");
			}
			
			Date bookingDate = (Date) new SimpleDateFormat(DATE_PATTERN).parse(date);
			
			Booking booking = new Booking();			
			booking.setCreationDate(new Date());
			booking.setDate(bookingDate);
			booking.setHour(hour);
			
			User user = userRepository.findOne(userId);
			booking.setUser(user);
			
			BookingType bookingType = bookingTypeRepository.findOne(bookingTypeId);
			booking.setBookingType(bookingType);
			
			bookingRepository.save(booking);
			
			returnVO.setMessage("Reserva cadastrada com sucesso!");
			returnVO.setSuccess(true);
		}
		catch (EdifacilException e) {
			returnVO.setMessage(e.getMessage());
		} catch (Exception e) {
			returnVO.setMessage("Erro ao executar a requisição, por favor tente mais tarde.");
		}
		return returnVO;
	}
	
	
	/**
	 * Delete.
	 *
	 * @param bookingId the booking id
	 * @return the crud return vo
	 */
	public CrudReturnVO delete(Long bookingId)
	{
		CrudReturnVO returnVO = new CrudReturnVO();
		returnVO.setSuccess(false);
		
		try
		{
			if(null == bookingId)
			{
				throw new EdifacilException("Reserva inválida");
			}
			
			Booking booking = bookingRepository.findOne(bookingId);
			bookingRepository.delete(booking);
			
			returnVO.setMessage("Reserva cancelada com sucesso!");
			returnVO.setSuccess(true);
			
		}
		catch (EdifacilException e) {
			returnVO.setMessage(e.getMessage());
		} catch (Exception e) {
			returnVO.setMessage("Erro ao executar a requisição, por favor tente mais tarde.");
		}
		
		return returnVO;
	}
	
	/**
	 * Find booking by date.
	 *
	 * @param date the start date
	 * @return the list return vo
	 */
	public ListReturnVO<Booking> findBookingByDate(String date)
	{
		ListReturnVO<Booking> listReturnVO = new ListReturnVO<>();
		
		try {
			
			if(null == date || date.isEmpty())
			{
				throw new EdifacilException("Data inválida");
			}
			
			if(!isValidDate(date))
			{
				throw new EdifacilException("Data em formato inválido. Utilizar yyyy/mm/dd com todas casas decimais preenchidas");
			}
			
			Date start = (Date) new SimpleDateFormat(DATE_PATTERN).parse(date);
			List<Booking> bookingList =  bookingRepository.findByDate(start);
			hideUserFields(bookingList);
			listReturnVO.setReturnList(bookingList);
			
		}
		catch(EdifacilException e){
			listReturnVO.setMessage(e.getMessage());
		} catch (Exception e) {
			listReturnVO.setMessage("Erro ao executar a requisição, por favor tente mais tarde.");
		}
		return listReturnVO;
		
	}
	
	/**
	 * List booking by date and booking type.
	 *
	 * @param date the date
	 * @param bookingTypeId the booking type id
	 * @return the list return vo
	 */
	public ListReturnVO<Booking> listBookingByDateAndBookingType(String date, Long bookingTypeId)
	{
		ListReturnVO<Booking> listReturnVO = new ListReturnVO<>();
		
		try {
			
			if(null == date || date.isEmpty()){
				throw new EdifacilException("Data inválida");
			}
			if(!isValidDate(date)){
				throw new EdifacilException("Data em formato inválido. Utilizar yyyy/mm/dd com todas casas decimais preenchidas");
			}
			if(null == bookingTypeId){
				throw new EdifacilException("Tipo de reserva inválido");
			}
			
			Date bookingDate = (Date) new SimpleDateFormat(DATE_PATTERN).parse(date);
			BookingType bookingType = bookingTypeRepository.findOne(bookingTypeId);
			List<Booking> bookingList =  bookingRepository.findByDateAndBookingType(bookingDate, bookingType);
			
			hideUserFields(bookingList);
			listReturnVO.setReturnList(bookingList);
		}
		catch(EdifacilException e){
			listReturnVO.setMessage(e.getMessage());
		} catch (Exception e) {
			listReturnVO.setMessage("Erro ao executar a requisição, por favor tente mais tarde.");
		}
		return listReturnVO;
		
	}

	/**
	 * Hide user fields.
	 *
	 * @param bookingList the booking list
	 */
	private void hideUserFields(List<Booking> bookingList) {
		for (Booking booking : bookingList) {
			booking.getUser().setName(null);
			booking.getUser().setPassword(null);
			booking.getUser().setLogged(null);
		}
	}
	
	/**
	 * Checks if is valid date.
	 *
	 * @param date the date
	 * @return the boolean
	 */
	private Boolean isValidDate(String date)
	{
		Boolean ret = true;
		if(date.length() != 10)
		{
			return false;
		}
		return ret;
	}
	
}
