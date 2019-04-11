package terrain;

import processing.core.PApplet;

public class Soleil {
	private PApplet parent;
	private int rX, rY, posX, posY;
	private float angle = 0;
	private float rotation;
	
	public Soleil(PApplet parent, Terrain terrain, float rotation) {
		this.parent = parent;
		this.rX = terrain.getRayon()*3;
		this.rY = terrain.getRayon()*4;
		this.posX = terrain.getPosX();
		this.posY = terrain.getPosY();
		this.rotation = rotation;
	}
	
	public void display() {
		parent.pushMatrix();
		parent.translate(posX, posY);
		parent.rotateZ(rotation);
		parent.pointLight(255,251,216, (float)Math.cos(this.angle)*rX, (float)Math.sin(this.angle)*rY, 0);
		parent.popMatrix();
	}
	
	public void update() {
		angle += 0.01;
	}
}
