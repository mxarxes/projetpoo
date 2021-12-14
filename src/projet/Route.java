package projet;
import java.awt.Graphics;
import java.util.ArrayList;
import java.lang.Math;
import java.awt.Color;
public class Route implements Drawable {
	private ArrayList<GPSPoint> route = new ArrayList<GPSPoint>();
	private Color col;
	public Route(ArrayList<GPSPoint> route) {
		this.route = route;
		int c = (int)(Math.random()*10);
		if(c>8) {
			this.col = Color.BLUE;
		}
		else if(c>6) {
			this.col = Color.PINK;
		}
		else if(c>4) {
			this.col = Color.GREEN;
		}
		else if(c>2) {
			this.col = Color.CYAN;
		}
		else {
			this.col = Color.MAGENTA;
		}
	}



	/**
	 * @return la distance totale d'un trajet en km
	 */
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
	public int getSize() {
		return this.route.size();
	}
	public GPSPoint get(int i) {
		return this.route.get(i);
	}
	public ArrayList<GPSPoint> getRoute(){
		return this.route;
	}

	public Route reverse(){
		return this; //TODO implement this function
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(this.col);
		for(int i=0;i<this.route.size()-1;i++) {
			g.drawLine(this.get(i).getX(),this.get(i).getY(),this.get(i+1).getX(),this.get(i+1).getY());
		}
	}
}
