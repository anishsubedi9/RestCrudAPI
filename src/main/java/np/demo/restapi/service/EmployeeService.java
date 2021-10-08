package np.demo.restapi.service;

import java.util.List;


import np.demo.restapi.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	Employee saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
	Employee updateEmployee(Employee employee);

}
