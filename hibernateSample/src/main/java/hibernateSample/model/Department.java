package hibernateSample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Department {
	
	@TableGenerator(name="DEPT_GEN_DETAILED",
	table="ID_GEN",
	pkColumnName="ID_GEN_NAME",
	valueColumnName="ID_GEN_COUNT",
	initialValue=0,
	allocationSize=50)
	@Id
	@GeneratedValue(generator="DEPT_GEN_DETAILED")
	private int id;
	private String name;
	
	public Department(){
		super();
	}
	
	public Department(String name){
		super();
		this.name = name;
	}
	
	//GETTERS
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	//SETTERS
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
