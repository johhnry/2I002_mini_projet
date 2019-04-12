package terrain;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;

public class Soleil {
	private PApplet parent;
	private int rX, rY, posX, posY;
	private float angle = 0;
	private float rotation;
	private PShape sun;
	private float r=225, g=251, b=216;

	public Soleil(PApplet parent, Terrain terrain, float rotation, int radius) {
		this.parent = parent;
		this.rX = terrain.getRayon()*4;
		this.rY = terrain.getRayon()*5;
		this.posX = terrain.getPosX();
		this.posY = terrain.getPosY();
		this.rotation = rotation;
		this.sun = parent.createShape(PConstants.SPHERE, radius);
		this.sun.setTexture(parent.loadImage("texture/sunmap.jpg"));
		this.sun.setEmissive(10);
		this.sun.setStroke(false);
	}

	public void display() {
		parent.fill(255);
		parent.pushMatrix();
		parent.translate(posX, posY);
		parent.rotateZ(rotation);
		parent.translate((float)Math.cos(this.angle)*rX, (float)Math.sin(this.angle)*rY);
		parent.pointLight(r,g,b, 0, 0, 0);
		sun.setEmissive(parent.color(r,g,b));
		parent.shape(sun);
		parent.popMatrix();
	}

	public void update() {
		angle += 0.01;
	}

	public void setRGB(float r, float g, float b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
}
