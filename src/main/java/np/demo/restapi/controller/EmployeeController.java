package np.demo.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import np.demo.restapi.service.EmployeeService;

public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;
	
	//displaying the List of employees
	@GetMapping("/")
	public String viewHome(Model model) {
		model.addAttribute("listemployees", employeeservice.getAllEmployees());
		return  "index";
		
	} 
}
