package org.techhub.SpringBootJpa.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techhub.SpringBootJpa.Model.Employee;
import org.techhub.SpringBootJpa.Repository.EmployeeRepo;

@Service("empservice")
public class EmployeeSerrvice {

	@Autowired
	EmployeeRepo emprepo;
	
	public boolean addEmployee(Employee emp)
	{
		
		Employee e=(Employee) emprepo.save(emp);
		return e!=null?true:false;
	}
	
	public List<Employee> getEmployee()
	{
		List list=emprepo.findAll();
		return list.size()>0?list:null;
	}
	
	public Employee getEmployeebyId(int id)
	{
		Optional<Employee> o=emprepo.findById(id);
		return o.isEmpty()?null:o.get();
		
	}
	
	public String deleteEmmployeebyId(int id)
	{
		Optional<Employee> o=emprepo.findById(id);
		if(o.isEmpty())
		{
			return "Employee not present";
		}
		else
		{
			emprepo.deleteById(id);
			return "Employee deleted";
		}
	}
	
	public String updateEmployeebyId(Employee emp)
	{
		Employee e=emprepo.save(emp);
		return e!=null?"Employee updated":"employee not updated";
	}
}
