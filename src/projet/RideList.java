package projet;
import java.util.*;


/*
 * This class is intended to manipulate lists of rides. 
 */
public class RideList {
	private ArrayList<Ride> rideList;

	public RideList() {
		this.rideList = new ArrayList<Ride>();
	}
	public ArrayList<Ride> getAll() {
		return this.rideList;
	}
	public void add(Ride ride) { // Do not use directly ! Use addActive() instead.
		this.rideList.add(ride);
	}
	public void addActive(Ride ride) {
		this.rideList.add(ride);
		System.out.println(ride.getWorker().getName() + " sur " + ride.getVehicle().getName() + " pour " + (double)Math.round(ride.getDistance()/100)/10 + " km ");
		ride.getWorker().setBusy();
		ride.getVehicle().setBusy();
		ride.setActive();
	}
	public void removeFromActive(Ride ride) {
		this.rideList.remove(ride.getIndex(this));
		ride.getWorker().setAvailable();
		ride.getVehicle().setAvailable();
	}
	/**
	 * makes this.ridelist a list of all possible rides using the workers and vehicles listed in the parameters.
	 * @param weight the weight of the meal to deliver.
	 * @param riderList a list of scooter riders
	 * @param scooterList a list of scooters
	 * @param bikerList a list of bikers
	 * @param bikeList a list of bikes
	 * @param route the Route (sequence of GPSPoints)
	 */
	public void createAllPossibleRides(double weight, ArrayList<Rider> riderList, ArrayList<Scooter> scooterList, ArrayList<Biker> bikerList, ArrayList<Bike> bikeList,Route route) {
		this.rideList.clear();
		
		//CREATING ALL POSSIBLE BIKE RIDES :  
		for(Biker b : bikerList) {
			for(Bike bb : bikeList) {
				if(b.isAvailable() && bb.isAvailable()) {
					Ride course = new Ride(weight, b, bb, route );
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
					Ride course = new Ride(weight, r, s, route );
					if(course.isPossible()) {
						this.add(course);
					}
				}
			}
		}
	}
	/**
	 * Removes all Rides that are not optimal from this.ridelist.
	 * A ride is optimal if it is not worse that any other in the list.
	 */
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
	/**
	 * @warning : use only 
	 */
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
		this.createAllPossibleRides(weight, riderList, scooterList, bikerList, bikeList, laroute);
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