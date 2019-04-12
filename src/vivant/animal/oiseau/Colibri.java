package vivant.animal.oiseau;

import processing.core.PApplet;
import ressource.Air;
import terrain.Terrain;

public class Colibri extends Oiseau {
	private static final String filename = "colibri.obj";
	private static double pReprodColibri = 0.006;
	private static int altColibri = 20;

	public Colibri(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, theta, phi, altColibri);
		old = Math.random()/70 + 0.001;
	}
	
	public Colibri(PApplet parent, Terrain terrain) {
		super(parent, terrain, filename, altColibri);
		old = Math.random()/70 + 0.001;
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
	
	public boolean update() {
		updateVivant();
		if (!estVivant()) {
			terrain.getMineral().augmenterQt(0.5);
			return false;
		}
		return true;
	}
	
	public void reproduce() {
		if (Math.random() <= pReprodColibri) {
			terrain.addElement(new Colibri(parent, terrain, theta, phi));
		}
	}
}