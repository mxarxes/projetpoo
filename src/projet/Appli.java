package projet;

import java.util.ArrayList;

public class Appli {

	public static void main(String[] args) {
		
		GPSPoint point1 = new GPSPoint(0,0);
		GPSPoint point2 = new GPSPoint (0,15);
		ArrayList<GPSPoint> trajet = new ArrayList<GPSPoint>();
		trajet.add(point1);
		trajet.add(point2);
		Route laroute = new Route(trajet);
		
		//LISTE DES WORKERS
		Biker jade = new Biker("Jade",55,7.1,Classe.BEGINNER);
		Rider alfred = new Rider("Alfred",7.2);
		Biker anna = new Biker("Anna",67,7.4,Classe.EXPERT);
		Rider tiago = new Rider("Tiago",7.2);
		Biker blaise = new Biker("Blaise",74,7.25,Classe.ATHLETIC);
		ArrayList<Biker>  bikerList = new ArrayList<Biker>();
		bikerList.add(jade);
		bikerList.add(anna);
		bikerList.add(blaise);
		ArrayList<Rider>  riderList = new ArrayList<Rider>();
		riderList.add(alfred);
		riderList.add(tiago);
		
		//LISTE DES SCOOTERS
		Scooter yamama = new Scooter("Yamama",3500,300,50,7.5);
		Scooter vespo = new Scooter("Vespo",2500,125,30,5.5);
		Scooter piagigi = new Scooter("Piagigi",2000,150,35,6);
		ArrayList<Scooter>  scooterList = new ArrayList<Scooter>();
		scooterList.add(yamama);
		scooterList.add(vespo);
		scooterList.add(piagigi);

		//LISTE DES VELOS
		ArrayList<Bike>  bikeList = new ArrayList<Bike>();
		Bike cyclou = new Bike("Cyclou",450);
		Bike vavite = new Bike("Vavite",500);
		bikeList.add(cyclou);
		bikeList.add(vavite);
		
		//CREATION D'UNE RIDELIST
		RideList possibleRides = new RideList(new ArrayList<Ride>());
		possibleRides.createBikerPossibleRides(8.5,bikerList,bikeList,laroute);
		possibleRides.createRiderPossibleRides(8.5, riderList, scooterList, laroute);
		RideList optimalRides = possibleRides.getOptimalRides();
		System.out.println("COURSES POSSIBLES");
		possibleRides.display();
		System.out.println("COURSES OPTIMALES");
		optimalRides.display();
		
		
	}

}
