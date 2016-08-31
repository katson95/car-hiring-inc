package co.uk.vehicle.inc.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.uk.vehicle.inc.controller.BookingController;
import co.uk.vehicle.inc.entity.Booking;
import co.uk.vehicle.inc.entity.Customer;
import co.uk.vehicle.inc.entity.Vehicle;

@Named
@SessionScoped
public class BookingBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingBean.class);

	private Vehicle vehicleDetails;

	private Booking booking;

	private List<Booking> bookings = new ArrayList<>();

	@Inject
	private BookingController bookingController;

	public BookingBean() {
		vehicleDetails = new Vehicle();
		booking = new Booking();
		booking.setCustomer(new Customer());

	}

	@PostConstruct
	void init() {
		bookings = bookingController.fetchBookings();
	}

	public boolean renderCustomerDetails() {
		if (booking.getCustomer().getEmail() == null) {
			return false;
		}
		return true;
	}

	public Vehicle getVehicleDetails() {
		return vehicleDetails;
	}

	public void setVehicleDetails(Vehicle vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public List<Booking> getBookings() {
		sortByBookingDate(bookings);
		return bookings;
	}

	public String navigateToVehicleDetails(Vehicle v) {
		Booking b = bookingController.findCustomerByVehicleId(v);
		LOGGER.info(v.toString());
		this.setVehicleDetails(v);
		if (null != b) {
			this.setBooking(b);
		} else {
			booking = new Booking();
			booking.setCustomer(new Customer());
		}

		return "booking.xhtml";
	}

	public String navigateToVehicleList() {
		return "vehicle.xhtml";
	}

	public void submitBooking() {
		LOGGER.info(booking.toString());
		Booking b = bookingController.bookVehicle(booking, vehicleDetails);
		LOGGER.info(b.toString());
		RequestContext context = extractRequestContext();
		context.execute("PF('customerDetailDialog').hide()");

	}

	private RequestContext extractRequestContext() {
		RequestContext context = RequestContext.getCurrentInstance();
		return context;
	}

	private void sortByBookingDate(List<Booking> bookingLlist) {
		Collections.sort(bookingLlist, (v1, v2) -> v1.getBookedDate().compareTo(v2.getBookedDate()));
		Collections.reverse(bookingLlist);
	}

}
