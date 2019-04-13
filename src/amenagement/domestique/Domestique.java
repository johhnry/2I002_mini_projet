package amenagement.domestique;

import amenagement.Amenagement;
import processing.core.PApplet;
import terrain.Terrain;

public abstract class Domestique extends Amenagement {
	protected int capacite;
	
	public Domestique(PApplet parent, Terrain terrain, String filename, String fd, double theta, double phi) {
		super(parent, terrain, filename, fd, theta, phi);
	}
	
	public Domestique(PApplet parent, Terrain terrain, String filename, String fd) {
		super(parent, terrain, filename, fd);
	}
}