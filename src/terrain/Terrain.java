package terrain;

import java.util.ArrayList;
import java.util.HashMap;
import amenagement.Ville;
import amenagement.domestique.Domestique;
import amenagement.industriel.Industriel;
import element.Element;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PShape;
import ressource.*;
import vivant.animal.Animal;
import vivant.animal.mammifere.Homme;
import vivant.animal.mammifere.Mammifere;
import vivant.animal.oiseau.Oiseau;
import vivant.animal.reptile.Crocodile;
import vivant.animal.reptile.Reptile;
import vivant.vegetal.Fleur;
import vivant.vegetal.Vegetal;

public class Terrain {
	private PApplet parent;
	private int posX, posY, posZ, rayon;
	private PImage earthTexture;
	private PShape earthShape;
	private ArrayList<Element> listElements = new ArrayList<Element>();
	
	//Ressources
	private Eau eau = new Eau();
	private Mineral mineral = new Mineral();
	private Air air = new Air();
	private Nourriture nourriture = new Nourriture();
			
	public Terrain(PApplet parent, int posX, int posY, int posZ, int rayon) {
		this.parent = parent;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.rayon = rayon;
		this.earthTexture = parent.loadImage("texture/earthmap1k.jpg");
		this.earthShape = parent.createShape(PConstants.SPHERE, this.rayon);
		earthShape.setStroke(false);
		this.earthShape.setTexture(this.earthTexture);
	}
	
	public void display() {
		parent.pushMatrix();
		parent.translate(this.posX,this.posY, this.posZ);
		
		//Terre
		parent.fill(255);
		parent.shape(this.earthShape);
		
		for(Element e : this.listElements) {
			e.display();
		}
		
		//Atmosphère
		parent.noStroke();
		parent.shininess(5);
		parent.fill(242,242,208,(float)(1-air.getQualite())*50);
		parent.sphere(rayon*2);
		parent.popMatrix();
	}
	
	public void update() {
		//Regénération des ressources
		eau.augmenterQt(50);
		air.augmenterQt(10);
		
		for(int i=listElements.size()-1;i>=0;i--) {
			Element e = listElements.get(i);
			if (e instanceof Animal) {
				((Animal) e).move();
			}
			if (!e.update()) listElements.remove(e);
		}
	}
	
	public void init() {
		for(int i=0;i<100;i++) {
			addElement(new Homme(parent, this));
			addElement(new Crocodile(parent, this));
			addElement(new Fleur(parent, this));
		}
		addElement(new Ville(parent, this));
	}
	
	public int getRayon() {
		return this.rayon;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
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
	
	public HashMap<String, Integer> getHashQuantities(){
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		int cMamm=0, cOis=0, cVille=0, cDom=0, cIndus=0, cRept=0, cVege=0;
		for(Element e : this.listElements) {
			if (e instanceof Mammifere) {
				cMamm++;
			}else if (e instanceof Oiseau) {
				cOis++;
			}else if (e instanceof Ville) {
				cVille++;
			}else if (e instanceof Domestique) {
				cDom++;
			}else if (e instanceof Industriel) {
				cIndus++;
			}else if (e instanceof Reptile) {
				cRept++;
			}else if (e instanceof Vegetal) {
				cVege++;
			}
		}
		hash.put("mammifere", cMamm);
		hash.put("oiseau", cOis);
		hash.put("ville", cVille);
		hash.put("domestique", cDom);
		hash.put("industriel", cIndus);
		hash.put("reptile", cRept);
		hash.put("vegetal", cVege);
		return hash;
	}
}