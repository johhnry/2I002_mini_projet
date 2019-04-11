package vivant.animal;

import processing.core.PApplet;
import terrain.Terrain;
import vivant.Vivant;

public abstract class Animal extends Vivant implements Deplacable {
	private static float rangeMove = 0.005f;
	private float offsetIncrX = (float) (Math.random()*0.001),
			offsetIncrY = (float) (Math.random()*0.001);
	private float offsetX = (float)Math.random()*100,
			offsetY = (float)Math.random()*100;

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

	public void move() {
		phi += rangeMove/2-parent.noise(this.offsetX)*rangeMove;
		theta += rangeMove/2-parent.noise(this.offsetY)*rangeMove;
		offsetX += this.offsetIncrX;
		offsetY += this.offsetIncrY;
		this.offsetIncrX = (float) (Math.random()*0.01);
		this.offsetIncrY = (float) (Math.random()*0.01);
	}
}