package terrain;

import element.Element;
import processing.core.PApplet;
import vivant.animal.Deplacable;

public class Nuage extends Element implements Deplacable{
	private static float rangeMove = 0.001f;
	private float dirX = (float) (rangeMove/2-Math.random()*rangeMove);
	private float dirY = (float) (rangeMove/2-Math.random()*rangeMove);
	private static int altNuage = 100;
	/*
	private boolean isRaining = true;
	private long rainingSeed = (long) (Math.random()*1000);
	private static int rainingDensity = 2;*/

	public Nuage(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, Nuage.randomFilename(), theta, phi);
		this.altitude = (int) (altNuage+Math.random()*10);
		this.setOrient(dirX, dirY);
	}

	public Nuage(PApplet parent, Terrain terrain) {
		super(parent, terrain, Nuage.randomFilename());
		this.altitude = (int) (altNuage+Math.random()*10);
		this.setOrient(dirX, dirY);
	}

	public void display() {
		super.display();
		
		//Pluie
		/*if (isRaining) {
			float rDis = 0.05f;
			parent.stroke(0,0,255);
			parent.strokeWeight(5);
			for(int j=0;j<5;j++) {
				parent.pushMatrix();
				parent.rotateY((float) (theta+parent.random(-rDis, rDis)));
				parent.rotateX((float) (phi+parent.random(-rDis, rDis)));
				for(int i=0;i<rainingDensity;i++) {
					parent.pushMatrix();
					parent.translate(0,0,this.altitude+terrain.getRayon());
					//parent.translate(0,0,-(this.rainingSeed)%);
					parent.point(0,0,0);
					parent.popMatrix();
				}
				parent.popMatrix();
			}
		}*/
	}

	public boolean update() {
		/*
		if(isRaining) {
			this.rainingSeed += 0.7;
		}*/
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
