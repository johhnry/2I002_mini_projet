package terrain;

import java.util.ArrayList;

import amenagement.Ville;
import element.Element;
import peasy.PeasyCam;
import processing.core.PApplet;
import ressource.*;

public class Terrain {
	private PApplet parent;
	private PeasyCam camera;
	private int posX, posY, posZ, rayon;
	private ArrayList<Element> listElements = new ArrayList<Element>();
	
	//Ressources
	private Eau eau = new Eau();
	private Mineral mineral = new Mineral();
	private Air air = new Air();
	private Nourriture nourriture = new Nourriture();
			
	public Terrain(PApplet parent, PeasyCam camera, int posX, int posY, int posZ, int rayon) {
		this.parent = parent;
		this.camera = camera;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.rayon = rayon;
	}
	
	public void display() {
		parent.noStroke();
		parent.pushMatrix();
		parent.translate(this.posX,this.posY, this.posZ);
		
		//Terre
		parent.fill(255);
		parent.sphere(this.rayon);
		
		for(Element e : this.listElements) {
			e.display();
		}
		
		//Atmosphère
		parent.shininess(5);
		parent.fill(242,242,208,(float)(1-air.getQualite())*50);
		parent.sphere((float) (rayon*1.5));
		parent.popMatrix();
		
		//Affichage infos
		camera.beginHUD();
		parent.textSize(15);
		parent.fill(255);
		parent.text(eau + "\n"+ mineral + "\n" + nourriture + "\n" + air + "\nNb elements : "+
		this.listElements.size(), 50,50); 
		camera.endHUD();
	}
	
	public void update() {
		for(int i=listElements.size()-1;i>=0;i--) {
			Element e = listElements.get(i);
			if (!e.update()) listElements.remove(e);
		}
	}
	
	public void init() {
		addElement(new Ville(parent, this));
	}
	
	public int getRayon() {
		return this.rayon;
	}
	
	public void addElement(Element e) {
		this.listElements.add(e);
	}
	
	public double getMoyenneRessources() {
		return (this.eau.qualite+this.air.qualite+this.mineral.qualite)/3;
	}
	
	public Eau getEau() {
		return eau;
	}

	public Mineral getMineral() {
		return mineral;
	}

	public Air getAir() {
		return air;
	}
	
	public Nourriture getNourriture() {
		return nourriture;
	}
}