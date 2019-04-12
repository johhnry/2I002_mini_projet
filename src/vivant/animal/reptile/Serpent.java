package vivant.animal.reptile;

import processing.core.PApplet;
import ressource.Air;
import terrain.Terrain;

public class Serpent extends Reptile {
	private static final String filename = "serpent.obj";
	private static double pReprodSerpent = 0.008;
	
	//duree de vie environ 15 ans
	public Serpent(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
		old = Math.random()/100 + 0.001;
	}
	
	public Serpent(PApplet parent, Terrain terrain) {
		super(parent, terrain, filename);
		old = Math.random()/100 + 0.001;
	}

	public void respirer() {
		Air air = this.terrain.getAir();
		air.reduireQt(0.1);
		air.reduireQual(0.001);
	}

	public void manger() {
		this.terrain.getNourriture().reduireQt(0.02);
	}

	public void boire() {
		this.terrain.getEau().reduireQt(0.7);
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
		if (Math.random() <= pReprodSerpent) {
			terrain.addElement(new Serpent(parent, terrain, theta, phi));
		}
	}
}