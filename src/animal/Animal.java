package animal;
import processing.core.PApplet;
import vivant.Vivant;

public abstract class Animal extends Vivant implements Deplacable {
	public Animal(PApplet parent, double r, double theta, double phi) {
		super(parent, r, theta, phi);
	}

	public void move(double p, double t) {
		this.setPhi(this.getPhi()+p);
		this.setTheta(this.getTheta()+t);
	}
}