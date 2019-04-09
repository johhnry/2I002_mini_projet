package vivant.vegetal;

import processing.core.PApplet;
import terrain.Terrain;
import vivant.Vivant;

public abstract class Vegetal extends Vivant {

	public Vegetal(PApplet parent, Terrain terrain, String filename, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
	}
	
	public Vegetal(PApplet parent, Terrain terrain , String filename) {
		super(parent, terrain, filename);
	}
}