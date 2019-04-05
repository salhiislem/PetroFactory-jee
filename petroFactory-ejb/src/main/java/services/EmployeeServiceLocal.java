package services;

import java.util.List;

import javax.ejb.Local;

import persistence.Employee;
import utils.Role;

@Local
public interface EmployeeServiceLocal {
	public List<Employee> findAllEmployees();
	public List<Employee> filterEmployeesByrole(Role role);
	public List<Employee> filterEmployeesByName(String name);
	public List<Employee> filterEmployeesByNameANDrole(String name,Role role);

}
