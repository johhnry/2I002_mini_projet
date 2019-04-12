package amenagement;

import element.Element;
import processing.core.PApplet;
import terrain.Terrain;

public abstract class Amenagement extends Element implements Consommer{
	protected boolean destroy = false;
	protected static String filename_destroy;
	
	public Amenagement(PApplet parent, Terrain terrain, String filename, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
	}
	
	public Amenagement(PApplet parent, Terrain terrain, String filename) {
		super(parent, terrain, filename);
	}
	
	public void destroy() {
		if(!destroy) {
			this.loadModel(filename_destroy);
			destroy = true;
		}
	}
}