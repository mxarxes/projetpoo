package projet;
import java.util.*;
public class RideList {
	private ArrayList<Ride> list = new ArrayList<Ride>();

	public RideList(ArrayList<Ride> listOfRides) {
		this.list = listOfRides;
}
	public ArrayList<Ride> getList() {
		return this.list;
	}
	public void add(Ride newRide) {
		this.list.add(newRide);
	}
	public void createBikerPossibleRides(double weight, ArrayList<Biker> bikerList,ArrayList<Bike> bikeList,Route laroute) {
		RideList listRide = new RideList(new ArrayList<Ride>());
		for(Biker b : bikerList) {
			for(Bike bb : bikeList) {
				Ride course = new Ride(8.5, b, bb, laroute );
				if(course.isPossible()) {
					this.list.add(course);
				}
			}
		}
}
	public void createRiderPossibleRides(double weight, ArrayList<Rider> riderList,ArrayList<Scooter> scooterList,Route laroute) {
		RideList listRide = new RideList(new ArrayList<Ride>());
		for(Rider r : riderList) {
			for(Scooter s : scooterList) {
				Ride course = new Ride(8.5, r, s, laroute );
				if(course.isPossible()) {
					this.list.add(course);
				}
			}
		}
	}
	public RideList getOptimalRides() {
		RideList optimalRides = new RideList(new ArrayList<Ride>());
		for(Ride ride : this.list) {
			boolean isNotWorseThanAnyOther = true;
			for(Ride ride2 : this.list) {
				if(ride.isWorseThan(ride2)) {
					isNotWorseThanAnyOther = false;
				}
			}
			if(isNotWorseThanAnyOther) {
				optimalRides.add(ride);
			}
		}
		return optimalRides;
	}
	public void display() {
		for(Ride ride : this.list) {
		System.out.println(ride.getWorkerName() +" sur " +ride.getVehicleName());
		}
	}
}