package br.com.edifacil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edifacil.model.Booking;
import br.com.edifacil.model.BookingType;
import br.com.edifacil.service.BookingService;
import br.com.edifacil.vo.CrudReturnVO;
import br.com.edifacil.vo.ListReturnVO;


@RestController
public class BookingRestController {

	@Autowired
	private BookingService bookingService;
	
	@RequestMapping("/listAllBookingTypes")
	public List<BookingType> listAllBookingTypes(){
		return bookingService.listAllBookingTypes();
	}
	

	@RequestMapping("/saveBooking")
	public CrudReturnVO saveBooking(@RequestParam(value="userId") Long userId, 
			   @RequestParam(value="bookingTypeId") Long bookingTypeId,
			   @RequestParam(value="startDate") String startDate,
			   @RequestParam(value="endDate") String endDate){
		return bookingService.save(userId, bookingTypeId, startDate, endDate);
	}
	
	@RequestMapping("/cancelBooking")
	public CrudReturnVO cancelBooking(@RequestParam(value="bookingId") Long bookingId){
		return bookingService.delete(bookingId);
	}
	
	@RequestMapping("/listBookingByStartDate")
	public ListReturnVO<Booking> cancelBooking(@RequestParam(value="startDate") String startDate){
		return bookingService.findBookingByDate(startDate);
	}
	
	@RequestMapping("/bookingLimitTime")
	public Integer bookingLimitTime(){
		return 30;
	}

}
