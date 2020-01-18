package element;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;
import terrain.Terrain;
import main.Simulation;

/*
 * The Element class is the base class for every 3d object in the scene
 */
public abstract class Element {
	protected PApplet parent;
	protected Terrain terrain;
	private PShape model;
	protected double theta;
	protected double phi;
	protected int altitude = 0;
	protected double orient = 0;

	public Element(PApplet parent, Terrain terrain, String filename, double theta, double phi) {
		this.parent = parent;
		this.terrain = terrain;

		//Load the .obj model
		this.loadModel(filename);

		this.theta = theta;
		this.phi = phi;
	}

	//Constructor for spawning element at random location on the planet
	public Element(PApplet parent, Terrain terrain, String filename) {
		this(parent, terrain, filename, Math.random()*(Math.PI*2), Math.random()*(Math.PI*2));
	}

	public void display() {
		parent.pushMatrix();
		
		parent.rotateY((float) theta);
		parent.rotateX((float) phi);
		parent.rotateZ(-PConstants.HALF_PI + (float)orient); 
		parent.translate(0, 0, (terrain.getRayon() + this.altitude));
		parent.shape(model,0,0);
		
		parent.popMatrix();
	}

	public float getPhi() {
		return (float)phi;
	}

	public abstract boolean update();

	public void setPhi(double d) {
		this.phi = d;
	}

	public float getTheta() {
		return (float)theta;
	}

	public void setTheta(double d) {
		this.theta = d;
	}

	public void setOrient(double dirX, double dirY) {
		this.orient = Math.atan(dirY/dirX);
	}
	
	//Load the .obj model from the main simulation class
	public void loadModel(String filename) {
		this.model = ((Simulation)parent).getModel(filename);
	}
}