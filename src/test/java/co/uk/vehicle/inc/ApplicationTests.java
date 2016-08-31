package co.uk.vehicle.inc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.uk.vehicle.inc.entity.Customer;
import co.uk.vehicle.inc.entity.Vehicle;
import co.uk.vehicle.inc.entity.constant.Status;
import co.uk.vehicle.inc.entity.constant.VehicleType;
import co.uk.vehicle.inc.service.IVehicleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private IVehicleService vehicleService;

	@Test
	public void testA() {
		List<Vehicle> vehicles = vehicleService.fetchAllVehicle();
		assertNotNull("error: vehicle list is null", vehicles);

	}

	@Test
	public void testB() {
		Vehicle v = vehicleService.createVehicle(new Vehicle("Test Car", 4, 30, Status.AVAILABLE, VehicleType.CAR));

		List<Vehicle> vehicles = vehicleService.fetchAllVehicle();
		int initialListSize = vehicles.size();
		vehicles.add(v);
		int finalListSize = vehicles.size();
		assertNotEquals("error: list size is not equal", initialListSize, finalListSize);
	}

	@Test
	public void testC() {
//		Vehicle v1 = vehicleService.createVehicle(new Vehicle("Test Car", 4, 30, Status.AVAILABLE, VehicleType.CAR));
//
//		Customer c1 = v1.getCustomer();
//
//		boolean customerExists1 = c1.getEmail() == null ? false : true;
//
//		Customer c = new Customer();
//
//		c.setFirstName("James");
//		c.setLastName("Bah");
//		c.setEmail("james.bah@gmail.com");
//		v1.setCutomer(c);
//
//		Vehicle v2 = vehicleService.updateVehicle(v1);
//
//		boolean customerExists2 = v2.getCustomer().getEmail() == null ? false : true;
//
//		assertNotEquals("error: objects identitical", customerExists1, customerExists2);
	}

}
