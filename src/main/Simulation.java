package main;

import processing.core.PApplet;
import terrain.Terrain;
import peasy.PeasyCam;
import gui.Options;

import controlP5.*;

public class Simulation extends PApplet{
	private PeasyCam camera;
	private Terrain terrain;
	private ControlP5 cp5;
	private Options options;
	
	public static void main(String[] args) {
		PApplet.main("main.Simulation");
	}

	public void settings(){
		//size(800,800,P3D);
		
		fullScreen(P3D);
	}

	public void setup(){
		//Initialization
		camera = new PeasyCam(this, width/2, height/2, 0, 400);
		terrain = new Terrain(this,  width/2, height/2, 0, 100);
		cp5 = new ControlP5(this);
		cp5.setAutoDraw(false);
		cp5.setFont(createFont("font/uni0553-webfont.ttf", 12));
		options = new Options(this, terrain, cp5, 100);
		
		//Init
		terrain.init();
		options.init();
		
		//Settings display
		textMode(SHAPE);
	}

	public void draw(){
		//Display setup and lights
		lights();
		background(0);
		
		//Afficher le terrain
		terrain.display();
		
		//GUI
		camera.beginHUD();
		options.update();
		cp5.draw();
		camera.endHUD();
		
		//Update du terrain
		terrain.update();
	}
	
	//Debug function
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
