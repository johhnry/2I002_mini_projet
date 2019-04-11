package vivant.animal.mammifere;

import processing.core.PApplet;
import terrain.Terrain;
import vivant.animal.Animal;

public abstract class Mammifere extends Animal {
	private static int cptMammifere = 0;
	public Mammifere(PApplet parent, Terrain terrain, String filename, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
		cptMammifere++;
	}
	
	public Mammifere(PApplet parent, Terrain terrain , String filename) {
		super(parent, terrain, filename);
		cptMammifere++;
	}
	
	public static int getCptMammifere() {
		return cptMammifere;
	}
}