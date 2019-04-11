package vivant.animal.reptile;
import processing.core.PApplet;
import terrain.Terrain;
import vivant.animal.Animal;

public abstract class Reptile extends Animal {
	
	public Reptile(PApplet parent, Terrain terrain, String filename, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
	}
	
	public Reptile(PApplet parent, Terrain terrain , String filename) {
		super(parent, terrain, filename);
	}
}