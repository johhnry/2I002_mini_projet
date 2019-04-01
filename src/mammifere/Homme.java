package mammifere;

import processing.core.PApplet;
import processing.core.PShape;
import ressource.Air;
import ressource.Eau;
import ressource.Nourriture;
import ressource.Ressource;

public class Homme extends Mammifere {
	public Homme(PApplet parent, PShape model, double r, double theta, double phi) {
		super(parent, model, r, theta, phi);
	}

	public void move() {
		
	}

	public void respirer(Air air) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void manger(Ressource r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void boire(Eau eau) {
		// TODO Auto-generated method stub
		
	}
}