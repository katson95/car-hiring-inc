package co.uk.vehicle.inc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.uk.vehicle.inc.entity.Vehicle;

public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {
	
	
    List<Vehicle> findByModelContaining(String model);


}
