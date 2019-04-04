package main;

import processing.core.PApplet;
import processing.core.PShape;
import processing.opengl.*;
import vivant.Vivant;
import vivant.animal.Animal;
import vivant.animal.mammifere.Homme;

import java.util.ArrayList;

import element.Element;
import peasy.PeasyCam;

public class TestProcessing extends PApplet{
	PeasyCam camera;
	PShape modelHomme;
	ArrayList<Animal> listHommes;
	public static final int RAYON = 100;
	
	public static void main(String[] args) {
		PApplet.main("main.TestProcessing");
	}

	public void settings(){
		//fullScreen(P3D);
		size(800,800,P3D);
	}

	public void setup(){
		textMode(SHAPE);
		
		modelHomme = loadShape("models/homme_test.obj");
		camera = new PeasyCam(this, width/2, height/2, 0, 400);
		listHommes = new ArrayList<Animal>();
		
		for(int i=0;i<200;i++) {
			listHommes.add(new Homme(this,modelHomme, RAYON, random(-TWO_PI,TWO_PI), random(-TWO_PI,TWO_PI)));
		}
	}

	public void draw(){
		strokeWeight(1);
		stroke(255,90);
		noFill();
		lights();
		background(0);
		//fill(255);
		translate(width/2,height/2,0);
		sphere(RAYON);
		
		for(Animal a : listHommes) {
			a.display();
		}
		
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
