package co.uk.vehicle.inc.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.uk.vehicle.inc.controller.CustomerController;
import co.uk.vehicle.inc.entity.Customer;

@Named
@ViewScoped
public class CustomerBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerBean.class);

	private List<Customer> customers = new ArrayList<>();

	private Customer customer;

	@Inject
	private CustomerController customerController;

	public CustomerBean() {

	}

	@PostConstruct
	void init() {
		customers = customerController.fetchCustomers();
		LOGGER.info("Customer size " + customers.size());

	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public String navigateToCustomers() {
		return "customer.xhtml";
	}

}
