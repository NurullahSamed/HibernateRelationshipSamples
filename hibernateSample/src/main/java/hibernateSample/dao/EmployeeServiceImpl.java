package hibernateSample.dao;

import javax.persistence.EntityManager;

import hibernateSample.model.Employee;

public class EmployeeServiceImpl implements EmployeeService  {
	private EntityManager entityManager;
	
	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	public Employee createEmployee(String name, String surname, int salary) {
		Employee employee = new Employee(name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

	public Employee findEmployee(int id) {
		return entityManager.find(Employee.class, id);
	}

}
