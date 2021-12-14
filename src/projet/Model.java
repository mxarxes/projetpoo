package projet;

public class Model {
	private View view;

	public Model() {
		view = null;
	}


	public void setView(View view) {
		this.view = view;
	}


	public void drawHome() {
		GPSPoint home = new GPSPoint(300,300,Type.HOME);
		view.addDrawable(home);
		view.update();
	}
	public void drawActiveRides(RideList activeRides) {
		for(Ride r : activeRides.getAll()) {
			GPSPoint dest = r.getRoute().get(r.getRoute().getSize()-1);
			view.addDrawable(dest);
			view.addDrawable(r.getRoute());
			view.update();
		}
	}
	public void drawWorkers(RideList activeRides) {
		for(Ride r: activeRides.getAll()) {
			view.addDrawable(r.getWorker());
			view.update();
		}
	}
	public void passTime(RideList activeRides) {
		for(Ride r : activeRides.getAll()) {
			r.step();
		}
		view.update();
	}
	public void drawMap() {
		Background map = new Background();
		view.addDrawable(map);
		view.update();
	}

}
