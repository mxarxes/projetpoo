package projet;
import java.util.*;


/*
 * 
 * This class is intended to manipulate lists of rides.
 * 
 * 
 */
public class RideList {
	private ArrayList<Ride> rideList;


	public RideList() {
		this.rideList = new ArrayList<Ride>();
	}
	public void add(Ride ride) {
		this.rideList.add(ride);
	}
	public void createAllPossibleRides(double weight, ArrayList<Rider> riderList, ArrayList<Scooter> scooterList, ArrayList<Biker> bikerList, ArrayList<Bike> bikeList,Route laroute) {
		this.rideList.clear();
		//CREATING ALL POSSIBLE BIKE RIDES :  
		for(Biker b : bikerList) {
			for(Bike bb : bikeList) {
				if(b.isAvailable() && bb.isAvailable()) {
					Ride course = new Ride(weight, b, bb, laroute );
					if(course.isPossible()) {
						this.add(course);
					}
				}
			}
		}
		//CREATING ALL POSSIBLE SCOOTER RIDES : 
		for(Rider r : riderList) {
			for(Scooter s : scooterList) {
				if(r.isAvailable() && s.isAvailable()) {
					Ride course = new Ride(weight, r, s, laroute );
					if(course.isPossible()) {
						this.add(course);
					}
				}
			}
		}
	}
	public void removeNonOptimalRides() {
		ArrayList<Ride> optimalRides = new ArrayList<Ride>();
		for(Ride ride : this.rideList) {
			for(Ride ride2 : this.rideList) {
				if(ride.isDifferentThan(ride2)) {
					if(ride.isWorseThan(ride2)) {
						ride.setOptimal(false);
					}
				}
			}
		}
		for(Ride ride : this.rideList) {
			if(ride.getOptimal()) {
				optimalRides.add(ride);
			}
		}
		this.rideList = optimalRides;
	}
	public void saveThePlanet() {
		ArrayList<Ride> greenRides = new ArrayList<Ride>();
		for(Ride r : this.rideList) {
			for(Ride r2 : this.rideList) {
				if(r.isMorePollutingThan(r2)) {
					r.setGreen(false);
				}
			}
		}
		for(Ride r : this.rideList) {
			if(r.getGreen()) {
				greenRides.add(r);
			}
		}
		this.rideList = greenRides;
	}
	public void sort() {

	}
	public Ride pickTheRide(double weight,ArrayList<Rider> riderList, ArrayList<Scooter> scooterList, ArrayList<Biker> bikerList, ArrayList<Bike> bikeList,Route laroute ) throws Exception {
		this.createAllPossibleRides(0, riderList, scooterList, bikerList, bikeList, laroute);
		if(this.rideList.size() > 0) {
			this.removeNonOptimalRides();
			this.saveThePlanet();
			return this.rideList.get(0);
		}
		else {
			throw new Exception("Sorry, impossible right now. Try again when more/better workers and vehicles are available.");
		}

	}
	public void display() {
		for(Ride ride : this.rideList) {
			ride.display();
		}
	}
}