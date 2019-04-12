package vivant.vegetal;

import processing.core.PApplet;
import terrain.Terrain;

public class Arbre extends Vegetal {
	private static String filename = "arbre.obj";
	private static double pReprodArbre = 0.0001;

	public Arbre(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
	}
	
	public Arbre(PApplet parent, Terrain terrain) {
		super(parent, terrain, filename);
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

	public void reproduce() {
		if (Math.random() <= pReprodArbre) {
			terrain.addElement(new Arbre(parent, terrain, theta+parent.random(-1,1), phi+parent.random(-1,1)));
		}
	}
}