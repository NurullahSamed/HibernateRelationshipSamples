package hibernateSample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

@Entity
public class ParkingSpace {


	@TableGenerator(name="PARK_GEN_DETAILED",
	table="ID_PARK_GEN",
	initialValue=0,
	allocationSize=50)
	@Id
	@GeneratedValue(generator="PARK_GEN_DETAILED")
	private int id;
	private int lot;
	private String location;
	
	// Bidirectional One To One bir iliskide mappedBy inverse side'a eklenir.
	// Bunun anlami Employee Entity'si bu iliskinin sahibidir , owning side. 
	// Foreign key bilgisi bu durumda Employee tablosunda yer almaktadir.
	// Boylelikle inverse side'ta (ParkingSpace) foreign key bilgisi saklanmaz.
	@OneToOne(mappedBy = "parkingSpace")
	private Employee employee;
	
	public ParkingSpace(int lot,String location){
		this.lot = lot;
		this.location = location;
	}
	//GETTERS VE SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLot() {
		return lot;
	}

	public void setLot(int lot) {
		this.lot = lot;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "ParkingSpace [id=" + id + ", lot=" + lot + ", location=" + location + "]";
	}
	
	
	
}
