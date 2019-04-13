package amenagement;

import java.util.ArrayList;
import amenagement.domestique.*;
import processing.core.PApplet;
import terrain.Terrain;
import vivant.animal.mammifere.Homme;

public class Ville extends Amenagement {
	private ArrayList<Domestique> listDomestiques = new ArrayList<Domestique>();
	private int capacite  = (int)((Math.random()*6)+5);
	private double orbite = 0.001;
	private double incr = 1;
	private static int cptVille = 0;
	private final int id;
	
	public Ville(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, "", "", theta, phi);
		this.addDomestique();
		this.id = ++cptVille;
	}
	
	public Ville(PApplet parent, Terrain terrain) {
		super(parent, terrain, "", "");
		this.addDomestique();
		this.id = ++cptVille;
	}
	
	public void display() {
		for (Domestique d : listDomestiques) {
			d.display();
		}
	}
	
	public void addDomestique() {
		double newTheta = theta + (Math.random()*2-1)/10 *orbite;
		double newPhi = phi + (Math.random()*2-1)/10 *orbite;
		if (Math.random()< 0.5) {
			this.listDomestiques.add(new Immeuble(parent, terrain, newTheta, newPhi));
			orbite += incr;
			incr /= 2.5;
		}else {
			this.listDomestiques.add(
					new Maison(parent, terrain, newTheta, newPhi));
		}
	}

	public void utiliser() {
	}

	public void rejeter() {	
	}
	
	public boolean update() {
		if (Homme.getCptHumain() >= 0 && Math.random()< 0.05 && !destroy) {
			//On construit
			if (this.listDomestiques.size() < this.capacite) {
				//On ajoute dans la ville
				this.addDomestique();
			}else if(this.id == cptVille){
				//On créé une nouvelle ville
				terrain.addElement(new Ville(parent, terrain));
			}
		}
		
		//Update des maisons et des immeubles
		for(Domestique d : listDomestiques) {
			d.update();
		}
		return true;
	}
	
	public void destroy() {
		if (!destroy) {
			for(Domestique a : this.listDomestiques) {
				a.destroy();
			}
		}
		super.destroy();
	}
}