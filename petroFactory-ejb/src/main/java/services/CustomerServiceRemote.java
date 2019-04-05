package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Customer;

@Remote
public interface CustomerServiceRemote {
	public List<Customer> findAllCustomers();
	public List<Customer> filterCustomerByName(String name);


}
