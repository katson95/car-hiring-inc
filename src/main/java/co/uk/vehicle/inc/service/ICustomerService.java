package co.uk.vehicle.inc.service;

import java.util.List;

import co.uk.vehicle.inc.entity.Customer;

public interface ICustomerService {

	public List<Customer> fetchAllCustomers();

	public Customer updateCustomer(Customer customer);

}
