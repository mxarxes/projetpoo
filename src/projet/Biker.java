package projet;

public class Biker extends Worker {
	public Biker(String name, double weight, double salary, Classe classe ) {
		super(name, weight, salary,classe);
	}

	@Override
	public double getSpeed() {
		// TODO Auto-generated method stub
		return this.speed;
	}
}
