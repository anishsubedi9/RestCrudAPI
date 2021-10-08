package np.demo.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import np.demo.restapi.model.Employee;
import np.demo.restapi.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;
	
	  @GetMapping("/{id}")
	    public Employee getEmployee(@PathVariable long id) {
	        return employeeservice.getEmployeeById(id);
	    }
	  
	  //displaying the List of employees
	    @GetMapping("/list")
	    public List<Employee> viewHome() {
	        return employeeservice.getAllEmployees();
	    }
//	    
	    @PostMapping("/add")
	    public Employee addEmployee(@RequestBody Employee employee) {
	        return employeeservice.saveEmployee(employee);
	    }
	    
	    @DeleteMapping("/{id}")
	    public String deleteEmployee(@PathVariable long id) {
	    	 employeeservice.deleteEmployeeById(id);
	    	 return "deleted success";
	    }
	    
	    @PutMapping("/update/{id}")
	    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable long id) {
	    	
	    	employee.setId(id);
	        return employeeservice.updateEmployee(employee);
	    }
	    
//	    
//	//displaying the List of employees
//	@GetMapping("/")
//	public String viewHome(Model model) {
//	 model.addAttribute("listemployees", employeeservice.getAllEmployees());
//	 return "index";
//	} 
//	
//	@GetMapping("/showNewEmployeeForm")
//	public String showEmployeeForm(Model model) {
//		Employee employee= new Employee();
//		model.addAttribute("employee", employee);
//		return "index";
//		
//	}
//	
//	@PostMapping("/saveEmployee")
//	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
//		// save employee to database
//		employeeservice.saveEmployee(employee);
//		return "redirect:/";
//	}
//	
//	@GetMapping("/showFormForUpdate/{id}")
//	public String showFormForUpdate(@org.springframework.web.bind.annotation.PathVariable ( value = "id") long id, Model model) {
//		
//		// get employee from the service
//		Employee employee = employeeservice.getEmployeeById(id);
//		
//		// set employee as a model attribute to pre-populate the form
//		model.addAttribute("employee", employee);
//		return "update_employee";
//	}
//	
//	@GetMapping("/deleteEmployee/{id}")
//	public String deleteEmployee(@org.springframework.web.bind.annotation.PathVariable (value = "id") long id) {
//		
//		// call delete employee method 
//		this.employeeservice.deleteEmployeeById(id);
//		return "redirect:/";
//	}
	
}
