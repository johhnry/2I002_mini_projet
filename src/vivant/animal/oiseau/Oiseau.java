package vivant.animal.oiseau;
import processing.core.PApplet;
import processing.core.PShape;
import vivant.animal.Animal;

public abstract class Oiseau extends Animal {

	public Oiseau(PApplet parent, PShape model, double r, double theta, double phi) {
		super(parent, model, r+50, theta, phi);
	}
}