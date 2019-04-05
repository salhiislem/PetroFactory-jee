package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Customer;
import persistence.Employee;
@Stateless
public class CustomerService implements CustomerServiceLocal,CustomerServiceRemote{
	@PersistenceContext(unitName = "petroFactory-ejb")
	EntityManager entityManager;
	@Override
	public List<Customer> findAllCustomers() {
		Query query = entityManager.createQuery(
				"SELECT u FROM Customer u");
		return (List<Customer>) query.getResultList();
	}
	@Override
	public List<Customer> filterCustomerByName(String name) {
		Query query = entityManager.createQuery(
				"SELECT u FROM Customer u WHERE lasttname=:param");
		
		return (List<Customer>) query.setParameter("param",name).getResultList();
	}

}
