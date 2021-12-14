package projet;
import java.awt.Graphics;
import java.lang.Math;
import java.awt.Color;

public class GPSPoint extends Circle implements Drawable {
	private int x;
	private int y;
	private Type type;
	private boolean isChecked;
	
	public GPSPoint(int x,int y){
		super(x,y,3);
		this.x = x;
		this.y = y;
		this.type = Type.MISC;
		this.isChecked = false;
	}
	public GPSPoint(int x,int y, Type type){
		super(x,y,3);
		this.x = x;
		this.y = y;
		this.type = type;
		this.isChecked = false;
	}
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void addX(int x) {
		this.x += x;
	}
	public void addY(int y) {
		this.y+=y;
	}
	public GPSPoint clone() {
		return new GPSPoint(this.getX(),this.getY());
	}
	public boolean isChecked() {
		return this.isChecked;
	}
	public double dist(GPSPoint p) { //Returns the distance between this and p in km.
		return (Math.sqrt(Math.pow((p.getX()-this.x),2)+Math.pow((p.getY()-this.y),2)));
		//10px = 1km
	}

	public void draw(Graphics g) {
		if(this.type == Type.HOME) {
			g.setColor(Color.RED);
			this.setRadius(7);
		}
		else if(this.type == Type.DEST) {
			g.setColor(Color.GREEN);
		}
		else if(this.type == Type.WORKER) {
			g.setColor(Color.BLACK);
		}
		int x = this.getX() - this.getRadius(),
				y = this.getY() - this.getRadius(),
				d = 2 * this.getRadius();
				g.fillOval(x, y, d, d);
		
	}
}
