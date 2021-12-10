package projet;
import java.util.*;
import java.lang.*;
public class Route {
	private ArrayList<GPSPoint> route;
	
	public Route(ArrayList<GPSPoint> route) {
		this.route = route;
	}
	
	public double totalDistance() {
		double d = 0;
		for(int i=0;i<this.route.size()-1;i++) {
			d+=this.route.get(i).dist(this.route.get(i+1));
		}
		return d;
	}
	
}
