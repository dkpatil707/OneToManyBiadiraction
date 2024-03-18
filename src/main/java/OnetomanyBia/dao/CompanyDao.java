package OnetomanyBia.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import OnetomanyBia.dto.Company;
import OnetomanyBia.dto.Employee;

public class CompanyDao {
	
	
	
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
		
	}
	
	
		
		public void saveCompany(Company company) {
			 EntityManager entityManager=getEntityManager();
			 EntityTransaction entityTransaction = entityManager.getTransaction();
			 entityTransaction.begin();
			 entityManager.persist(company);
			 entityTransaction.commit();	
			 
		}
		
		
		
		public void updateCompany( int id,Company company ) {
			
			EntityManager entityManager=getEntityManager();
			
			Company dbCompany = entityManager.find(Company.class,id);
			
			if (dbCompany != null) {
				
				EntityTransaction entityTransaction =entityManager.getTransaction();
				entityTransaction.begin();
				company.setId(id);
				company.setEmployee(dbCompany.getEmployee());
				
				entityManager.merge(company);
				entityTransaction.commit();
			}
					

		}
		
		
		public void findCompany( int id ) {
				
				EntityManager entityManager=getEntityManager();
				Company dbCompany = entityManager.find(Company.class,id);
				
				if (dbCompany != null) {
					System.out.println(dbCompany);
					
				}
				else {
					System.out.println("sOrry ID not present");
				}
						

			}
		
		
		public void deleteCompany(int id) {
			EntityManager entityManager=getEntityManager();
			Company dbCompany = entityManager.find(Company.class,id);

			if(dbCompany != null) {
				
				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				
				List<Employee>employee = dbCompany.getEmployee();
				
				for(Employee employee1:employee) {
					employee1.setCompany(null);
				}
				
				entityManager.remove(dbCompany);
				entityTransaction.commit();
			}
			
			else {
				System.out.println("Sorry company id is not present");
				
			}
		}
		
	

}
