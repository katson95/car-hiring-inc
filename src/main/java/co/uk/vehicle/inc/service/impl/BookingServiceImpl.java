package co.uk.vehicle.inc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.uk.vehicle.inc.entity.Booking;
import co.uk.vehicle.inc.entity.Vehicle;
import co.uk.vehicle.inc.repository.IBookingRepository;
import co.uk.vehicle.inc.service.IBookingService;

@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingRepository bookingRepository;

	@Override
	@Transactional
	public Booking bookVehicle(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public Booking findBookingByVehicleId(Vehicle v) {
		return bookingRepository.findByVehicle(v);
	}

	@Override
	public List<Booking> fetchBookings() {
		return bookingRepository.findAll();
	}

}
