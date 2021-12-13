package projet;

public abstract class Worker {
	String name;
	 double weight;
	 double salary;
	 double speed;
	 double payload;
	 GPSPoint position = new GPSPoint(640,360);

	 public Worker(String name, double weight, double salary, Classe classe) {
		 this.name = name;
		 this.weight = weight;
		 this.salary = salary;
		 if(classe == Classe.RIDER) {
			 this.speed = 0;
		 }
		 else if(classe == Classe.BEGINNER) {
				this.speed = 10;
			}
			else if(classe == Classe.ATHLETIC) {
				this.speed = 15;
			}
			else {
				this.speed = 20;
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
		 return this.position.getX() == 640 && this.position.getY() == 360;
	 }
	 public void goTowards(GPSPoint d) {
		 
	 }
	 public abstract double getSpeed();
	 
}
