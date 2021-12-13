package projet;
import java.util.ArrayList;
public class Route {
	private ArrayList<GPSPoint> route = new ArrayList<GPSPoint>();
	
	public Route(GPSPoint destination) {
		this.route.add(new GPSPoint(640,360));
		this.route.add(destination);
	}
	
	public double totalDistance() {
		double d = 0;
		for(int i=0;i<this.route.size()-1;i++) {
			d+=this.route.get(i).dist(this.route.get(i+1));
		}
		return d;
	}
	public GPSPoint destination() {
		return this.route.get(1);
	}
}
