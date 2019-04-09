package amenagement.domestique;

import amenagement.Amenagement;
import processing.core.PApplet;
import terrain.Terrain;

public abstract class Domestique extends Amenagement {
	protected int capacite;
	
	public Domestique(PApplet parent, Terrain terrain, String filename, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
	}
	
	public Domestique(PApplet parent, Terrain terrain, String filename) {
		super(parent, terrain, filename);
	}
}