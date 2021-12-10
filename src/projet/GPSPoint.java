package projet;
import java.lang.Math;

public class GPSPoint {
	private double lat;
	private double longi;
	
	public GPSPoint(double lat,double longi){
		this.lat = lat;
		this.longi = longi;
	}
	public double getLat() {
		return this.lat;
	}
	public double getLong() {
		return this.longi;
	}
	public double dist(GPSPoint p) {
		/*double la = this.getLat();
		double La = this.getLong();
		double lb = p.getLat();
		double Lb = p.getLong();
		double sinla = Math.sin(la);
		double sinlb = Math.sin(lb);
		double cosla = Math.cos(la);
		double coslb = Math.cos(lb);
		double dL = Lb-La;
		double cosdL = Math.cos(dL);
		return 6371*Math.acos((sinla*sinlb + cosla*coslb*cosdL));*/
		//2e methode avec moins de variables intermédiaires
		//double sumsin = Math.sin(this.lat)*Math.sin(p.getLat());
		//double sumcos = Math.cos(this.lat)*Math.cos(p.getLat());
		//double deltaLongi = Math.cos(p.getLong()-this.getLong());
		//double angDist = Math.acos(sumsin + sumcos*deltaLongi);
		//return angDist*6371;
		
		//3e méthode rincée;
		return Math.sqrt(Math.pow((p.getLat()-this.lat),2)+Math.pow((p.getLong()-this.longi),2));
	}
}
