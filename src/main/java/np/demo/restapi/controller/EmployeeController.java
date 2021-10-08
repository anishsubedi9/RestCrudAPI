package np.demo.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import np.demo.restapi.model.Employee;
import np.demo.restapi.service.EmployeeService;

public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;
	
	//displaying the List of employees
	@GetMapping("/")
	public String viewHome(Model model) {
	 model.addAttribute("listemployees", employeeservice.getAllEmployees());
	 return "index";
	} 
	
	@GetMapping("/showNewEmployeeForm")
	public String showEmployeeForm(Model model) {
		Employee employee= new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
		
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// save employee to database
		employeeservice.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@org.springframework.web.bind.annotation.PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		Employee employee = employeeservice.getEmployeeById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@org.springframework.web.bind.annotation.PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.employeeservice.deleteEmployeeById(id);
		return "redirect:/";
	}
	
}
