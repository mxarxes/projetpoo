package projet;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class Appli {

	public static void main(String[] args) {
		
		//TEST COURSES
		Route laroute = new Route(new GPSPoint(700 ,400));
		Route laroute2 = new Route(new GPSPoint(600 ,300));
		Route laroute3 = new Route(new GPSPoint(650 ,150));
		
		//LISTE DES WORKERS
		Biker jade = new Biker("Jade",55,7.1,Classe.BEGINNER);
		Rider alfred = new Rider("Alfred",80,7.2);
		Biker anna = new Biker("Anna",67,7.4,Classe.EXPERT);
		Rider tiago = new Rider("Tiago",62,7.2);
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
		RideList ridelist = new RideList();
		ArrayList<Ride> activeRides = new ArrayList<Ride>();
		System.out.println("COURSE SELECTIONNEE ");
		try {
		activeRides.add(ridelist.pickTheRide(8.5, riderList, scooterList, bikerList, bikeList, laroute));
		activeRides.add(ridelist.pickTheRide(10, riderList, scooterList, bikerList, bikeList, laroute2));
		activeRides.add(ridelist.pickTheRide(5, riderList, scooterList, bikerList, bikeList, laroute3));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		Model model = new Model();

		try {
			// creating the window (view)in EDT thread
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					View view = new View("GhostyDelivery", 1280, 720);
					model.setView(view);
					view.setVisible(true);
				}
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		model.drawHome();
		model.drawActiveRides(activeRides);
	}
	}
