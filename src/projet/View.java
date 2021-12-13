package projet;
import java.awt.*;
import javax.swing.*;

/**
 * Cette classe représente une fenêtre graphique de type JFrame dans lequel
 * se trouve un panel pour dessiner de type JPanel.
 */
public class View extends JFrame {
	private DrawingPanel panel;		// panel de dessin

	/**
	 * Constructeur de la fenêtre
	 * @param title titre
	 * @param w largeur en nombre de pixels
	 * @param h hauteur en nombre de pixels
	 */
	public View(String title, int w, int h) {
		super(title);
		setPreferredSize(new Dimension(w, h));

		// création du panel de dessin et ajout dans this
		panel = new DrawingPanel();
		getContentPane().add(panel);

		setLocationRelativeTo(null);
		setResizable(false);
		pack();
	}

	/**
	 * Ajout d'un objet à dessiner dans le panel de dessin
	 * @param obj objet à dessiner
	 */
	public void addDrawable(Drawable obj) {
		panel.addDrawable(obj);
	}

	/**
	 * Mise à jour de la vue qui est redessinée
	 */
	public void update() {
		panel.update();
		getContentPane().repaint();
	}
}
