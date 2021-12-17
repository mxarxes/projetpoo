package projet;

import java.util.ArrayList;

public class Model {

	private View view;
	private ArrayList<Rider> riderList = new ArrayList<Rider>();
	private ArrayList<Biker>bikerList = new ArrayList<Biker>();
	private RideList activeRides = new RideList();
	public static double ratio = 14.53; //1px = 14.53m;

	public Model() {
		view = null;

		
		// ######################################## DATA ############################### 
		
		//LIST OF WORKERS
		Biker jade = new Biker("Jade",55,7.1,Classe.BEGINNER);
		Rider alfred = new Rider("Alfred",80,7.2);
		Biker anna = new Biker("Anna",67,7.4,Classe.EXPERT);
		Rider tiago = new Rider("Tiago",62,7.2);
		Biker blaise = new Biker("Blaise",74,7.25,Classe.ATHLETIC);

		this.bikerList.add(jade);
		this.bikerList.add(anna);
		this.bikerList.add(blaise);
		this.riderList.add(alfred);
		this.riderList.add(tiago);

		//LIST OF SCOOTERS
		Scooter yamama = new Scooter("Yamama",3500,300,50,7.5);
		Scooter vespo = new Scooter("Vespo",2500,125,30,5.5);
		Scooter piagigi = new Scooter("Piagigi",2000,150,35,6);
		ArrayList<Scooter>  scooterList = new ArrayList<Scooter>();

		scooterList.add(yamama);
		scooterList.add(vespo);
		scooterList.add(piagigi);

		//LIST OF BIKES
		ArrayList<Bike>  bikeList = new ArrayList<Bike>();
		Bike cyclou = new Bike("Cyclou",450);
		Bike vavite = new Bike("Vavite",500);

		bikeList.add(cyclou);
		bikeList.add(vavite);

		//TEST RIDES


		//FIRST TEST RIDE
		ArrayList<GPSPoint> pointSeq = new ArrayList<GPSPoint>();
		pointSeq.add(new GPSPoint(300,300));
		pointSeq.add(new GPSPoint(323,300));
		pointSeq.add(new GPSPoint(280,210));
		pointSeq.add(new GPSPoint(380,60));
		pointSeq.add(new GPSPoint(330,50,Type.DEST));
		Route laroute = new Route(pointSeq);

		//SECOND TEST RIDE
		ArrayList<GPSPoint> pointSeq2 = new ArrayList<GPSPoint>();
		pointSeq2.add(new GPSPoint(300,300));
		pointSeq2.add(new GPSPoint(323,300));
		pointSeq2.add(new GPSPoint(397,422));
		pointSeq2.add(new GPSPoint(472,368));
		pointSeq2.add(new GPSPoint(500,400,Type.DEST));
		Route laroute2 = new Route(pointSeq2);

		//THIRD TEST RIDE
		ArrayList<GPSPoint> pointSeq3 = new ArrayList<GPSPoint>();
		pointSeq3.add(new GPSPoint(300,300));
		pointSeq3.add(new GPSPoint(271,315));
		pointSeq3.add(new GPSPoint(330,440));
		pointSeq3.add(new GPSPoint(310,480));
		pointSeq3.add(new GPSPoint(255,500,Type.DEST));
		Route laroute3 = new Route(pointSeq3);

		//FOURTH TEST RIDE
		ArrayList<GPSPoint> pointSeq4 = new ArrayList<GPSPoint>();
		pointSeq4.add(new GPSPoint(300,300));
		pointSeq4.add(new GPSPoint(271,315));
		pointSeq4.add(new GPSPoint(245,290));
		pointSeq4.add(new GPSPoint(147,328));
		pointSeq4.add(new GPSPoint(140,310,Type.DEST));
		Route laroute4 = new Route(pointSeq4);

		//FIFTH TEST RIDE
		ArrayList<GPSPoint> pointSeq5 = new ArrayList<GPSPoint>();
		pointSeq5.add(new GPSPoint(300,300));
		pointSeq5.add(new GPSPoint(160,70));
		pointSeq5.add(new GPSPoint(120,100,Type.DEST));
		Route laroute5 = new Route(pointSeq5);

		RideList rideList = new RideList();
		//CREATION OF A RIDELIST
		try {
			this.activeRides.addActive(rideList.pickTheRide(8.5, riderList, scooterList, bikerList, bikeList, laroute4));
			this.activeRides.addActive(rideList.pickTheRide(5, riderList, scooterList, bikerList, bikeList, laroute2));
			this.activeRides.addActive(rideList.pickTheRide(3, riderList, scooterList, bikerList, bikeList, laroute3));
			this.activeRides.addActive(rideList.pickTheRide(5, riderList, scooterList, bikerList, bikeList, laroute));
			this.activeRides.addActive(rideList.pickTheRide(3, riderList, scooterList, bikerList, bikeList, laroute5));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void setView(View view) {
		this.view = view;
	}


	public void drawHome() { // Drawing the home of the company at the center of the window.
		GPSPoint home = new GPSPoint(300,300,Type.HOME);
		view.addDrawable(home);
		view.update();
	}
	public void drawActiveRides() { //Draw all the ongoing rides.
		for(Ride r : this.activeRides.getAll()) {
			if(r.isActive()) {
				for(GPSPoint p : r.getRoute().getRoute()) {
					view.addDrawable(p);
				}
				view.addDrawable(r.getRoute());
			}
			view.update();
		}
	}
	public void drawWorkers() { // Draw all the workers on the map.
		for(Ride r: this.activeRides.getAll()) {
			if(r.getWorker().isHome() == false) {
				view.addDrawable(r.getWorker());
			}
			view.update();
		}
	}
	public void refreshActiveRides() {
		// TODO : change this function so it removes inactive rides from the list
		// instead of using an attribute. Problem : can't edit an ArrayList while parsing it.
		for(Ride r : this.activeRides.getAll()) {
			if(r.isDelivered() && (r.getWorker().getPosition().getX() == 300 && r.getWorker().position.getY() == 300 )) {
				r.setInactive();

			}
		}
	}
	public void passTime() { // pass 1 minute of time.
		this.refreshActiveRides();
		for(Ride r : this.activeRides.getAll()) {
			if(r.isActive()) {
				if(r.getWorker().getPosition().getX() == r.getRoute().get(r.getRoute().getSize()-1).getX() && r.getWorker().getPosition().getY() == r.getRoute().get(r.getRoute().getSize()-1).getY() && r.isDelivered() == false) {
					r.deliver(); // Let's suppose deliver an order takes 1min.
				}
				else {
					r.step(); // Advance through the ride.
				}
			}
		}
		this.drawWorkers(); 
		view.update(); // Refresh workers position after stepping.
	}
	public void drawMap() { // I guess you recognized the city
		Background map = new Background();
		view.addDrawable(map);
		view.update();
	}

}
