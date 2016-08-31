package co.uk.vehicle.inc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.uk.vehicle.inc.entity.Booking;
import co.uk.vehicle.inc.entity.Vehicle;

public interface IBookingRepository extends JpaRepository<Booking, Long> {
	
		public Booking findByVehicle(Vehicle v);
}
