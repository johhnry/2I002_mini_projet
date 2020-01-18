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

	//Resources
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

		//Setup earth shape and texture
		this.earthShape = parent.createShape(PConstants.SPHERE, this.rayon);
		earthShape.setStroke(false);
		this.earthShape.setTexture(parent.loadImage("texture/earthmap1k.jpg"));
	}

	public void display() {
		parent.pushMatrix();
		parent.translate(this.posX,this.posY, this.posZ);

		//Display 3d sphere
		parent.fill(255);
		parent.shape(this.earthShape);

		//Display every elements on it
		for(Element e : this.listElements) {
			e.display();
		}

		//Display the atmosphere depending on air quality
		parent.noStroke();
		parent.shininess(5);
		parent.fill(242,242,208,(float)(1-air.getQualite())*50);
		parent.sphere(rayon*2);
		parent.popMatrix();
	}

	public void update() {
		//Resources are regenerating a little bit
		eau.augmenterQt(50);
		air.augmenterQt(10);

		//For every elements
		for(int i=listElements.size()-1;i>=0;i--) {
			Element e = listElements.get(i);

			//Move it
			if (e instanceof Deplacable) {
				((Deplacable) e).move();
			}

			//Destroy if there's no human, otherwise update if it's not dead
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
		//Initialize resources
		eau.reset();
		air.reset();
		mineral.reset();
		nourriture.reset();

		//Clearing elements
		this.listElements.clear();

		//Add clouds
		for(int i=0;i<30;i++) {
			addElement(new Nuage(parent, this));
		}

		//Add some plants randomly
		for(int i=0;i<80;i++) {
			if(Math.random() < 0.3) {
				addElement(new Arbre(parent, this));
			}else {
				addElement(new Fleur(parent, this));
			}
		}
	}

	/* ------------------------------------------------------------
	 * GETTER AND SETTER
	 */

	//Getter for radius
	public int getRayon() {
		return this.rayon;
	}

	//Setter for radius
	public void setRayon(float r) {
		this.rayon = (int) r;
	}

	//Getter for x location
	public int getPosX() {
		return this.posX;
	}

	//Getter for y location
	public int getPosY() {
		return this.posY;
	}

	//Getter for water resource
	public Eau getEau() {
		return eau;
	}

	//Getter for mineral resource
	public Mineral getMineral() {
		return mineral;
	}

	//Getter for air resource
	public Air getAir() {
		return air;
	}

	//Getter for food resource
	public Nourriture getNourriture() {
		return nourriture;
	}
	
	//Getter for maximum element capacity
	public static int getElementCapacity() {
		return elementCapacity;
	}
	
	//Setter for maximum element capacity
	public static void setElementCapacity(int elementCapacity) {
		Terrain.elementCapacity = elementCapacity;
	}

	/*
	 * ------------------------------------------------------------
	 */

	//Add an element on the planet
	public void addElement(Element e) {
		this.listElements.add(e);
	}

	//Get the average quality of all resources
	public double getMoyenneRessources() {
		return (this.eau.qualite + this.air.qualite + this.mineral.qualite) / 3;
	}
	
	//Gather the number of each individual classes on the planet in a Hash
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
	
	//Return true if the number of elements is above the maximum capacity
	//and remove them
	public boolean isListElementFull() {
		if (listElements.size() > Terrain.elementCapacity) {
			while(listElements.size() >= Terrain.elementCapacity) {
				this.listElements.remove(listElements.size()-1);
			}	
			return true;
		}
		return false;
	}
	
	//Return the number of elements on the planet
	public int getCountElement() {
		return this.listElements.size();
	}
}