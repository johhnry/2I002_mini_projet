package mammifere;
import animal.Animal;
import processing.core.PApplet;

public abstract class Mammifere extends Animal {
	public Mammifere(PApplet parent, double r, double theta, double phi) {
		super(parent, r, theta, phi);
	}
}