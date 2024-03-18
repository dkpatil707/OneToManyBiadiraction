package OnetomanyBia.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import OnetomanyBia.dao.CompanyDao;
import OnetomanyBia.dto.Company;
import OnetomanyBia.dto.Employee;

public class CompanyEmployeeCont {

	public static void main(String[] args) {
		
		Company company = new Company();
		company.setId(1);
		company.setName("TCS");
		company.setGst("TCS@354");
		
		
		Employee employee4 = new Employee();
		employee4.setId(4);
		employee4.setAddress("Maharashtra");
		employee4.setName("Sudarshan");
		employee4.setCompany(company);
		
		Employee employee5 = new Employee();
		employee5.setId(5);
		employee5.setAddress("Pune");
		employee5.setName("Darshan");
		employee5.setCompany(company);
//		
//
//	
//		
		List<Employee> employees= new ArrayList<Employee>();
		employees.add(employee5);
		employees.add(employee4);

			
		company.setEmployee(employees);
//		
//		
		EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction()	;
//		
//		
		entityTransaction.begin();
//		entityManager.persist(employee3);
//		entityManager.persist(employee2);
		entityManager.persist(company);	
		entityTransaction.commit();
//		
//		
		
		CompanyDao companyDao= new CompanyDao();
		companyDao.deleteCompany(2);
		
		
	}
}
