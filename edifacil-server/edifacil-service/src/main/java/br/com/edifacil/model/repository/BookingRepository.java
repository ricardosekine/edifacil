package br.com.edifacil.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.edifacil.model.Booking;


public interface BookingRepository extends CrudRepository<Booking, Long> {
	
	public List<Booking> findByStartDate(Date startDate);

}
