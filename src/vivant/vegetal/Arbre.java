package vivant.vegetal;

import processing.core.PApplet;
import terrain.Terrain;

public class Arbre extends Vegetal {
	private static String filename = "arbre.obj";

	public Arbre(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
	}

	public void respirer() {
		terrain.getAir().augmenterQual(0.1);
	}

	public void manger() {
		terrain.getMineral().reduireQt(0.5);
	}

	public void boire() {
		terrain.getEau().reduireQt(0.09);
	}

	public boolean update() {
		updateVivant();
		if (!estVivant()) {
			terrain.getMineral().augmenterQt(3);
			return false;
		}
		return true;
	}
}