package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;

import edu.poly.shop.domain.Customer;

public interface CustomerService {

	void deleteById(Integer id);

	long count();

	Optional<Customer> findById(Integer id);

	List<Customer> findAll();

	<S extends Customer> S save(S entity);
	
}
