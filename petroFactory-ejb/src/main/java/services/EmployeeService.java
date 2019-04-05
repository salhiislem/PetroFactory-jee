package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Employee;
import persistence.User;
import utils.AccountState;
import utils.Role;
import utils.TypeContrat;

@Stateless
public class EmployeeService implements EmployeeServiceRemote,EmployeeServiceLocal{
	@PersistenceContext(unitName = "petroFactory-ejb")
	EntityManager entityManager;

	@Override
	public List<Employee> findAllEmployees() {
		Query query = entityManager.createQuery(
				"SELECT u FROM Employee u");
		return (List<Employee>) query.getResultList();
	}

	@Override
	public List<Employee> filterEmployeesByrole(Role role) {
		Query query = entityManager.createQuery(
				"SELECT u FROM Employee u WHERE EmployeeRole=:param");
		
		return (List<Employee>) query.setParameter("param",role).getResultList();
	}

	@Override
	public List<Employee> filterEmployeesByName(String name) {
		Query query = entityManager.createQuery(
				"SELECT u FROM Employee u WHERE lastname=:param");
		
		return (List<Employee>) query.setParameter("param",name).getResultList();
	}

	@Override
	public List<Employee> filterEmployeesByNameANDrole(String name, Role role) {
		Query query = entityManager.createQuery(
				"SELECT u FROM Employee u WHERE lastname=:param1 AND EmployeeRole=:param2");
		query.setParameter("param1",name);
		query.setParameter("param2",role);
		return (List<Employee>) query.getResultList();

		
	}
}
