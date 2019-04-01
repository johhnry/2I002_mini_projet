package mammifere;
import animal.Animal;
import processing.core.PApplet;
import processing.core.PShape;

public abstract class Mammifere extends Animal {
	public Mammifere(PApplet parent,PShape model, double r, double theta, double phi) {
		super(parent, model, r, theta, phi);
	}
}