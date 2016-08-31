package co.uk.vehicle.inc.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.uk.vehicle.inc.entity.Customer;
import co.uk.vehicle.inc.service.ICustomerService;

@Controller
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private ICustomerService custmerService;

	public CustomerController() {
		LOGGER.info("Customer controller initialized...");
	}

	public List<Customer> fetchCustomers() {
		List<Customer> customerList = custmerService.fetchAllCustomers();
		if (null != customerList) {
			return customerList;
		}
		return new ArrayList<>();
	}

	public Customer updateCustomer(Customer customer) {
		Customer c = custmerService.updateCustomer(customer);
		return c;
	}

}
