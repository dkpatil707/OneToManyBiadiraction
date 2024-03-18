package OnetomanyBia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import OnetomanyBia.dto.Company;
import OnetomanyBia.dto.Employee;

public class EmployeeDao {

	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
		
	}
	
		
	public void saveEmployee(int compannyId, Employee employee)
	{
		EntityManager entityManager=getEntityManager();
    	Company dbCompany	=entityManager.find(Company.class,compannyId);
	
	if (dbCompany != null) {
		
		EntityTransaction entityTransaction= entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		
		List<Employee> employees= dbCompany.getEmployee();
		
		employees.add(employee);
		dbCompany.setEmployee(employees);
		
		entityTransaction.commit();
		
	}else {
		System.out.print("Sorry that id is not preset");
	}
	
	
	
	}
	
	public void updateEmployee( int id,Employee employee ) {
		
		EntityManager entityManager=getEntityManager();
		
		Employee dbEmployee = entityManager.find(Employee.class,id);
		
		if (dbEmployee != null) {
			
			EntityTransaction entityTransaction =entityManager.getTransaction();
			entityTransaction.begin();
			employee.setId(id);
			employee.setCompany(dbEmployee.getCompany());	
			entityManager.merge(employee);
			entityTransaction.commit();
		}
		else {
			System.out.println("sOrry ID not present");
		}
				

	}
	
public void findEmployee( int id ) {
		
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee = entityManager.find(Employee.class,id);
		
		if (dbEmployee != null) {
			System.out.println(dbEmployee);
			
		}
		else {
			System.out.println("sOrry ID not present");
		}
				

	}
	
	
	}

