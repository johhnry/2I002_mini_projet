package oiseau;
import animal.Animal;
import processing.core.PApplet;
import processing.core.PShape;

public abstract class Oiseau extends Animal {

	public Oiseau(PApplet parent, PShape model, double r, double theta, double phi) {
		super(parent, model, r+50, theta, phi);
	}
}