package co.uk.vehicle.inc.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.uk.vehicle.inc.entity.Booking;
import co.uk.vehicle.inc.entity.Customer;
import co.uk.vehicle.inc.entity.Vehicle;
import co.uk.vehicle.inc.service.IBookingService;

@Controller
public class BookingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);

	@Autowired
	private VehicleController vehicleController;
	
	@Autowired
	private CustomerController customerController;

	@Autowired
	private IBookingService bookingService;

	public Booking bookVehicle(Booking booking, Vehicle vehicleDetails) {
		Vehicle v = vehicleController.findVehicleById(vehicleDetails.getId());
		
		booking.setVehicle(v);
		Booking b = bookingService.bookVehicle(booking);
		
		Customer customer = b.getCustomer();
		customer.getBookings().add(b);
		Customer c = customerController.updateCustomer(customer);
		LOGGER.info(b.toString());
		LOGGER.info(c.toString());
		return b;

	}

	public Booking findCustomerByVehicleId(Vehicle vehicle) {
		Booking booking = bookingService.findBookingByVehicleId(vehicle);
		return booking;
	}
	
	public List<Booking> fetchBookings() {
		List<Booking> bookingList = bookingService.fetchBookings();
		if (null != bookingList) {
			return bookingList;
		}
		return new ArrayList<>();
	}

}
