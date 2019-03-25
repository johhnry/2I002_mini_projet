package main;

import processing.core.PApplet;
import processing.opengl.*;
import vivant.Vivant;
import animal.Animal;
import element.Element;
import mammifere.Homme;
import peasy.PeasyCam;

public class TestProcessing extends PApplet{
	PeasyCam camera;
	Animal e;
	
	public static void main(String[] args) {
		PApplet.main("main.TestProcessing");
	}

	public void settings(){
		size(500,500,P3D);
	}

	public void setup(){
		noStroke();
		camera = new PeasyCam(this, width/2, height/2, 0, 400);
		e = new Homme(this, 100, 0, 0);
	}

	public void draw(){
		lights();
		background(0);
		fill(255);
		translate(width/2,height/2,0);
		sphere(100);
		
		e.display();
		e.move(random(0.05f),random(0.05f));
	}
}
