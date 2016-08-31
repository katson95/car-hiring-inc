package co.uk.vehicle.inc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.uk.vehicle.inc.entity.Customer;
import co.uk.vehicle.inc.repository.ICustomerRepository;
import co.uk.vehicle.inc.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> fetchAllCustomers() {
		return customerRepository.findAll();
	}

}
