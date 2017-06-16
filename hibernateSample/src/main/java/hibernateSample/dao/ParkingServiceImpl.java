package hibernateSample.dao;

import javax.persistence.EntityManager;

import hibernateSample.model.Employee;
import hibernateSample.model.ParkingSpace;

public class ParkingServiceImpl implements ParkingService{

	private EntityManager entityManager;

	public ParkingServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public ParkingSpace createParkingSpace(int lot, String location) {
		ParkingSpace parkingSpace = new ParkingSpace(lot, location);
		entityManager.persist(parkingSpace);
		return parkingSpace;
	}

	public ParkingSpace findParkingSpace(int id) {
		return entityManager.find(ParkingSpace.class, id);
	}

}
