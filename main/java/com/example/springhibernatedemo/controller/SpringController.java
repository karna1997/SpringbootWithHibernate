package com.example.springhibernatedemo.controller;

import java.util.List;

import com.example.springhibernatedemo.pojo.Country;
import com.example.springhibernatedemo.pojo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springhibernatedemo.service.SpringService;

@RestController
public class SpringController {
	@Autowired
	SpringService service;

	@RequestMapping("/getallemployee")
	public List<Employee> getAllEmployee() {
		System.out.println("Controller Class...!!");
		return service.getAllEmployee();
	}

	@RequestMapping("/getemployeebyid/{id}")
	public Employee getEmployeebyId(@PathVariable int id) {
		System.out.println(id);
		Employee emp = service.getEmployeebyId(id);
		return emp;
	}

	@RequestMapping("/getemployeebyname/{name}")
	public List<Employee> getEmployeebyName(@PathVariable String name) {
		System.out.println(name);
		List<Employee> emp = service.getEmployeebyName(name);
		return emp;
	}

	@RequestMapping("/getemployeebystatus/{status}")
	public List<Employee> getEmployeebyStatus(@PathVariable String status) {
		System.out.println(status);
		List<Employee> listemp = service.getEmployeebyStatus(status);
		return listemp;
	}

	@RequestMapping("/getemployeebydepartment/{deptit}")
	public List<Employee> getEmployeebyDept(@PathVariable String deptit) {
		System.out.println(deptit);
		List<Employee> listemp = service.getEmployeebyDept(deptit);
		return listemp;
	}

	@RequestMapping("/getallemployeebyupdatedby/{updatedBy}")
	public List<Employee> getUpdatedBy(@PathVariable String updatedBy) {
		System.out.println(updatedBy);
		List<Employee> listemp = service.getUpdatedBy(updatedBy);
		return listemp;
	}

	@PostMapping("/addemployee")
	public String addEmployee(@RequestBody Employee emp) {
		System.out.println(emp.getName());
		boolean result = service.addEmployee(emp);
		if (result) {
			return "Record Added Successfully..!!!!!";
		} else
			return "Error";
	}

	@PutMapping("/updateemployee")
	public String updateEmployee(@RequestBody Employee emp) {

		boolean result = service.updateEmployee(emp);

		if (result) {
			return "record Updated Successfully..!!!!";
		} else {
			return "Error";
		}

	}

	@DeleteMapping("/deleteemployeebyid/{id}")
	public String deleteEmployee(@PathVariable int id) {
		boolean result = service.deleteEmployee(id);
		if (result) {
			return "Record Deleted Succesfully..!!";
		} else {
			return "Error";
		}

	}

	
	@PostMapping("/addcountry")
	public String addCountry(@RequestBody Country country)
	{
		System.out.println(country.getCname());
		boolean result=service.addCountry(country);
		if(result){
			return"country added successfully..!!";
		}else{
		 return "Error";	
		}
		
	}
	@PutMapping("/updatecountry")
	public String updateCountry(@RequestBody Country country){
	boolean result=service.updateCountry(country);
	if(result){
		return" country "+country.getCname()+" "+"updated successfully";
	}else{
		return "Error";
	}
	}
	
	@GetMapping("/getallcountry")
	public List<Country> getCountry(){
		System.out.println("controller class");
		return service.getCountry();
	}
	
	 @DeleteMapping("/deletecountry/{cid}")
	 
	 public boolean deleteCountry(@PathVariable int cid)
	 {
		 return service.deleteCountry(cid);
	 }
	 
	 @GetMapping("/getlistbeforetoday")
		List<Employee> getBeforeToday(){
			System.out.println("controller class");
			List<Employee> listemp=service.getBeforeToday();
			return listemp;
		}
}
