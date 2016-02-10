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


@Service
public class BookingService {
	
	
	private static String datePattern = "yyyy/MM/dd";
	
	@Autowired
	private BookingTypeRepository bookingTypeRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<BookingType> listAllBookingTypes()
	{
		List<BookingType> bookingTypes = new ArrayList<>();
		bookingTypes = (List<BookingType>) bookingTypeRepository.findAll(); 		
		return bookingTypes;
	}
	
	public CrudReturnVO save(Long userId, Long bookingTypeId, String startDate, String endDate)
	{
		CrudReturnVO returnVO = new CrudReturnVO();
		returnVO.setSuccess(false);
		
		try
		{
			if(null==userId){
				throw new EdifacilException("Usuário inválido");
			}
			
			if(null == bookingTypeId)
			{
				throw new EdifacilException("Tipo de reserva inválido");
			}
			
			if(null == startDate || startDate.isEmpty())
			{
				throw new EdifacilException("Data inicio inválida");
			}
			
			if(null == endDate || endDate.isEmpty())
			{
				throw new EdifacilException("Data fim inválida");
			}
			
			if(!isValidDate(startDate) || !isValidDate(endDate))
			{
				throw new EdifacilException("Data em formato inválido. Utilizar yyyy/mm/dd com todas casas decimais preenchidas");
			}
			
			
			Date start = (Date) new SimpleDateFormat(datePattern).parse(startDate);
			Date end = (Date) new SimpleDateFormat(datePattern).parse(startDate);
			
			Booking booking = new Booking();			
			booking.setCreationDate(new Date());
			booking.setStartDate(start);
			booking.setEndDate(end);
			
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
	
	public ListReturnVO<Booking> findBookingByDate(String startDate)
	{
		ListReturnVO<Booking> listReturnVO = new ListReturnVO<>();
		
		try {
			
			if(null == startDate || startDate.isEmpty())
			{
				throw new EdifacilException("Data inicio inválida");
			}
			
			if(!isValidDate(startDate))
			{
				throw new EdifacilException("Data em formato inválido. Utilizar yyyy/mm/dd com todas casas decimais preenchidas");
			}
			
			Date start = (Date) new SimpleDateFormat(datePattern).parse(startDate);
			List<Booking> bookinList =  bookingRepository.findByStartDate(start);
			for (Booking booking : bookinList) {
				booking.setUser(null);
			}
			listReturnVO.setReturnList(bookinList);
			
		}
		catch(EdifacilException e){
			listReturnVO.setMessage(e.getMessage());
		} catch (Exception e) {
			listReturnVO.setMessage("Erro ao executar a requisição, por favor tente mais tarde.");
		}
		return listReturnVO;
		
	}
	
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
