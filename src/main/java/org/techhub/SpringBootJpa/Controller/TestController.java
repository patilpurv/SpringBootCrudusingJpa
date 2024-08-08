package org.techhub.SpringBootJpa.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.techhub.SpringBootJpa.Model.Employee;
import org.techhub.SpringBootJpa.Service.EmployeeSerrvice;

@RestController
public class TestController {
	
	@Autowired
	EmployeeSerrvice empservice;
	List<Employee> list=new ArrayList<Employee>();
	@PostMapping("/save")
	public String saveemployee(@RequestBody Employee emp)
	{
		Boolean b=empservice.addEmployee(emp);
		if(b)
		{
			return"Employee Added";
		}
		else
		{
			return"Employee not Added";
		}
	}
	
	@GetMapping("/view")
	public List<Employee> getEmployee()
	{
		list=empservice.getEmployee();
		return list;
	}
	
	@GetMapping("/search/{id}")
	public String getEmployeeById(@PathVariable("id") Integer id)
	{
		Employee emp=empservice.getEmployeebyId(id);
		return emp!=null?emp.toString():"Employee not found";
	}
	
	@DeleteMapping("/delemp/{id}")
	public String deleteEmployee(@PathVariable("id")Integer id)
	{
		String str=empservice.deleteEmmployeebyId(id);
		return str;
	}
	
	@PutMapping("updemp")
	public String updateEmployee(@RequestBody Employee emp)
	{
		String str=empservice.updateEmployeebyId(emp);
		return str;
	}
}
