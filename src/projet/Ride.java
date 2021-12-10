package projet;
import java.util.*;

public class Ride {
	private double weight;
	private Worker worker;
	private Vehicle vehicle;
	private Route route;
	private double price;
	private double co2;
	private boolean isPossible;
	private double payload;
	private double speed;
	
	public Ride(double weight, Worker worker, Vehicle vehicle, Route route) {
		this.weight = weight;
		this.worker = worker;
		this.vehicle = vehicle;
		this.route = route;
		this.price = this.worker.salary + 0;
		this.co2 = 0;//(vehicle.co2*route.totalDistance());
		if(worker.getPayload()>vehicle.getPayload()){
			this.payload = worker.getPayload();
		}
		else {
			this.payload = vehicle.getPayload();
		}
		this.speed = (worker.getSpeed() + vehicle.getSpeed());
	}
	public boolean isPossible() {/*
		System.out.println("COURSE DE  "+this.getWorkerName()+" SUR "+this.getVehicleName());
		System.out.println("Charge utile course : "+this.getPayload());
		System.out.println("Poids course : "+this.getWeight());
		System.out.println("Vitesse livreur : "+this.worker.getSpeed());
		System.out.println("Vitesse véhicule : "+this.vehicle.getSpeed());
		System.out.println("Vitesse course : "+this.getSpeed());
		System.out.println("Temps estimé : "+this.getDistance()/this.getSpeed());*/
		boolean lessThan1Hour = this.getDistance()/(this.speed)<1;
		if(lessThan1Hour) {
			if(this.payload >= this.weight) {
				return true;
			}
			else {
				System.out.println("Course impossible pour "+this.getWorkerName()+" sur "+ this.getVehicleName()+": trop lourd ("+this.payload+" > "+this.weight+")");
				return false;
			}
		}
		else {
			System.out.println("Course de "+this.getWorkerName()+" sur "+this.getVehicleName()+" impossible : trop long");
			return false;
		}
		//return (this.payload >= this.weight && lessThan1Hour);
	}
	public double getSpeed() {
		// TODO Auto-generated method stub
		return this.speed;
	}
	public double getWeight() {
		// TODO Auto-generated method stub
		return this.weight;
	}
	public double getPayload() {
		// TODO Auto-generated method stub
		return this.payload;
	}
	public double getDistance() {
		return this.route.totalDistance();
	}
	public String getWorkerName() {
		return this.worker.getName();
	}
	public String getVehicleName() {
		return this.vehicle.getName();
	}
	
	public boolean isWorseThan() {
		return true;
	}
}
