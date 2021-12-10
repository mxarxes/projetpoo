package projet;

public class Scooter extends Vehicle{
	private int cylinder;
	private double consumption;
	private double co2;
	public Scooter(String name, int price, int cylinder, int payload, double consumption) {
		super(name,price);
		this.cylinder = cylinder;
		this.payload = payload;
		this.consumption = consumption;
		this.usecost = ((this.price/20000)+1.65);
		this.co2 = (this.cylinder)/4;
	}
	public double getSpeed() {
		return (this.cylinder/50)+30;
	}
}
