package connexion;

import processing.core.PApplet;
import terrain.Terrain;

public class LigneAerienne extends Connexion {

	public LigneAerienne(PApplet parent, Terrain terrain, String filename, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
	}

	public void utiliser() {
	}

	public void rejeter() {
	}

	public boolean update() {
		return false;
	}
}