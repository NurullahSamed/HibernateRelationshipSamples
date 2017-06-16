package hibernateSample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String surname;
	private int salary;
	
	/*Varsayilan olarak verilen bu kolon ismini degistirmek istersek bu durumda 
	 * @JoinColumn annotation kullanabiliriz.@JoinColumn‘u @ManyToOne annotation ile 
	 * birlikte kullanabiliriz. ManyToOne bir iliskide owning side her zaman Many tarafidir.
	 * Convetion geregi logical annotation’lar  , physical annotation’lardan once olmalidir. 
	 * Yani @ManyToOne annotation once tanimlanmalidir.*/
	@ManyToOne
	//@JoinColumn(name = "DEPT_ID")
	private Department department;
	
	public Employee(){
		super();
	}
	
	public Employee(String name,String surname,int salary){
		super();
		this.name = name;
		this.surname = surname;
		this.salary = salary;
	}

	
	//GETTERS
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getSurname(){
		return surname;
	}
	
	public int getSalary(){
		return salary;
	}
	
	public Department getDepartment(){
		return department;
	}
	
	//SETTERS
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setSurname(String surname){
		this.surname = surname;
	}
	
	public void setSalary(int salary){
		this.salary = salary;
	}
	
	public void setDepartment(Department department){
		this.department = department;
	}
}
