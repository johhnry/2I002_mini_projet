package vivant;

import element.Element;
import processing.core.PApplet;

public abstract class Vivant extends Element implements Respirer, Manger {
	private float ptsVie;
	public Vivant(PApplet parent, double r, double theta, double phi) {
		super(parent, r, theta, phi);
		this.ptsVie = 1;
	}
}