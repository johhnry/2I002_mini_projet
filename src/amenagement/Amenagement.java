package amenagement;

import element.Element;
import processing.core.PApplet;
import terrain.Terrain;

public abstract class Amenagement extends Element implements Consommer{
	protected boolean destroy = false;
	protected String fDestroy;
	
	public Amenagement(PApplet parent, Terrain terrain, String filename, String fd, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
		fDestroy = fd;
	}
	
	public Amenagement(PApplet parent, Terrain terrain, String filename, String fd) {
		super(parent, terrain, filename);
		fDestroy = fd;
	}
	
	public void destroy() {
		if(!destroy) {
			this.loadModel(fDestroy);
			destroy = true;
		}
	}
}