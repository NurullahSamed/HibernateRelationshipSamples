package hibernateSample.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernateSample.dao.DepartmentService;
import hibernateSample.dao.DepartmentServiceImpl;
import hibernateSample.dao.EmployeeService;
import hibernateSample.dao.EmployeeServiceImpl;
import hibernateSample.model.Department;
import hibernateSample.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		
		//EclipseLink için Persistence Unit
		//EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		
		//Hibernate icin Persistence Unit
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnitForHibernate");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeService employeeService = new EmployeeServiceImpl(entityManager);

		entityTransaction.begin();
		Employee employee = employeeService.createEmployee("Levent", "Erguder", 1000);
		Employee employee2 = employeeService.createEmployee("James", "Gosling", 10000);
		Employee employee3 = employeeService.createEmployee("Joshua", "Bloch", 10000);
		entityTransaction.commit();

		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + employee2);
		System.out.println("Persisted :" + employee3);
		
		DepartmentService departmentService = new DepartmentServiceImpl(entityManager);

		entityTransaction.begin();
		Department department = departmentService.createDepartment("Junior Developers Dept.");
		Department department2 = departmentService.createDepartment("Master Developers Dept.");
		entityTransaction.commit();

		System.out.println("Persisted :" + department);
		System.out.println("Persisted :" + department2);

		entityTransaction.begin();
		employee.setDepartment(department);
		employee2.setDepartment(department2);
		employee3.setDepartment(department2);
		entityTransaction.commit();

		System.out.println("Finding...");
		Employee emp = employeeService.findEmployee(1);
		System.out.println(emp);

		entityManager.close();
		entityManagerFactory.close();


	}
}