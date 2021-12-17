package projet;
import java.awt.Image;
public abstract class Worker implements Drawable{
	String name;
	double weight;
	double salary;
	double speed;
	double payload;
	Image image;
	GPSPoint position = new GPSPoint(300,300,Type.WORKER);
	boolean isAvailable;

	public Worker(String name, double weight, double salary, Classe classe) {
		this.isAvailable = true;
		this.name = name;
		this.weight = weight;
		this.salary = salary;
		if(classe == Classe.RIDER) {
			this.speed = 0;
		}
		else if(classe == Classe.BEGINNER) {
			this.speed = 10/3.6;
		}
		else if(classe == Classe.ATHLETIC) {
			this.speed = 15/3.6;
		}
		else {
			this.speed = 20/3.6;
		}
		this.payload = (this.weight/8);
		this.position.setX(300);
		this.position.setY(300);
	}
	public Worker(String name, double weight, double salary) {
		this.isAvailable = true;
		this.name = name;
		this.weight = weight;
		this.salary = salary;
		this.payload = (this.weight/8);
	}
	public double getPayload() {
		return this.payload;
	}
	public String getName() {
		return this.name;
	}
	public double getSalary() {
		return this.salary;
	}
	public GPSPoint getPosition() {
		return this.position;
	}
	public boolean isAvailable() {
		return this.isAvailable;
	}
	public void setBusy() {
		this.isAvailable = false;
	}
	public void setAvailable() {
		this.isAvailable = true;
	}
	public boolean isHome() {
		return this.getPosition().getX() == 300 && this.getPosition().getY() == 300;
	}
	/**
	 * 
	 * @param route
	 * @return the next point the worker has to go to.
	 */
	public GPSPoint getNextPoint(Route route){
		GPSPoint nextStep = new GPSPoint(0,0);
		for(int i=route.getSize()-1; i > 0 ; i--) {
			if(route.get(i).isChecked() == false) {
				nextStep = route.get(i);
			}
		}
		return nextStep;
	}
	public void goToPoint(GPSPoint p) {
		this.getPosition().setPosition(p.getX(), p.getY());
		p.check();
	}
	/**
	 * 
	 * @param route : the route in which the worker must advance.
	 * @param mobility : the distance in meters this worker must go through.
	 */
	public void advance(Route route, double mobility) {
	GPSPoint nextStep = getNextPoint(route);
		double distanceFromNext = this.getPosition().dist(nextStep); // H in meters
		if(mobility <= distanceFromNext ){ //The worker will go towards the next point.

			double dX = (nextStep.getX() - this.getPosition().getX())*Model.ratio; // A 
			double dY = (nextStep.getY() - this.getPosition().getY())*Model.ratio; // O
			//Composants of distanceFromNext, projected on x and on y.

			double stepX = (mobility*dX)/distanceFromNext; // a
			double stepY = (mobility*dY)/distanceFromNext; // o
			//Composants of the next "step" of the worker, projected on x and y.
			//Using Thales' Theorem.
			this.getPosition().setX((int)(this.getPosition().getX()+stepX/Model.ratio));
			this.getPosition().setY((int)(this.getPosition().getY()+stepY/Model.ratio));
		}
		else if((mobility > distanceFromNext && nextStep.isAnEnd() )|| mobility == distanceFromNext ){
			//if the end of the ride is less than one step away or exactly one step away,
			//the worker will stop at the next step. (=> the end of the ride.);
			this.goToPoint(nextStep);
		}
		else if(mobility > distanceFromNext) {
			//if the worker can go farther than the next point,
			//it first goes to the next point, then uses what is left
			//of its mobility to go as far as possible towards the point after.
			double remainingMobility = mobility - this.getPosition().dist(nextStep); // remaining mobility after reaching next point
			this.goToPoint(nextStep);
			//nextStep = this.getNextPoint(route);
			this.advance(route, remainingMobility);
		}

	}

	public abstract double getSpeed();

}
