package element;

import processing.core.PApplet;

public abstract class Element {
	private PApplet parent;
	private double r, theta, phi;

	public Element(PApplet parent, double r, double theta, double phi) {
		this.parent = parent;
		this.r = r;
		this.theta = theta;
		this.phi = phi;
	}

	public void display() {
		parent.pushMatrix();
		parent.translate((float)(r*Math.sin(theta)*Math.cos(phi)), 
				(float)(r*Math.sin(theta)*Math.sin(phi)), 
				(float)(r*Math.cos(theta)));
		parent.sphere(50);
		parent.popMatrix();
	}

	public float getR() {
		return (float) r;
	}

	public void setR(float r) {
		this.r = r;
	}

	public float getPhi() {
		return (float)phi;
	}

	public void setPhi(double d) {
		this.phi = d;
	}

	public float getTheta() {
		return (float)theta;
	}

	public void setTheta(double d) {
		this.theta = d;
	}
}