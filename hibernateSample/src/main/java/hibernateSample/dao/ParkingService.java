package hibernateSample.dao;

import hibernateSample.model.ParkingSpace;

public interface ParkingService {
	
	public ParkingSpace createParkingSpace(int lot, String location);
	public ParkingSpace findParkingSpace(int id);

}
