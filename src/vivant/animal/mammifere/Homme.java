package vivant.animal.mammifere;

import amenagement.Ville;
import amenagement.domestique.Cimetiere;
import processing.core.PApplet;
import ressource.Air;
import terrain.Terrain;

public class Homme extends Mammifere {
	private static final String filename = "homme.obj";
	private static int cptHumain = 0;
	private static double pReprodHomme = 0.001;
	private static int oldHomme = 500;

	public Homme(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
		old = Math.random()/oldHomme + 0.001;
		cptHumain++;
	}
	
	public Homme(PApplet parent, Terrain terrain) {
		super(parent, terrain, filename);
		old = Math.random()/oldHomme + 0.001;
		cptHumain++;
	}

	public void respirer() {
		Air air = this.terrain.getAir();
		air.reduireQt(0.5);
		air.reduireQual(0.00001);
	}

	public void manger() {
		this.terrain.getNourriture().reduireQt(0.03);
	}

	public void boire() {
		this.terrain.getEau().reduireQt(1);
	}
	
	public boolean update() {
		if (Math.random() < 0.00005) terrain.addElement(new Ville(parent, terrain));
		updateVivant();
		if (!estVivant()) {
			cptHumain--;
			terrain.addElement(new Cimetiere(parent, terrain, this.theta, this.phi));
			terrain.getMineral().augmenterQt(2);
			return false;
		}
		return true;
	}
	
	public static int getCptHumain() {
		return cptHumain;
	}
	
	public void reproduce() {
		if (Math.random() <= pReprodHomme) {
			terrain.addElement(new Homme(parent, terrain, theta, phi));
		}
	}
	
	public static double getpReprodHomme() {
		return pReprodHomme;
	}

	public static void setpReprodHomme(double pReprodHomme) {
		Homme.pReprodHomme = pReprodHomme;
	}

	public static int getOldHomme() {
		return oldHomme;
	}

	public static void setOldHomme(int oldHomme) {
		Homme.oldHomme = oldHomme;
	}
}