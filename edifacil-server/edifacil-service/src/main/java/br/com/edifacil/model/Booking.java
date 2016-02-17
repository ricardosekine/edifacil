package br.com.edifacil.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the booking database table.
 * 
 */
@Entity
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
public class Booking implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	/** The date. */
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private Date date;
	
	@Column(name="hour")
	private String hour;
	
	/** The creation date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private Date creationDate;

	/** The booking type. */
	@ManyToOne
	@JoinColumn(name="booking_type_id")
	private BookingType bookingType;

	/** The user. */
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	/**
	 * Instantiates a new booking.
	 */
	public Booking() {
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the hour
	 */
	public String getHour() {
		return hour;
	}

	/**
	 * @param hour the hour to set
	 */
	public void setHour(String hour) {
		this.hour = hour;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the bookingType
	 */
	public BookingType getBookingType() {
		return bookingType;
	}

	/**
	 * @param bookingType the bookingType to set
	 */
	public void setBookingType(BookingType bookingType) {
		this.bookingType = bookingType;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}