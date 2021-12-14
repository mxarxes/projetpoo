package projet;

import java.awt.Graphics;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import java.awt.Image;

public class Background implements Drawable{
	private Image image;


	public Background() {
		try {
			this.image = ImageIO.read(new FileInputStream("resource/images/map.png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void draw(Graphics g) {
		g.drawImage(image,0,0,600,600,null);
	}

}
