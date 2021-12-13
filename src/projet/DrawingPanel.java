package projet;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

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
	
	private List<Drawable> drawList;	// liste des objets à dessiner

	/**
	 * Constructeur
	 */
	public DrawingPanel() {
		super();
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(Color.WHITE);
		drawList = Collections.synchronizedList(new ArrayList<Drawable>());
	}

	/**
	 * Ajoute un objet à dessiner dans this
	 * @param obj objet ajouté dans la liste des objets
	 */
	public void addDrawable(Drawable obj) {
		drawList.add(obj);
	}
	
	/**
	 * Retire un objet à dessiner de this
	 * @param obj objet retiré de la liste des objets
	 */
	public void removeDrawable(Drawable obj) {
		drawList.remove(obj);
	}

	/**
	 * Vide la liste des objets à dessiner
	 */
	public void clearDrawable() {
		drawList.clear();
	}

	/**
	 * Mise à jour du panel
	 * 
	 * On doit appeler cette méthode quand on a modifié la liste des
	 * objets à dessiner et qu'on veut redessiner
	 * 
	 * Appel automatique de paintComponent via repaint
	 */
	public void update() {
		repaint();
	}

	/**
	 * Méthode de dessin (qu'il ne faut pas appeler directement)
	 */
	public void paintComponent(Graphics g) {
		synchronized(drawList) {
			for (Drawable obj : drawList)
				obj.draw(g);
		}
	}

}
