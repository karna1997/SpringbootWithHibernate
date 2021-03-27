package com.example.springhibernatedemo.dao;


import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.springhibernatedemo.pojo.Country;
import com.example.springhibernatedemo.pojo.Employee;

@SuppressWarnings("deprecation")
@Repository
public class SpringDao {
	@Autowired
	SessionFactory factory;

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee() {
		System.out.println("SpringDao Class");
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> listemp = criteria.list();
		return listemp;
	}

	public Employee getEmployeebyId(int id) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id", id));
		Employee emp = (Employee) criteria.uniqueResult();
		return emp;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeebyName(String name) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("name", name));
		List<Employee> listemp = criteria.list();
		return listemp;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeebyStatus(String status) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("status", status));
		List<Employee> listemp = criteria.list();
		return listemp;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeebyDept(String deptit) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("deptit", deptit));
		List<Employee> listemp = criteria.list();
		return listemp;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getUpdatedBy(String updatedBy) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("updatedBy", updatedBy));
		List<Employee> listemp = criteria.list();
		return listemp;
	}

	public boolean addEmployee(Employee emp) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Date date = new Date(00,00,00);
		
		emp.setCreatedDtm(date);
		emp.setUpdatedDtm(date);
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		date.setYear(2019);
		date.setMonth(01);
		date.setDate(01);
		
		System.out.println("Today's Date" + date);
		session.save(emp);
		tx.commit();
		return true;
	}

	public boolean updateEmployee(Employee emp) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println(emp.getName());
		session.saveOrUpdate(emp);
		tx.commit();
		return true;
	}

	@SuppressWarnings("rawtypes")
	public boolean deleteEmployee(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("Delete From Employee where id=:id");
		query.setParameter("id", 28);
		int i = query.executeUpdate();
		tx.commit();
		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}

	@SuppressWarnings("rawtypes")
	public boolean addCountry(Country country) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createSQLQuery("insert into Country(cname)values(:cname)");
		query.setParameter("cname", country.getCname());
		int i = query.executeUpdate();
		System.out.println("i==" + i);
		tx.commit();
		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}

	@SuppressWarnings("rawtypes")
	public boolean updateCountry(Country country) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("update Country set cname=:cname where cid=:cid");
		query.setParameter("cname", country.getCname());
		query.setParameter("cid", country.getCid());
		int i = query.executeUpdate();
		tx.commit();
		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}
	
	

	@SuppressWarnings("unchecked")
	public List<Country> getCountry() {
		System.out.println("Dao Class");
		Session session=factory.openSession();
		Criteria criteria = session.createCriteria(Country.class);
		List<Country> countrylist = criteria.list();
		return countrylist ;
	}

	@SuppressWarnings("rawtypes")
	public boolean deleteCountry(int cid) {
		Session session= factory.openSession();
		Transaction tx=session.beginTransaction();
	 Query query= session.createQuery("Delete from Country where cid=:cid");
	 query.setParameter("cid", cid);
	 int i=query.executeUpdate();
	 tx.commit();
	 if(i>0){
		 return true;
	 }else{
		 return false;
	 }
		
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Employee> getBeforeToday() {
		 System.out.println("Dao class");
		Session session=factory.openSession();	
       Query query=session.createQuery(" from Employee where createdDtm<:date");
       Date date= new Date(System.currentTimeMillis());
       query.setParameter("date",  date);
        List<Employee> listemp = query.list();
		return listemp;
        
		
	}

	}


