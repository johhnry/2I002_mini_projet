package terrain;

import java.util.ArrayList;
import java.util.HashMap;
import amenagement.Amenagement;
import amenagement.Ville;
import amenagement.domestique.Domestique;
import amenagement.industriel.Industriel;
import element.Element;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;
import ressource.*;
import vivant.Vivant;
import vivant.animal.Deplacable;
import vivant.animal.mammifere.Homme;
import vivant.animal.mammifere.Mammifere;
import vivant.animal.oiseau.Oiseau;
import vivant.animal.reptile.Reptile;
import vivant.vegetal.Arbre;
import vivant.vegetal.Fleur;
import vivant.vegetal.Vegetal;

public class Terrain {
	private PApplet parent;
	private int posX, posY, posZ, rayon;
	private PShape earthShape;
	private ArrayList<Element> listElements = new ArrayList<Element>();
	private static int elementCapacity = 500;
	
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
		this.earthShape = parent.createShape(PConstants.SPHERE, this.rayon);
		earthShape.setStroke(false);
		this.earthShape.setTexture(parent.loadImage("texture/earthmap1k.jpg"));
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
			if (e instanceof Deplacable) {
				((Deplacable) e).move();
			}
			if (!(e instanceof Amenagement && Homme.getCptHumain()<=0)) {
				if (!e.update()) {
					if (e instanceof Vivant) nourriture.augmenterQt(5);
					listElements.remove(e);
				}
			}else {
				((Amenagement) e).destroy(); 
			}
		}
	}
	
	public void init() {
		eau.reset();
		air.reset();
		mineral.reset();
		nourriture.reset();
		
		this.listElements.clear();
		
		//Ajout des nuages
		for(int i=0;i<30;i++) {
			addElement(new Nuage(parent, this));
		}
		
		//Ajout des végétaux
		for(int i=0;i<80;i++) {
			if(Math.random() < 0.3) {
				addElement(new Arbre(parent, this));
			}else {
				addElement(new Fleur(parent, this));
			}
		}
	}
	
	public int getRayon() {
		return this.rayon;
	}
	
	public void setRayon(float r) {
		this.rayon = (int) r;
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
	
	public boolean isListElementFull() {
		if (listElements.size() > Terrain.elementCapacity) {
			//Tant qu'il y a plus d'éléments
			while(listElements.size() >= Terrain.elementCapacity) {
				this.listElements.remove(listElements.size()-1);
			}	
			return true;
		}
		return false;
	}
	
	public int getCountElement() {
		return this.listElements.size();
	}

	public static int getElementCapacity() {
		return elementCapacity;
	}

	public static void setElementCapacity(int elementCapacity) {
		Terrain.elementCapacity = elementCapacity;
	}
}