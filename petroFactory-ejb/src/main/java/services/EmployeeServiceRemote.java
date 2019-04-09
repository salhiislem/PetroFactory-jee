package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Employee;
import persistence.User;
import utils.Role;

@Remote
public interface EmployeeServiceRemote {
	public List<Employee> findAllEmployees();
	public List<Employee> filterEmployeesByrole(Role role);
	public List<Employee> filterEmployeesByName(String name);
	public List<Employee> filterEmployeesByNameANDrole(String name,Role role);
	public void updateEmployee(Employee emp);

}
