package connexion;
import java.util.ArrayList;
import amenagement.Amenagement;
import processing.core.PApplet;
import processing.core.PShape;

public abstract class Connexion extends Amenagement {
	public Connexion(PApplet parent, PShape model, double r, double theta, double phi) {
		super(parent, model, r, theta, phi);
		// TODO Auto-generated constructor stub
	}

	private ArrayList<Amenagement> listeVilles;
}