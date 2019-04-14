package vivant.vegetal;

import processing.core.PApplet;
import terrain.Terrain;

public class Arbre extends Vegetal {
	private static final String filename = "arbre.obj";
	private static double pReprodArbre = 0.0001;
	private static int oldArbre = 1000;

	public Arbre(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
		old = Math.random()/oldArbre + 0.001;
	}
	
	public Arbre(PApplet parent, Terrain terrain) {
		super(parent, terrain, filename);
		old = Math.random()/oldArbre + 0.001;
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

	public static double getpReprodArbre() {
		return pReprodArbre;
	}

	public static void setpReprodArbre(double pReprodArbre) {
		Arbre.pReprodArbre = pReprodArbre;
	}

	public static int getOldArbre() {
		return oldArbre;
	}

	public static void setOldArbre(int oldArbre) {
		Arbre.oldArbre = oldArbre;
	}
}