package projet;

import java.util.ArrayList;

public class Appli {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Biker Louis = new Biker("Louis",40,10.46,Classe.BEGINNER);
		GPSPoint paris = new GPSPoint(48.85836302053626, 2.294416924962826);
		GPSPoint marseille = new GPSPoint(43.28409386284528, 5.371248426652939);
		System.out.println("Paris-Marseille : "+paris.dist(marseille)+"km");
		GPSPoint nantes = new GPSPoint(47.21601490841482, -1.5489150054114516);
		GPSPoint mulhouse = new GPSPoint(47.7499078363899, 7.335901253410287);
		System.out.println("Nantes-Mulhouse : "+nantes.dist(mulhouse)+"km");
		*/
		
		GPSPoint point1 = new GPSPoint(0,0);
		GPSPoint point2 = new GPSPoint (0,3);
		ArrayList<GPSPoint> trajet = new ArrayList<GPSPoint>();
		trajet.add(point1);
		trajet.add(point2);
		Route laroute = new Route(trajet);
		
		
		Biker jade = new Biker("Jade",55,7.1,Classe.BEGINNER);
		Rider alfred = new Rider("Alfred",7.2);
		Biker anna = new Biker("Anna",67,7.4,Classe.EXPERT);
		Rider tiago = new Rider("Tiago",7.2);
		Biker blaise = new Biker("Blaise",74,7.25,Classe.ATHLETIC);
		
		Scooter yamama = new Scooter("Yamama",3500,300,50,7.5);
		Scooter vespo = new Scooter("Vespo",2500,125,30,5.5);
		Scooter piagigi = new Scooter("Piagigi",2000,150,35,6);
		
		
		ArrayList<Biker>  bikerList = new ArrayList<Biker>();
		bikerList.add(new Biker("Jade",55,7.1,Classe.BEGINNER));
		bikerList.add(anna = new Biker("Anna",67,7.4,Classe.EXPERT));
		bikerList.add(new Biker("Blaise",74,7.25,Classe.ATHLETIC));
		
		
		
		
		ArrayList<Rider>  riderList = new ArrayList<Rider>();
		riderList.add(new Rider("Alfred",7.2));
		riderList.add(tiago = new Rider("Tiago",7.2));
		ArrayList<Scooter>  scooterList = new ArrayList<Scooter>();
		scooterList.add(new Scooter("Yamama",3500,300,50,7.5));
		scooterList.add(new Scooter("Vespo",2500,125,30,5.5));
		scooterList.add(new Scooter("Piagigi",2000,150,35,6));
		
		ArrayList<Bike>  bikeList = new ArrayList<Bike>();
		bikeList.add(new Bike("Cyclou",450));
		bikeList.add(new Bike("Vavite",500));
		ArrayList<Ride>  RideList = new ArrayList<Ride>();
		for(Biker b : bikerList) {
			for(Bike bb : bikeList) {
				Ride course = new Ride(8.5, b, bb, laroute );
				if(course.isPossible()) {
					RideList.add(course);
				}
			}
		}
		for(Rider r : riderList) {
			for(Scooter s : scooterList) {
				Ride course = new Ride(5, r, s, laroute );
				if(course.isPossible()) {
					RideList.add(course);
				}
			}
		}
		for(Ride course : RideList) {
			System.out.println(course.getWorkerName()+" sur "+course.getVehicleName());
		}
		
		
		
		/*
		 /CREATION D'UN TRAJET
		//GPSPoints
		GPSPoint point1 = new GPSPoint(0,0);
		GPSPoint point2 = new GPSPoint (0,3);
		GPSPoint point3 = new GPSPoint(10,10);
		GPSPoint point4 = new GPSPoint (10,0);
		
		//Trajet
		ArrayList<GPSPoint> trajet = new ArrayList<GPSPoint>();
		trajet.add(point1);
		trajet.add(point2);
		//trajet.add(point3);
		//trajet.add(point4);
		//Objet route avec attribut trajet
		Route laroute = new Route(trajet);
		 
		 *TEST SI UNE COURSE EST POSSIBLE
		 *Ride lacourse = new Ride(49,alfred,yamama,laroute);
		 
		point1.dist(point2);
		System.out.println("Distance : "+point1.dist(point2));
		System.out.println("Charge utile course : "+lacourse.getPayload());
		System.out.println("Poids course : "+lacourse.getWeight());
		System.out.println("Vitesse livreur : "+frero.getSpeed());
		System.out.println("Vitesse véhicule : "+lescoot.getSpeed());
		System.out.println("Vitesse course : "+lacourse.getSpeed());
		
		System.out.println("Temps estimé : "+lacourse.getDistance()/lacourse.getSpeed());
		System.out.println("Course possible : "+lacourse.isPossible());
		
		*/
		
		
	}

}
