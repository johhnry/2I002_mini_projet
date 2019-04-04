package amenagement;
import java.util.Vector;

import element.Element;
import processing.core.PApplet;
import processing.core.PShape;
import ressource.Ressource;

public abstract class Amenagement extends Element {

	public Amenagement(PApplet parent, PShape model, double r, double theta, double phi) {
		super(parent, model, r, theta, phi);
		// TODO Auto-generated constructor stub
	}

	public Ressource useRessources;

	public Ressource impactRessources;

	public Integer qtUseRessources;

	public Integer qtImpactRessources;

	public Vector  myTerrain;

}