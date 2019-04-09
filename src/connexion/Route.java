package connexion;

import processing.core.PApplet;
import terrain.Terrain;

public class Route extends Connexion {

	public Route(PApplet parent, Terrain terrain, String filename, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
	}

	@Override
	public void utiliser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejeter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}
}