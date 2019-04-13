package amenagement.domestique;

import processing.core.PApplet;
import terrain.Terrain;

public class Immeuble extends Domestique {
	private static String filename = "immeuble.obj";
	private static String filename_destroy = "immeuble_destroy.obj";

	public Immeuble(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, filename_destroy, theta, phi);
		this.capacite = (int) (Math.random()*20) + 1; 
	}
	
	public Immeuble(PApplet parent, Terrain terrain) {
		super(parent, terrain, filename, filename_destroy);
	}

	@Override
	public void utiliser() {
		terrain.getEau().reduireQt(this.capacite*0.1);
	}

	@Override
	public void rejeter() {
		terrain.getEau().reduireQual(this.capacite*0.0001);
		terrain.getAir().reduireQual(this.capacite*0.0001);
	}

	@Override
	public boolean update() {
		utiliser();
		if (parent.frameCount%50==0) rejeter();
		return true;
	}
}