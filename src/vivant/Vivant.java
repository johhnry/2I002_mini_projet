package vivant;

import element.Element;
import processing.core.PApplet;
import processing.core.PShape;

public abstract class Vivant extends Element implements Respirer, Sustenter {
	private double ptsVie;
	public Vivant(PApplet parent, PShape model, double r, double theta, double phi) {
		super(parent, model, r, theta, phi);
		this.ptsVie = 1;
	}
}