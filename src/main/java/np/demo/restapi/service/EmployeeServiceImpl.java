package np.demo.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import np.demo.restapi.model.Employee;
import np.demo.restapi.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	
}
