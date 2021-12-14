package projet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.BasicStroke;

import java.util.*;

/**
 * Cette classe représente un panel de dessin de type JPanel.
 * Un objet DrawingPanel contient une liste d'objets de type Drawable.
 * 
 * Ces objets Drawable sont dessinés dans le panel lors de l'appel
 * de la méthode update qui appelle elle-même la méthode paintComponent.
 *
 */
public class DrawingPanel extends JPanel {
	private static final long serialVersionUID = 1L; //Eclipse Quick Fix, hate warnings
	private List<Drawable> drawList;

	public DrawingPanel() {
		super();
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(Color.WHITE);
		drawList = Collections.synchronizedList(new ArrayList<Drawable>());
	}

	public void addDrawable(Drawable obj) {
		drawList.add(obj);
	}
	

	public void removeDrawable(Drawable obj) {
		drawList.remove(obj);
	}

	public void clearDrawable() {
		drawList.clear();
	}

	public void update() {
		repaint();
	}

	public void paintComponent(Graphics g) {

	    synchronized(drawList) {

		    super.paintComponent(g);
		    Graphics2D g2 = (Graphics2D) g;
		    g2.setStroke(new BasicStroke(2));
			for (Drawable obj : drawList)
				obj.draw(g);
		}
	}

}
