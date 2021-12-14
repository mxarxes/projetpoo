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

	public Worker(String name, double weight, double salary, Classe classe) {
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
		this.position.setX(640);
		this.position.setY(360);
	}
	public Worker(String name, double weight, double salary) {
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
		return this.position.getX() == 300 && this.position.getY() == 300;
	}
	public void goTowards(Route route, double speed) {
		double newX,newY;
		boolean lastStep = false;
		GPSPoint nextStep = new GPSPoint(0,0);
		GPSPoint stepAfter = new GPSPoint(0,0);
		for(int i = route.getRoute().size()-1; i > 0; i--) {
			if(route.getRoute().get(i).isChecked() == false) {
				nextStep = route.getRoute().get(i).clone();
				if(i == route.getRoute().size()) {
					lastStep = true;
				}
				else {
					stepAfter = route.getRoute().get(i+1).clone();
				}
			}
		}

		double absoluteDist = (speed*(3.6));
		if(this.getPosition().dist(nextStep) > absoluteDist){
			 newX = this.position.getX() + ((absoluteDist*nextStep.getX())/this.getPosition().dist(nextStep));
			 newY = this.position.getY() + ((absoluteDist*nextStep.getY())/this.getPosition().dist(nextStep));
			this.position.setPosition((int)newX,(int)newY);
		}
		else if(this.getPosition().dist(nextStep) == absoluteDist || (this.getPosition().dist(nextStep) < absoluteDist && lastStep)){
			 newX = nextStep.getX();
			 newY = nextStep.getY();
		}
		else {
			absoluteDist -= this.getPosition().dist(nextStep);
			 newX = nextStep.getX() + ((absoluteDist*stepAfter.getX())/nextStep.dist(stepAfter));
			 newY = nextStep.getY() + ((absoluteDist*stepAfter.getY())/nextStep.dist(stepAfter));
		}
		this.position.setPosition((int)newX, (int)newY);
		/*System.out.println("Worker speed : " + speed + " m/s");
		System.out.println("Moving by " + absoluteDist + " meters");
		System.out.println("Worker " + this.getName() + " moved towards " + nextStep.getX() +" , " + nextStep.getY());
		System.out.println("New position : " +this.getPosition().getX() + " , " + this.getPosition().getY());
	*/
	}

	public abstract double getSpeed();

}
