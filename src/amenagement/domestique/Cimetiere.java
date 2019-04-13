package amenagement.domestique;

import processing.core.PApplet;
import terrain.Terrain;

public class Cimetiere extends Domestique {
	private static final String filename = "cimetiere.obj";
	private static int cptCimetiere = 0;
	private final int id;
	
	public Cimetiere(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, "", theta, phi);
		this.id = ++cptCimetiere;
	}

	public void utiliser() {
	}

	public void rejeter() {
	}

	public boolean update() {
		return true;
	}
	
	public int getId() {
		return this.id;
	}
}