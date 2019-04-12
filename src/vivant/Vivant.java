package vivant;

import element.Element;
import processing.core.PApplet;
import terrain.Terrain;

public abstract class Vivant extends Element implements Respirer, Sustenter, Reproductible {
	protected double ptsVie = 1;
	protected static double pSustenter = 0.05;
	protected static double pBoire = 0.1;
	protected double old;
	
	public Vivant(PApplet parent, Terrain terrain, String filename, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
	}
	
	public Vivant(PApplet parent, Terrain terrain, String filename) {
		super(parent, terrain, filename);
	}
	
	public boolean estVivant() {
		return ptsVie > 0;
	}
	
	public void updateVivant() {
		respirer();
		if (Math.random() < 0.5) reproduce();
		if (Math.random() < pSustenter) manger();
		if (Math.random() < pBoire) boire();
		this.ptsVie -= (1-terrain.getMoyenneRessources())/1000 + this.old;
	}
}