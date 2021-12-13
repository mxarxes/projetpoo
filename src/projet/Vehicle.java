package projet;

public abstract class Vehicle {
String name;
double price;
double usecost;
double payload;
double co2;
GPSPoint position;
 public Vehicle(String name, int price) {
	 this.position = new GPSPoint(640,360);
	 this.name = name;
	 this.price = price;
 }
 public double getPayload() {
	 return this.payload;
 }
 public String getName() {
	 return this.name;
 }
 public double getUseCost() {
	 return this.usecost;
	
 }
 public double getCo2() {
	 return this.co2;
 }
 public boolean isAvailable() {
	 return this.position.getX() == 640 && this.position.getY() == 360;
 }
 public abstract double getSpeed();
}
