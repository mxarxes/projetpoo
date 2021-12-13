package projet;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.SwingUtilities;

/**
 * Un objet Model peut contenir des objets Drawable et les dessiner dans une vue graphique.
 */
public class Model {
	private View view;	// fenêtre graphique
	
	/**
	 * Constructeur
	 */
	public Model() {
		view = null;
	}

	/**
	 * Affectation de la vue
	 *  @param view nouvelle vue liée à this
	 */
	public void setView(View view) {
		this.view = view;
	}

	/**
	 * Example d'insertion d'un objet graphique dans la vue et de mise
	 * à jour de la vue via view.update()
	 */
	public void drawHome() {
		Circle home = new Circle(640,360,10);
		home.setColor(Color.RED);
		home.setFill(true);

		// ajout du cercle dans la vue et mise à jour de la vue
		view.addDrawable(home);
		view.update();
	}
	public void drawActiveRides(ArrayList<Ride> activeRides) {
		for(Ride r : activeRides) {
			Circle pos = new Circle((int)r.getWorker().getPosition().getX(),(int)r.getWorker().getPosition().getY(),3);
			pos.setColor(Color.BLACK);
			pos.setFill(true);
			
			view.addDrawable(pos);
			view.update();
		}
	}

}
