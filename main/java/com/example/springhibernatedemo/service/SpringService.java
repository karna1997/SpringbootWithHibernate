package com.example.springhibernatedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springhibernatedemo.dao.SpringDao;
import com.example.springhibernatedemo.pojo.Country;
import com.example.springhibernatedemo.pojo.Employee;

@Service
public class SpringService {
	@Autowired
	SpringDao dao;

	public List<com.example.springhibernatedemo.pojo.Employee> getAllEmployee() {
		System.out.println("Spring Service Class");
		return dao.getAllEmployee();
	}

	public Employee getEmployeebyId(int id) {
		Employee emp = dao.getEmployeebyId(id);
		return emp;
	}

	public List<Employee> getEmployeebyName(String name) {
		List<Employee> listemp = dao.getEmployeebyName(name);
		return listemp;
	}

	public List<Employee> getEmployeebyStatus(String status) {
		List<Employee> listemp = dao.getEmployeebyStatus(status);
		return listemp;
		
	}

	public List<Employee> getEmployeebyDept(String deptit) {
		List<Employee> listemp = dao.getEmployeebyDept(deptit);
		return listemp;
	}

	public List<Employee> getUpdatedBy(String updatedBy) {
		List<Employee> listemp=dao.getUpdatedBy(updatedBy);
		return listemp;
	}

	public boolean addEmployee(Employee emp) {
	boolean result=	dao.addEmployee(emp);
		return result;
	}

	public boolean updateEmployee(Employee emp) {
		boolean result=dao.updateEmployee(emp);
		return result;
	}

	
	public boolean deleteEmployee(int id) {
		boolean result=dao.deleteEmployee(id);
		return result;
	}

	public boolean addCountry(Country country) {
	boolean result=	dao.addCountry(country);
		return result;
	}

	public boolean updateCountry(Country country) {
	  boolean result=dao.updateCountry(country);
		return result;
	}
 
	
	public List<Country> getCountry(){
		System.out.println("Spring Service Class");
		return dao.getCountry();
	}
	
	public boolean deleteCountry(int cid)
	{

	return 	 dao.deleteCountry(cid);
	
	}

	public List<Employee> getBeforeToday() {
		System.out.println("service class");
		List<Employee> listemp=dao.getBeforeToday();
		return listemp;
	}
}
