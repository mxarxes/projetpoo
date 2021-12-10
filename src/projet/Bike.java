package projet;

public class Bike extends Vehicle{

public Bike(String name, int price){
	super(name,price);
	this.usecost = (this.price/30000);
}
	public double getSpeed(){
		return 0;
	}
	public double getUseCost() {
		return this.usecost;
	}
}
