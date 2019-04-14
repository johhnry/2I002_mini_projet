package amenagement.domestique;

import processing.core.PApplet;
import terrain.Terrain;

public class Maison extends Domestique {
	public static final String filename = "maison.obj";
	private static String filename_destroy = "maison_destroy.obj";

	public Maison(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, filename_destroy, theta, phi);
		this.capacite = (int) (Math.random()*5) + 1; 
	}

	public void utiliser() {
		terrain.getEau().reduireQt(this.capacite*0.05);
	}

	public void rejeter() {
		terrain.getEau().reduireQual(this.capacite*0.0001);
		terrain.getAir().reduireQual(this.capacite*0.00005);
	}

	public boolean update() {
		utiliser();
		if (parent.frameCount%50==0) rejeter();
		return true;
	}
}