package amenagement;

import java.util.ArrayList;
import domestique.Domestique;
import processing.core.PApplet;
import processing.core.PShape;

public class Ville extends Amenagement {
    public Ville(PApplet parent, PShape model, double r, double theta, double phi) {
		super(parent, model, r, theta, phi);
		// TODO Auto-generated constructor stub
	}

	private ArrayList<Domestique> listDomestiques;
}