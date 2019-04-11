package vivant.animal.oiseau;

import processing.core.PApplet;
import ressource.Air;
import terrain.Terrain;

public class Aigle extends Oiseau {

	private static final String filename = "aigle.obj";
	
	//duree de vie environ 30 ans
	public Aigle(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
		old = Math.random()/200 + 0.001;
	}
	
	public Aigle(PApplet parent, Terrain terrain) {
		super(parent, terrain, filename, 20);
		old = Math.random()/200 + 0.001;
	}

	public void respirer() {
		Air air = this.terrain.getAir();
		air.reduireQt(0.1);
		air.reduireQual(0.0001);
	}

	public void manger() {
		this.terrain.getNourriture().reduireQt(0.01);
	}

	public void boire() {
		this.terrain.getEau().reduireQt(1);
	}

	/*public void move() {
		
	}*/
	
	public boolean update() {
		updateVivant();
		if (!estVivant()) {
			terrain.getMineral().augmenterQt(0.5);
			return false;
		}
		return true;
	}
}