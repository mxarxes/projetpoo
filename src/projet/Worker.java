package projet;

public abstract class Worker {
	String name;
	 double weight;
	 double salary;
	 double speed;
	 double payload;

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
	 public abstract double getSpeed();
	 
}
