package projet;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe des cercles qu'on peut dessiner dans une interface graphique.
 * Les coordonnées du centre et le rayon d'un cercle sont exprimés en nombre de pixels.
 */
public class Line implements Drawable {
	private GPSPoint origin;
	private GPSPoint destination;
	private Color col;		// couleur
	
	/**
	 * Constructeur
	 * @param x abcisse du centre
	 * @param y ordonnée du centre
	 * @param r rayon
	 */
	public Line(GPSPoint origin, GPSPoint destination) {
		this.origin = origin;
		this.destination = destination;
		this.col = Color.BLACK;
	}
	
	/**
	 * @return abcisse du centre de this
	 */
	public int getXA() {
		return this.origin.getX();
	}

	/**
	 * @return ordonnée du centre de this
	 */
	public int getYA() {
		return this.origin.getY();
	}
	public int getXB() {
		return this.destination.getX();
	}

	/**
	 * @return ordonnée du centre de this
	 */
	public int getYB() {
		return this.destination.getY();
	}
	/**
	 * @return couleur de this
	 */
	public Color getColor() {
		return col;
	}

	/**
	 * Modification de la couleur de this
	 * @param col nouvelle valeur de la couleur
	 * @return this
	 */
	public void setColor(Color col) {
		this.col = col;
	}

	/**
	 * M�thode de dessin
	 * @param g objet graphique dans lequel on dessine this
	 */
	public void draw(Graphics g) {
		g.setColor(col);
		g.drawLine(this.origin.getX(),this.origin.getY(),this.destination.getX(),this.destination.getY());
	}
}
