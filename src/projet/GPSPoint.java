package projet;
import java.awt.Graphics;
import java.lang.Math;
import java.awt.Color;

public class GPSPoint extends Circle implements Drawable {
	private Type type;
	private boolean isChecked;
	
	public GPSPoint(int x,int y){
		super(x,y,3);
		this.type = Type.MISC;
		this.isChecked = false;
	}
	public GPSPoint(int x,int y, Type type){
		super(x,y,3);
		this.type = type;
		this.isChecked = false;
	}
	public boolean isAnEnd() {
		return (this.type == Type.DEST || (this.getX() == 300 && this.getY() == 300));
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
	/**
	 * 
	 * @param p : the other GPS point.
	 * @return the distance in m between this and p.
	 */
	public double dist(GPSPoint p) {
		double dX = p.getX() - this.x;
		double dY = p.getY() - this.y;
		return (Math.sqrt(Math.pow(dX,2)+Math.pow(dY,2)))*Model.ratio;
	}
	public void check() {
		this.isChecked = true;
	}
	public void uncheck() {
		this.isChecked = false;
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
		else if(this.type == Type.MISC) {
			g.setColor(Color.BLACK);
		}
		int x = this.getX() - this.getRadius(),
				y = this.getY() - this.getRadius(),
				d = 2 * this.getRadius();
				g.fillOval(x, y, d, d);
		
	}
}
