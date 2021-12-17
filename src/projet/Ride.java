package projet;

public class Ride{
	private double weight;
	private Worker worker;
	private Vehicle vehicle;
	private Route route;
	private double price;
	private double co2;
	private double payload;
	private double speed;
	private boolean isOptimal; //is less expensive and less polluting, less expensive and as polluting as, or as expensive and less polluting than any other ride in a set rideList.
	private boolean isGreen; //is less polluting than any other in a rideList.
	private boolean isDelivered;
	private boolean isActive;

	public Ride(double weight, Worker worker, Vehicle vehicle, Route route) {
		this.isActive = false;
		this.isDelivered = false;
		this.isOptimal = true;
		this.isGreen = true;
		this.weight = weight;
		this.worker = worker;
		this.vehicle = vehicle;
		this.route = route;
		this.price = this.worker.getSalary() + vehicle.getUseCost();
		this.co2 = (vehicle.getCo2()*route.totalDistance());
		if(worker.getPayload()>vehicle.getPayload()){
			this.payload = worker.getPayload();
		}
		else {
			this.payload = vehicle.getPayload();
		}
		this.speed = (worker.getSpeed() + vehicle.getSpeed());
	}
	public boolean isPossible() {
		boolean lessThan1Hour = this.getDistance()/(this.speed)<1800; //1800s = 1h
		if(lessThan1Hour) {
			if(this.payload >= this.weight) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	/**
	 * 
	 * @return the speed of this worker on this vehicle, in m/s.
	 */
	public double getSpeed() {
		return this.speed;
	}
	public double getWeight() {
		return this.weight;
	}
	public double getPayload() {
		return this.payload;
	}
	public double getDistance() {
		return this.route.totalDistance();
	}
	public Worker getWorker() {
		return this.worker;
	}
	public Vehicle getVehicle() {
		return this.vehicle;
	}
	public double getCo2() {
		return this.co2;
	}
	public double getPrice() {
		return this.price;
	}
	public void deliver() {
		this.isDelivered = true;
		for(GPSPoint p : this.getRoute().getRoute()) {
			p.uncheck();
		}
	}
	public void setOptimal(boolean o) {
		this.isOptimal = o;
	}
	public boolean getOptimal() {
		return this.isOptimal;
	}
	public void setGreen(boolean g) {
		this.isGreen = g;
	}
	public boolean getGreen() {
		return this.isGreen;
	}
	public Route getRoute() {
		return this.route;
	}
	public boolean isDelivered() {
		return this.isDelivered;
	}
	public boolean isActive() {
		return this.isActive;
	}
	public void setActive() {
		this.isActive = true;
	}
	public void setInactive() {
		this.isActive = false;
	}
	public int getIndex(RideList list) {
		for(int i=0; i<list.getAll().size();i++) {
			if(this.getVehicle() == list.getAll().get(i).getVehicle() && this.getWorker() == list.getAll().get(i).getWorker()) {
				return i;
			}
		}
		return 0;
	}
	public boolean isWorseThan(Ride ride2) {
		return (this.co2 > ride2.getCo2() && this.price == ride2.getPrice()) || (this.co2 == ride2.getCo2() && this.price > ride2.getPrice()) || (this.co2 > ride2.getCo2() && this.price > ride2.getPrice());
	}
	public boolean isDifferentThan(Ride ride2) {
		return this.getVehicle().getName() != ride2.getVehicle().getName() || this.getWorker().getName() != ride2.getWorker().getName();
	}
	public boolean isMorePollutingThan(Ride r2) {
		return this.getCo2()>r2.getCo2();
	}
	public void step() {
		if(this.isDelivered) {
			this.worker.advance(this.route.reverse(), this.getSpeed()*60);
		}
		else {
		this.worker.advance(this.route,this.getSpeed()*60);
		}
	}
	public void display() {
		System.out.println(this.getWorker().getName() + " sur " + this.getVehicle().getName());
	}
}
