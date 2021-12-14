package projet;

import java.awt.Graphics;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
public class Biker extends Worker {
	public Biker(String name, double weight, double salary, Classe classe ) {
		super(name, weight, salary,classe);
		try {
			this.image = ImageIO.read(new FileInputStream("resource/images/bike.png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public double getSpeed() {
		// TODO Auto-generated method stub
		return this.speed;
	}

	@Override
	public void draw(Graphics g) {
		int w = image.getWidth(null);
		int h = image.getHeight(null);
		g.drawImage(image,this.getPosition().getX(),this.getPosition().getY(),w,h,null);
	}

}
