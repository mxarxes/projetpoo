package projet;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class Appli{

	public static void main(String[] args) throws Exception{
		//TEST COURSES
		ArrayList<GPSPoint> pointSeq = new ArrayList<GPSPoint>();
		pointSeq.add(new GPSPoint(300,300));
		pointSeq.add(new GPSPoint(400,400));
		pointSeq.add(new GPSPoint(400,350,Type.DEST));
		Route laroute = new Route(pointSeq);

		ArrayList<GPSPoint> pointSeq2 = new ArrayList<GPSPoint>();
		pointSeq2.add(new GPSPoint(300,300));
		pointSeq2.add(new GPSPoint(150,150));
		pointSeq2.add(new GPSPoint(150,300));
		pointSeq2.add(new GPSPoint(200,300,Type.DEST));
		Route laroute2 = new Route(pointSeq2);

		ArrayList<GPSPoint> pointSeq3 = new ArrayList<GPSPoint>();
		pointSeq3.add(new GPSPoint(300,300));
		pointSeq3.add(new GPSPoint(375,425));
		pointSeq3.add(new GPSPoint(550,400,Type.DEST));
		Route laroute3 = new Route(pointSeq3);



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
		RideList activeRides = new RideList();
		try {
			activeRides.addActive(ridelist.pickTheRide(8.5, riderList, scooterList, bikerList, bikeList, laroute));
			//activeRides.addActive(ridelist.pickTheRide(8.5, riderList, scooterList, bikerList, bikeList, laroute2));
			//activeRides.addActive(ridelist.pickTheRide(8.5, riderList, scooterList, bikerList, bikeList, laroute3));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		Model model = new Model();
		try {
			// creating the window (view)in EDT thread
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					System.out.println("Opening a view");
					View view = new View("GhostyDelivery", 600, 600);
					model.setView(view);
					view.setVisible(true);
					System.out.println("Drawing Map");
					model.drawMap();
					System.out.println("Drawing home");
					model.drawHome();
					System.out.println("Loading active rides");
					model.drawActiveRides(activeRides);
					System.out.println("Loading workers");
					model.drawWorkers(activeRides);
					System.out.println("Time passing...");
				}});
			while(activeRides.getAll().isEmpty() == false) {
				try {
					Thread.sleep(1000);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				//model.passTime(activeRides);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
