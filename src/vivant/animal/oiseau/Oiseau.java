package vivant.animal.oiseau;
import processing.core.PApplet;
import terrain.Terrain;
import vivant.animal.Animal;

public abstract class Oiseau extends Animal {

	public Oiseau(PApplet parent, Terrain terrain, String filename, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
	}
	
	public Oiseau(PApplet parent, Terrain terrain , String filename, int altitude) {
		super(parent, terrain, filename);
		this.r = terrain.getRayon()+altitude;
	}
	
}