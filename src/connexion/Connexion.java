package connexion;
import amenagement.Amenagement;
import processing.core.PApplet;
import terrain.Terrain;

public abstract class Connexion extends Amenagement {
	//private ArrayList<Amenagement> listeVilles;
	
	public Connexion(PApplet parent, Terrain terrain, String filename, double theta, double phi) {
		super(parent, terrain, filename,"", theta, phi);
	}
}