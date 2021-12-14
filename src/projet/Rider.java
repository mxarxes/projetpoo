package projet;

import java.awt.Graphics;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class Rider extends Worker {

	public Rider(String name, double weight, double salary) {
		super(name, 0, salary);
		try {
			this.image = ImageIO.read(new FileInputStream("resource/images/moto.png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public double getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(image,this.getPosition().getX()-12,this.getPosition().getY()-12,24,24,null);
	}

}
