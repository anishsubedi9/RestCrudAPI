package np.demo.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import np.demo.restapi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> { 

}
