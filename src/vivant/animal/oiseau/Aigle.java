package vivant.animal.oiseau;

import processing.core.PApplet;
import ressource.Air;
import terrain.Terrain;

public class Aigle extends Oiseau {
	private static final String filename = "aigle.obj";
	private static double pReprodAigle = 0.0009;
	private static int oldAigle = 200;
	private static int altAigle = 20;
	
	//duree de vie environ 30 ans
	public Aigle(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, theta, phi, altAigle);
		old = Math.random()/oldAigle + 0.001;
	}
	
	public Aigle(PApplet parent, Terrain terrain) {
		super(parent, terrain, filename, altAigle);
		old = Math.random()/oldAigle + 0.001;
	}

	public void respirer() {
		Air air = this.terrain.getAir();
		air.reduireQt(0.1);
		air.reduireQual(0.0001);
	}

	public void manger() {
		this.terrain.getNourriture().reduireQt(0.01);
	}

	public void boire() {
		this.terrain.getEau().reduireQt(1);
	}
	
	public boolean update() {
		updateVivant();
		if (!estVivant()) {
			terrain.getMineral().augmenterQt(0.5);
			return false;
		}
		return true;
	}
	
	public void reproduce() {
		if (Math.random() <= pReprodAigle) {
			terrain.addElement(new Aigle(parent, terrain, theta, phi));
		}
	}

	public static double getpReprodAigle() {
		return pReprodAigle;
	}

	public static void setpReprodAigle(double pReprodAigle) {
		Aigle.pReprodAigle = pReprodAigle;
	}

	public static int getOldAigle() {
		return oldAigle;
	}

	public static void setOldAigle(int oldAigle) {
		Aigle.oldAigle = oldAigle;
	}
}