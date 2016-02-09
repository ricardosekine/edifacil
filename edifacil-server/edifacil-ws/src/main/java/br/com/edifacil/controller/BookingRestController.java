package br.com.edifacil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edifacil.model.BookingType;
import br.com.edifacil.service.BookingService;


@RestController
public class BookingRestController {

	@Autowired
	private BookingService bookingService;
	
	@RequestMapping("/listAllBookingTypes")
	public List<BookingType> listAllBookingTypes(){
		return bookingService.listAllBookingTypes();
	}
	
}
