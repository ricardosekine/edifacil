package br.com.edifacil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edifacil.model.BookingType;
import br.com.edifacil.model.repository.BookingTypeRepository;


@Service
public class BookingService {
	
	
	@Autowired
	private BookingTypeRepository bookingTypeRepository;
	
	public List<BookingType> listAllBookingTypes()
	{
		List<BookingType> bookingTypes = new ArrayList<>();
		bookingTypes = (List<BookingType>) bookingTypeRepository.findAll(); 		
		return bookingTypes;
	}
}
