package projet;

public abstract class Vehicle {
String name;
int price;
double usecost;
double payload;
double co2;
 public Vehicle(String name, int price) {
	 this.name = name;
	 this.price = price;
 }
 public double getPayload() {
	 return this.payload;
 }
 public String getName() {
	 return this.name;
 }
 public abstract double getSpeed();
}
