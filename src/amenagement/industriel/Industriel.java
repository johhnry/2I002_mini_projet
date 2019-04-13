package amenagement.industriel;

import amenagement.Amenagement;
import amenagement.Consommer;
import processing.core.PApplet;
import terrain.Terrain;

public abstract class Industriel extends Amenagement implements Consommer{
	public Industriel(PApplet parent, Terrain terrain, String filename, String fd, double theta, double phi) {
		super(parent, terrain, filename, fd, theta, phi);
	}
	
	public Industriel(PApplet parent, Terrain terrain, String filename, String fd) {
		super(parent, terrain, filename, fd);
	}
}