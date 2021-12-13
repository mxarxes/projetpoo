package projet;
import java.lang.Math;

public class GPSPoint {
	private double x;
	private double y;
	
	public GPSPoint(double x,double y){
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void addX(double x) {
		this.setX(this.getX()+x);
	}
	public void addY(double y) {
		this.setY(this.getY()+y);
	}
	public double dist(GPSPoint p) { //Returns the distance between this and p in km.
		return (Math.sqrt(Math.pow((p.getX()-this.x),2)+Math.pow((p.getY()-this.y),2)))/10;
		//10px = 1km
	}
}
