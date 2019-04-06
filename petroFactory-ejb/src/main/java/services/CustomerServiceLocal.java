package services;

import java.util.List;

import javax.ejb.Local;

import persistence.Customer;

@Local
public interface CustomerServiceLocal {
	public List<Customer> findAllCustomers();
	public List<Customer> filterCustomerByName(String name);


}
