package vivant.animal;

import processing.core.PApplet;
import terrain.Terrain;
import vivant.Vivant;

public abstract class Animal extends Vivant implements Deplacable {
	public Animal(PApplet parent, Terrain terrain,String filename, double theta, double phi) {
		super(parent, terrain,filename, theta, phi);
	}

	public Animal(PApplet parent, Terrain terrain, String filename) {
		super(parent, terrain, filename);
	}

	public void move(double t, double p) {
		this.setPhi(phi+t);
		this.setTheta(theta+p);
	}
}