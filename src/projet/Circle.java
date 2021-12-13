package projet;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe des cercles qu'on peut dessiner dans une interface graphique.
 * Les coordonnées du centre et le rayon d'un cercle sont exprimés en nombre de pixels.
 */
public class Circle implements Drawable {
	private int x, y;		// coordonnées du centre
	private int r;			// rayon
	private Color col;		// couleur
	private boolean plain;	// cercle plein (disque) ou pas
	
	/**
	 * Constructeur
	 * @param x abcisse du centre
	 * @param y ordonnée du centre
	 * @param r rayon
	 */
	public Circle(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.col = Color.BLACK;
		this.plain = false;
	}
	
	/**
	 * @return abcisse du centre de this
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return ordonnée du centre de this
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return rayon de this
	 */
	public int getRadius() {
		return r;
	}

	/**
	 * Modification de l'abcisse du centre de this
	 * @param x nouvelle valeur de l'abcisse
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Modification de l'ordonnée du centre de this
	 * @param y nouvelle valeur de l'ordonnée
	 */
	public void setY(int y) {
		this.y = y;
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
	 * Modification du remplissage
	 * @param b vrai si on remplit this, faux sinon
	 */
	public void setFill(boolean b) {
		this.plain = b;
	}
	
	/**
	 * Méthode de dessin
	 * @param g objet graphique dans lequel on dessine this
	 */
	public void draw(Graphics g) {
		g.setColor(col);
		
		int x = this.getX() - this.getRadius(),
			y = this.getY() - this.getRadius(),
			d = 2 * this.getRadius();
		
		if (plain)
			g.fillOval(x, y, d, d);
		else
			g.drawOval(x, y, d, d);
	}
}
