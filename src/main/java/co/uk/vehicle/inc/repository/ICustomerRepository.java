package co.uk.vehicle.inc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.uk.vehicle.inc.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

}
