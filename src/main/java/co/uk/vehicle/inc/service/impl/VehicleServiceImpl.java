package co.uk.vehicle.inc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.uk.vehicle.inc.entity.Vehicle;
import co.uk.vehicle.inc.repository.IVehicleRepository;
import co.uk.vehicle.inc.service.IVehicleService;

@Service
public class VehicleServiceImpl implements IVehicleService {

	@Autowired
	private IVehicleRepository vehicleRepository;

	@Override
	public Vehicle createVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public Vehicle findVehicleById(Long vehicleId) {
		return vehicleRepository.findOne(vehicleId);
	}

	@Override
	public List<Vehicle> findVehicleByModel(String model) {
		return vehicleRepository.findByModelContaining(model);
	}

	@Override
	public List<Vehicle> fetchAllVehicle() {
		return vehicleRepository.findAll();
	}

	@Override
	public void deleteVehicle(Long vehicleId) {
		vehicleRepository.delete(vehicleId);

	}

}
