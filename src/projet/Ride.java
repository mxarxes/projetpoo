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

	public Ride(double weight, Worker worker, Vehicle vehicle, Route route) {
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
		boolean lessThan1Hour = this.getDistance()/(this.speed)<60;
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
		this.worker.goTowards(this.route,this.getSpeed());
	}
	public void stepHome() {
		this.worker.goTowards(this.route.reverse(),this.getSpeed());
	}
	public void display() {
		System.out.println(this.getWorker().getName() + " sur " + this.getVehicle().getName());
	}
}
