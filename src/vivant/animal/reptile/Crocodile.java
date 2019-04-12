package vivant.animal.reptile;

import processing.core.PApplet;
import ressource.Air;
import terrain.Terrain;

public class Crocodile extends Reptile {
	private static final String filename = "crocodile.obj";
	private static double pReprodCrocodile = 0.0007;
	
	//duree de vie environ 20 ans
	public Crocodile(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
		old = Math.random()/300 + 0.001;
	}
	
	public Crocodile(PApplet parent, Terrain terrain) {
		super(parent, terrain, filename);
		old = Math.random()/300 + 0.001;
	}

	public void respirer() {
		Air air = this.terrain.getAir();
		air.reduireQt(0.15);
		air.reduireQual(0.002);
	}

	public void manger() {
		this.terrain.getNourriture().reduireQt(0.06);
	}

	public void boire() {
		this.terrain.getEau().reduireQt(1);
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
		if (Math.random() <= pReprodCrocodile) {
			terrain.addElement(new Crocodile(parent, terrain, theta, phi));
		}
	}
}