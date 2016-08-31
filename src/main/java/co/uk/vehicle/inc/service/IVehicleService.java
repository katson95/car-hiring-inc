package co.uk.vehicle.inc.service;

import java.util.List;

import co.uk.vehicle.inc.entity.Vehicle;

public interface IVehicleService {
	
	public Vehicle createVehicle(Vehicle vehicle);
	
	public Vehicle updateVehicle(Vehicle vehicle);
	
	public Vehicle findVehicleById(Long vehicleId);
	
	public List<Vehicle> findVehicleByModel(String model);
	
	public List<Vehicle> fetchAllVehicle();
	
	public void deleteVehicle(Long vehicleId);

}
