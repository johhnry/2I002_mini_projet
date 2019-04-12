package amenagement.industriel;

import processing.core.PApplet;
import terrain.Terrain;

public class Incinerateur extends Industriel {
	private static String filename = "incinerateur.obj";
	//private static String filename_destroy = "incinerateur_destroy.obj";

	public Incinerateur(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
	}

	public Incinerateur(PApplet parent, Terrain terrain) {
		super(parent, terrain, filename);
	}

	@Override
	public void utiliser() {
	}

	@Override
	public void rejeter() {
		terrain.getAir().reduireQual(0.007);
	}

	@Override
	public boolean update() {
		rejeter();
		return true;
	}
}