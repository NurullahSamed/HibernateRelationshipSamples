package hibernateSample.dao;

import hibernateSample.model.Employee;

public interface EmployeeService {

	public Employee createEmployee(String name, String surname, int salary);

	public Employee findEmployee(int id);
}
