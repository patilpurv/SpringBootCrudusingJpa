package org.techhub.SpringBootJpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.techhub.SpringBootJpa.Model.Employee;
@Repository("emprepo")
public interface EmployeeRepo  extends JpaRepository<Employee,Integer>{

	
}
