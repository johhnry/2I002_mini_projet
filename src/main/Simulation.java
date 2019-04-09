package main;

import processing.core.PApplet;
import terrain.Terrain;
import amenagement.Ville;
import peasy.PeasyCam;
import controlP5.*;

public class Simulation extends PApplet{
	PeasyCam camera;
	Terrain terrain;
	ControlP5 cp5;
	
	public static void main(String[] args) {
		PApplet.main("main.Simulation");
	}

	public void settings(){
		size(800,800,P3D);
		//fullScreen(P3D);
	}

	public void setup(){
		//Initialization
		camera = new PeasyCam(this, width/2, height/2, 0, 400);
		terrain = new Terrain(this, camera,  width/2, height/2, 0, 100);
		terrain.init();
		cp5 = new ControlP5(this);
		cp5.setAutoDraw(false);
		
		//Settings display
		textMode(SHAPE);
	}

	public void draw(){
		lights();
		background(0);
		
		terrain.display();
		
		//GUI
		camera.beginHUD();
		cp5.draw();
		camera.endHUD();
		
		if (frameCount % 20 == 0) terrain.update();
	}
	
	public void drawAxes() {
		strokeWeight(10);
		stroke(255,0,0);
		fill(255,0,0);
		line(0,0,0,200,0,0);
		text("X+", 250,0,0);
		
		stroke(0,255,0);
		fill(0,255,0);
		line(0,0,0,0,200,0);
		text("Y+", 0,250,0);
		
		stroke(0,0,255);
		fill(0,0,255);
		line(0,0,0,0,0,200);
		text("Z+", 0,0,250);
	}
}
