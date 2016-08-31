package co.uk.vehicle.inc.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.uk.vehicle.inc.entity.Vehicle;
import co.uk.vehicle.inc.entity.constant.Status;
import co.uk.vehicle.inc.service.IVehicleService;

@Controller
public class VehicleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(VehicleController.class);

	@Autowired
	private IVehicleService vehicleService;

	public VehicleController() {
		LOGGER.info("");
	}

	public Vehicle addVehicle(Vehicle v) {
		Vehicle vehicle = vehicleService.createVehicle(v);
		return vehicle;
	}

	public List<Vehicle> fetchAllVehicles() {
		List<Vehicle> vehicleList = vehicleService.fetchAllVehicle();
		if (null != vehicleList) {
			return vehicleList;
		}
		return new ArrayList<>();
	}

	public Vehicle updateVehicle(Vehicle vehicleDetails) {
		vehicleDetails.setStatus(Status.BOOKED);
		Vehicle vehicle = vehicleService.updateVehicle(vehicleDetails);
		return vehicle;
	}

	public Vehicle findVehicleById(long vehicleId) {
		Vehicle vehicle = vehicleService.findVehicleById(vehicleId);
		return vehicle;
	}

}
