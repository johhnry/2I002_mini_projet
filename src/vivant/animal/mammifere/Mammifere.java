package vivant.animal.mammifere;
import processing.core.PApplet;
import processing.core.PShape;
import vivant.animal.Animal;

public abstract class Mammifere extends Animal {
	public Mammifere(PApplet parent,PShape model, double r, double theta, double phi) {
		super(parent, model, r, theta, phi);
	}
}