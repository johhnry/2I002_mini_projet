package animal;
import processing.core.PApplet;
import processing.core.PShape;
import vivant.Vivant;

public abstract class Animal extends Vivant implements Deplacable {
	public Animal(PApplet parent, PShape model, double r, double theta, double phi) {
		super(parent, model, r, theta, phi);
	}

	public void move(double t, double p) {
		this.setPhi(this.getPhi()+t);
		this.setTheta(this.getTheta()+p);
	}
}