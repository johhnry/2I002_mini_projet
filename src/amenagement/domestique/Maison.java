package amenagement.domestique;

import processing.core.PApplet;
import terrain.Terrain;

public class Maison extends Domestique {
	public static String filename = "maison.obj";

	public Maison(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
		this.capacite = (int) (Math.random()*5) + 1; 
	}

	@Override
	public void utiliser() {
		terrain.getEau().reduireQt(this.capacite*0.5);
	}

	@Override
	public void rejeter() {
		terrain.getEau().reduireQual(this.capacite*0.0001);
		terrain.getAir().reduireQual(this.capacite*0.00005);
	}

	@Override
	public boolean update() {
		utiliser();
		rejeter();
		return true;
	}
}