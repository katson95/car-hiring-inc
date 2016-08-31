package co.uk.vehicle.inc.service;

import java.util.List;

import co.uk.vehicle.inc.entity.Booking;
import co.uk.vehicle.inc.entity.Vehicle;

public interface IBookingService {
	
	public Booking bookVehicle(Booking bokking);

	public Booking findBookingByVehicleId(Vehicle v);
	
	public List<Booking> fetchBookings();

}
