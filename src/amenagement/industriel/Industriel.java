package amenagement.industriel;

import amenagement.Amenagement;
import amenagement.Consommer;
import processing.core.PApplet;
import terrain.Terrain;

public abstract class Industriel extends Amenagement implements Consommer{

	public Industriel(PApplet parent, Terrain terrain, String filename, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
	}
	
	public Industriel(PApplet parent, Terrain terrain, String filename) {
		super(parent, terrain, filename);
	}
}