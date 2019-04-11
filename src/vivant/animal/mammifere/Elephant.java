package vivant.animal.mammifere;

import processing.core.PApplet;
import ressource.Air;
import terrain.Terrain;

public class Elephant extends Mammifere {
	private static final String filename = "elephant.obj";
	
	//duree de vie environ 60 ans
	public Elephant(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
		old = Math.random()/100 + 0.001;
	}
	
	public Elephant(PApplet parent, Terrain terrain) {
		super(parent, terrain, filename);
		old = Math.random()/100 + 0.001;
	}

	public void respirer() {
		Air air = this.terrain.getAir();
		air.reduireQt(0.6);
		air.reduireQual(0.003);
	}

	public void manger() {
		this.terrain.getNourriture().reduireQt(0.08);
	}

	public void boire() {
		this.terrain.getEau().reduireQt(3);
	}

	public void move() {
		
	}
	
	public boolean update() {
		updateVivant();
		if (!estVivant()) {
			terrain.getMineral().augmenterQt(2);
			return false;
		}
		return true;
	}
}