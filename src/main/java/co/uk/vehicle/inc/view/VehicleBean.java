package co.uk.vehicle.inc.view;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.uk.vehicle.inc.Application;
import co.uk.vehicle.inc.controller.VehicleController;
import co.uk.vehicle.inc.entity.Vehicle;
import co.uk.vehicle.inc.entity.constant.Status;
import co.uk.vehicle.inc.entity.constant.VehicleType;

@Named
@ViewScoped
public class VehicleBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	private Vehicle vehicle;

	private List<VehicleType> vehicleTypes = new ArrayList<>();

	private List<Vehicle> vehicles = new ArrayList<>();

	@Inject
	private VehicleController vehicleController;

	public VehicleBean() {
		vehicle = new Vehicle();

		vehicleTypes.add(VehicleType.CAR);
		vehicleTypes.add(VehicleType.VAN);
		vehicleTypes.add(VehicleType.CONVERTIBLE);
		vehicleTypes.add(VehicleType.MOTORBIKE);

	}

	@PostConstruct
	void init() {
		vehicles = vehicleController.fetchAllVehicles();
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<Vehicle> getVehicles() {
		sortByRegistrationDate(vehicles);
		return vehicles;
	}

	private void sortByRegistrationDate(List<Vehicle> vLlist) {
		Collections.sort(vLlist, (v1, v2) -> v1.getRegistrationDate().compareTo(v2.getRegistrationDate()));
		Collections.reverse(vLlist);
	}

	public void triggerVehicleDetailDialog(Vehicle v) {
		setVehicle(v);
		RequestContext context = extractRequestContext();
		context.execute("PF('vehicleDetailDialog').show()");
	}

	public void triggerAddVehicleDialog() {
		vehicle = new Vehicle();
		RequestContext context = extractRequestContext();
		context.execute("PF('vehicleDialog').show()");
	}

	public void closeVehicleDetailDialog() {
		vehicle = new Vehicle();
		RequestContext context = extractRequestContext();
		context.execute("PF('vehicleDetailDialog').hide()");
	}

	public void submitVehicle() {
		LOGGER.info(vehicle.toString());
		vehicle.setStatus(Status.AVAILABLE);
		vehicle.setRegistrationDate(new Timestamp(System.currentTimeMillis()));
		Vehicle v = vehicleController.addVehicle(vehicle);
		vehicles.add(v);
		setVehicle(new Vehicle());

	}

	private RequestContext extractRequestContext() {
		RequestContext context = RequestContext.getCurrentInstance();
		return context;
	}

	public List<VehicleType> getVehicleTypes() {
		return vehicleTypes;
	}
}
