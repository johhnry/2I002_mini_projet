package terrain;

import element.Element;
import processing.core.PApplet;
import vivant.animal.Deplacable;

public class Nuage extends Element implements Deplacable{
	private static float rangeMove = 0.005f;
	private float dirX = (float) (rangeMove/2-Math.random()*rangeMove);
	private float dirY = (float) (rangeMove/2-Math.random()*rangeMove);
	
	public Nuage(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, Nuage.randomFilename(), theta, phi);
		this.altitude = 100;
		this.setOrient(dirX, dirY);
	}
	
	public Nuage(PApplet parent, Terrain terrain) {
		super(parent, terrain, Nuage.randomFilename());
		this.altitude = 100;
		this.setOrient(dirX, dirY);
	}

	public boolean update() {
		return true;
	}
	
	public static String randomFilename() {
		return "nuage"+(int)Math.random()*3+".obj";
	}

	public void move() {
		phi += dirX;
		theta += dirY;
	}
}
