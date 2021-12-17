package projet;

import javax.swing.SwingUtilities;
public class Main{
	public static void main(String[] args){
		Model model = new Model();
		try {
			// creating the window (view)in EDT thread
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					View view = new View("SpeedyDelivery", 600, 600);
					model.setView(view);
					view.setVisible(true);
					model.drawMap();
					model.drawHome();
					model.drawActiveRides();
				}
			});
			while(true) {
				try {
					Thread.sleep(1000);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				model.passTime();
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
