package vivant.vegetal;

import processing.core.PApplet;
import terrain.Terrain;

public class Fleur extends Vegetal {
	private static String filename = "fleur.obj";
	private static double pReprodFleur = 0.008;

	public Fleur(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
		old = Math.random()/100 + 0.001;
	}
	
	public Fleur(PApplet parent, Terrain terrain) {
		super(parent, terrain, filename);
		old = Math.random()/100 + 0.001;
	}

	public void respirer() {
		terrain.getAir().augmenterQual(0.05);
	}

	public void manger() {
		terrain.getMineral().reduireQt(0.2);
	}

	public void boire() {
		terrain.getEau().reduireQt(0.05);
	}

	public boolean update() {
		updateVivant();
		if (!estVivant()) {
			terrain.getMineral().augmenterQt(1);
			return false;
		}
		return true;
	}
	
	public void reproduce() {
		if (Math.random() <= pReprodFleur) {
			terrain.addElement(new Fleur(parent, terrain, theta+parent.random(-1,1), phi+parent.random(-1,1)));
		}
	}
}