package br.com.edifacil.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.edifacil.model.Booking;
import br.com.edifacil.model.BookingType;

/**
 * The Interface BookingRepository.
 */
public interface BookingRepository extends CrudRepository<Booking, Long> {
	
	/**
	 * Find by date.
	 *
	 * @param startDate the start date
	 * @return the list
	 */
	public List<Booking> findByDate(Date date);
	
	/**
	 * Find by date and booking type.
	 *
	 * @param date the date
	 * @param bookingType the booking type
	 * @return the list
	 */
	public List<Booking> findByDateAndBookingType(Date date, BookingType bookingType);

}
