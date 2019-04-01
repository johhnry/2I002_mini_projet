package element;

import processing.core.PApplet;
import processing.core.PShape;
import processing.core.PVector;

public abstract class Element {
	private PApplet parent;
	private PShape model;
	private double r, theta, phi;

	public Element(PApplet parent, PShape model, double r, double theta, double phi) {
		this.parent = parent;
		this.model = model;
		this.r = r;
		this.theta = theta;
		this.phi = phi;
	}

	public void display() {
		parent.pushMatrix();
		double st = Math.sin(theta);

		float newX = (float)(r*st*Math.cos(phi));
		float newY = (float)(r*st*Math.sin(phi));
		float newZ = (float)(r*Math.cos(theta));

		parent.translate(newX, newY, newZ);
		//double racine = Math.sqrt(newX*newX+newZ*newZ);
		PVector new_vector = new PVector(newX, newY, newZ).normalize();
		parent.rotateX((float) Math.atan(new_vector.z));
		parent.rotateZ((float) Math.acos(new_vector.y));

		parent.shape(model,0,0);
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