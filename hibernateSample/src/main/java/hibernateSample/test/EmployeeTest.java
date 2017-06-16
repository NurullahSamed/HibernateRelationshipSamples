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
import hibernateSample.dao.ParkingService;
import hibernateSample.dao.ParkingServiceImpl;
import hibernateSample.model.Department;
import hibernateSample.model.Employee;
import hibernateSample.model.ParkingSpace;

public class EmployeeTest {

	public static void main(String[] args) {
		
		//EclipseLink i�in Persistence Unit
		//EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		
		//Hibernate icin Persistence Unit
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnitForHibernate");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeService employeeService = new EmployeeServiceImpl(entityManager);
		//���iler veritaban�na eklendi.
		entityTransaction.begin();
		Employee employee = employeeService.createEmployee("Nurullah", "Sava�", 1000);
		Employee employee2 = employeeService.createEmployee("Samed", "Sava�", 10000);
		Employee employee3 = employeeService.createEmployee("B��ra", "Karnucu", 10000);
		entityTransaction.commit();

		System.out.println("Eklenen ���i :" + employee.toString());
		System.out.println("Eklenen ���i :" + employee2.toString());
		System.out.println("Eklenen ���i :" + employee3.toString());
		System.out.println();
		
		DepartmentService departmentService = new DepartmentServiceImpl(entityManager);
		//Departmanlar veri taban�na eklendi.
		entityTransaction.begin();
		Department department = departmentService.createDepartment("Junior Developers Dept.");
		Department department2 = departmentService.createDepartment("Master Developers Dept.");
		entityTransaction.commit();

		System.out.println("Eklenen Departman :" + department.toString());
		System.out.println("Eklenen Departman :" + department2.toString());
		System.out.println();
			
		
		ParkingService parkingSpaceService = new ParkingServiceImpl(entityManager);
		//park yerleri veri taban�na eklendi.
		entityTransaction.begin();
		ParkingSpace parkingSpace = parkingSpaceService.createParkingSpace(10, "Flat1");
		ParkingSpace parkingSpace2 = parkingSpaceService.createParkingSpace(20, "Flat2");
		ParkingSpace parkingSpace3 = parkingSpaceService.createParkingSpace(30, "Flat3");
		entityTransaction.commit();

		System.out.println("Eklenen Park Yeri :" + parkingSpace.toString());
		System.out.println("Eklenen Park Yeri :" + parkingSpace2.toString());
		System.out.println("Eklenen Park Yeri :" + parkingSpace3.toString());
		System.out.println();

		//���ilerin departmanlar� set edildi.
		entityTransaction.begin();
		employee.setDepartment(department);
		employee2.setDepartment(department2);
		employee3.setDepartment(department2);
		entityTransaction.commit();
		
		//���ilerin park yerleri set edildi.
		//Bidirectional iliskinin dogru sekilde calismasi icin karsilikli olarak setter 
		//metodunu kullanmak gereklidir. Bu islem otomatik olarak yapilmaz!
		entityTransaction.begin();
		employee.setParkingSpace(parkingSpace);
		parkingSpace.setEmployee(employee);
		
		employee2.setParkingSpace(parkingSpace2);
		parkingSpace2.setEmployee(employee2);
		
		employee3.setParkingSpace(parkingSpace3);
		parkingSpace3.setEmployee(employee3);
		entityTransaction.commit();
		
		//4 ID numaral� park yerini bul.
		ParkingSpace foundParkingSpace = parkingSpaceService.findParkingSpace(1);
		
		//E�er b�yle bir park yeri varise
		if (foundParkingSpace != null) {
			//Bu park yerine kay�tl� i��iyi al
		    Employee emp = foundParkingSpace.getEmployee();
		    //��i�inin bilgilerini yazd�r.
		    System.out.println();
		    System.out.println(emp.toString());
		}
		

		entityManager.close();
		entityManagerFactory.close();


	}
}