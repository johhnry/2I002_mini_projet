package main;

import processing.core.PApplet;
import processing.core.PShape;
import terrain.Soleil;
import terrain.Terrain;
import vivant.animal.mammifere.Elephant;
import vivant.animal.mammifere.Homme;
import vivant.animal.oiseau.Aigle;
import vivant.animal.oiseau.Colibri;
import vivant.animal.reptile.Crocodile;
import vivant.animal.reptile.Serpent;
import vivant.vegetal.Arbre;
import vivant.vegetal.Fleur;
import peasy.PeasyCam;
import gui.Options;
import java.util.HashMap;
import amenagement.industriel.CentraleNucleaire;
import amenagement.industriel.Incinerateur;
import amenagement.industriel.Raffinerie;
import controlP5.*;

/*
 * Base class for calling the Processing API
 * and handling frame by frame simulation
 */
public class Simulation extends PApplet{
	private PeasyCam camera;
	private Terrain terrain;
	private ControlP5 cp5;		
	private Options options;
	private Soleil soleil;

	//Hash storing OBJ models as PShape
	HashMap<String, PShape> models = new HashMap<String, PShape>();;

	//Simulation speed handled by a slider
	private int sSpeed = 1;
	
	//Main function calling PApplet on this class
	public static void main(String[] args) {
		PApplet.main("main.Simulation");
	}
	
	//Use P3D(OpenGL) as render engine
	public void settings(){
		fullScreen(P3D);
	}
	
	/*
	 * The setup function initialize scene variables and load resources
	 */
	public void setup(){
		//Instance scene variables
		camera = new PeasyCam(this, width/2, height/2, 0, 600);
		terrain = new Terrain(this,  width/2, height/2, 0, 180);
		soleil = new Soleil(this, terrain, HALF_PI, 100);
		cp5 = new ControlP5(this);
		cp5.setAutoDraw(false);
		cp5.setFont(createFont("font/uni0553-webfont.ttf", 14));
		options = new Options(this, terrain, cp5, 70);

		//Loading OBJ models
		try {
			loadModels(models);
		}catch(NumberFormatException e) {
			System.out.println("Error while loading .obj files.");
		}
		
		//Initialize terrain and UI
		terrain.init();
		options.init();
	}
	
	/*
	 * The draw function is being executed ~30 times /s
	 * This is where we call the display functions for every elements
	 */
	public void draw(){
		//Use lights and black background
		lights();
		background(0);

		//Display sun and planet
		soleil.display();
		terrain.display();

		//We disable the HUD in order to draw the UI
		camera.beginHUD();
		
		cp5.draw();
		
		//Going red if there's too much objects
		if (terrain.isListElementFull()) {
			fill(255,0,0);
		}else {
			fill(255);
		}
		
		//Displaying the number of objects in the scene
		text("Nombre d'éléments : "+terrain.getCountElement(), width-200,20);
		camera.endHUD();

		//Update sun, planet and UI according to the simulation speed
		for(int i=0;i<sSpeed;i++) {
			options.update();
			terrain.update();
			soleil.update();
		}
	}
	
	/* -------------------------------------------------------------------------
	 * UI FUNCTIONS
	 * They are called whenever a parameter in the UI is changed
	 */
	
	//Setter for simulation speed
	public void sSpeed(float s) {
		this.sSpeed = (int) s;
	}
	
	//Setter for sunColor
	public void sunColor(int c) {
		this.soleil.setRGB(red(c),green(c),blue(c));
	}
	
	//Reset function
	public void reset() {
		this.terrain.init();
		camera.reset();
		soleil.reset();
	}
	
	//Add a human
	public void addHomme() {
		for(int i=0;i<10;i++) {
			terrain.addElement(new Homme(this, terrain));
		}
	}
	
	//Add a nuclear plant
	public void addCentrale() {
		terrain.addElement(new CentraleNucleaire(this, terrain));
	}
	
	//Add an incinerator
	public void addIncinerateur() {
		terrain.addElement(new Incinerateur(this, terrain));
	}
	
	//Add an oil refinery
	public void addRaffinerie() {
		terrain.addElement(new Raffinerie(this, terrain));
	}
	
	//Add randomly 10 random plants
	public void addVegetal() {
		for(int i=0;i<10;i++) {
			if (Math.random()< 0.2) {
				terrain.addElement(new Arbre(this, terrain));
			}else{
				terrain.addElement(new Fleur(this, terrain));
			}
		}
	}
	
	//Add randomly 10 animals
	public void addAnimal() {
		for(int i=0;i<10;i++) {
			int n = (int)random(5);
			switch (n) {
			case 0:
				terrain.addElement(new Elephant(this, terrain));
				break;
			case 1:
				terrain.addElement(new Aigle(this, terrain));
				break;
			case 2:
				terrain.addElement(new Colibri(this, terrain));
				break;
			case 3:
				terrain.addElement(new Crocodile(this, terrain));
			case 4:
				terrain.addElement(new Serpent(this, terrain));
			default:
				break;
			}
		}
	}
	
	/*
	 * --------------------------------------------------------------------------
	 */
	
	//Add a model in the hash
	public void addModel(HashMap<String, PShape> hash, String filename) {
		hash.put(filename+".obj", loadShape("models/"+filename+".obj"));
		System.out.println("Loading "+filename+".obj ...");
	}
	
	//Load OBJ models
	public void loadModels(HashMap<String, PShape> hash) {
		addModel(hash, "maison");
		addModel(hash, "maison_destroy");
		addModel(hash, "immeuble");
		addModel(hash, "immeuble_destroy");
		addModel(hash, "crocodile");
		addModel(hash, "colibri");
		addModel(hash, "serpent");
		addModel(hash, "aigle");
		addModel(hash, "elephant");
		addModel(hash, "homme");
		addModel(hash, "arbre");
		addModel(hash, "fleur");
		addModel(hash, "cimetiere");
		addModel(hash, "incinerateur");
		addModel(hash, "incinerateur_destroy");
		addModel(hash, "centrale");
		addModel(hash, "centrale_destroy");
		addModel(hash, "raffinerie");
		addModel(hash, "raffinerie_destroy");
		addModel(hash, "nuage0");
		addModel(hash, "nuage1");
		addModel(hash, "nuage2");
	}
	
	//Return OBJ as PShape associated with the name
	public PShape getModel(String name) {
		return this.models.get(name);
	}

	//DEBUG function : draw x,y,z axes
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
