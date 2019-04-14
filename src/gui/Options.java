package gui;

import java.util.HashMap;
import java.util.Map.Entry;
import controlP5.*;
import processing.core.PApplet;
import ressource.Air;
import ressource.Eau;
import ressource.Mineral;
import terrain.Terrain;
import vivant.animal.mammifere.Elephant;
import vivant.animal.mammifere.Homme;
import vivant.animal.oiseau.Aigle;
import vivant.animal.oiseau.Colibri;
import vivant.animal.reptile.Crocodile;
import vivant.animal.reptile.Serpent;
import vivant.vegetal.Arbre;
import vivant.vegetal.Fleur;

public class Options {
	private PApplet parent;
	private Terrain terrain;
	private ControlP5 cp5;
	private int cursorY;

	//Charts ressources
	private Chart chartEau, chartAir, chartMineral, chartNourriture, chartRecensement;

	public Options(PApplet parent, Terrain terrain, ControlP5 cp5, int cursorY) {
		this.parent = parent;
		this.terrain = terrain;
		this.cp5 = cp5;
		this.cursorY = cursorY;
	}

	public void init() {
		//-----------------------GROUP------------------------------------
		int widthGr = 300;
		int colorBckgGr = parent.color(200,100);
		Group data = cp5.addGroup("ressources")
				.setPosition(20,cursorY)
				.setBackgroundColor(colorBckgGr)
				.setWidth(widthGr)
				.setBackgroundHeight(700)
				.setBarHeight(30);

		int gapC = 35;
		int marginC = 10;
		int widthC = widthGr-2*marginC;
		int heightC = widthC/4;
		int listDataSize = 20;
		int strokeWeightC = 2;
		int colorBckgC = parent.color(60);

		//EAU----------------------------------------------------------------------
		chartEau = cp5.addChart("eau")
				.setPosition(marginC,gapC)
				.setSize(widthC , heightC)
				.setRange(0, Eau.getqtInitEau())
				.setView(Chart.LINE)
				.setGroup(data)
				.addDataSet("qualite")
				.setColors("qualite", parent.color(255))
				.setData("qualite", new float[listDataSize])
				.addDataSet("quantite")
				.setColors("quantite", parent.color(0,0,255))
				.setData("quantite", new float[listDataSize]);

		chartEau.getColor().setBackground(colorBckgC);
		chartEau.setStrokeWeight(strokeWeightC);

		//AIR----------------------------------------------------------------------
		chartAir = cp5.addChart("air")
				.setPosition(marginC,heightC+gapC*2)
				.setSize(widthC , heightC)
				.setRange(0, Air.getqtInitAir())
				.setView(Chart.LINE)
				.setGroup(data)
				.addDataSet("qualite")
				.setColors("qualite", parent.color(255))
				.setData("qualite", new float[listDataSize])
				.addDataSet("quantite")
				.setColors("quantite", parent.color(0,217, 250))
				.setData("quantite", new float[listDataSize]);

		chartAir.getColor().setBackground(colorBckgC);
		chartAir.setStrokeWeight(strokeWeightC);

		//MINERAL----------------------------------------------------------------------
		chartMineral = cp5.addChart("minerals")
				.setPosition(marginC,heightC*2+gapC*3)
				.setSize(widthC , heightC)
				.setRange(0, Mineral.getqtInitMineral())
				.setView(Chart.LINE)
				.setGroup(data)
				.addDataSet("qualite")
				.setColors("qualite", parent.color(255))
				.setData("qualite", new float[listDataSize])
				.addDataSet("quantite")
				.setColors("quantite", parent.color(250,125,0))
				.setData("quantite", new float[listDataSize]);

		chartMineral.getColor().setBackground(colorBckgC);
		chartMineral.setStrokeWeight(strokeWeightC);

		//NOURRITURE----------------------------------------------------------------------
		chartNourriture = cp5.addChart("nourriture")
				.setPosition(marginC,heightC*3+gapC*4)
				.setSize(widthC , heightC)
				.setRange(0, 10000)
				.setView(Chart.LINE)
				.setGroup(data)
				.addDataSet("qualite")
				.setColors("qualite", parent.color(255))
				.setData("qualite", new float[listDataSize])
				.addDataSet("quantite")
				.setColors("quantite", parent.color(38,209,38))
				.setData("quantite", new float[listDataSize]);

		chartNourriture.getColor().setBackground(colorBckgC);
		chartNourriture.setStrokeWeight(strokeWeightC);

		//RECENSEMENT----------------------------------------------------------------------
		int alphaArea = 100;
		chartRecensement = cp5.addChart("quantities")
				.setPosition(marginC, heightC*4+gapC*5)
				.setSize(widthC, 200)
				.setRange(0, 200)
				.setView(Chart.AREA)
				.setGroup(data)
				.addDataSet("mammifere")
				.setData("mammifere", new float[listDataSize])
				.setColors("mammifere", parent.color(226, 84, 23, alphaArea))
				.addDataSet("oiseau")
				.setData("oiseau", new float[listDataSize])
				.setColors("oiseau", parent.color(226, 84, 23, alphaArea))
				.addDataSet("ville")
				.setData("ville", new float[listDataSize])
				.setColors("ville", parent.color(200, alphaArea))
				.addDataSet("domestique")
				.setData("domestique", new float[listDataSize])
				.setColors("domestique", parent.color(255,0,0, alphaArea))
				.addDataSet("industriel")
				.setData("industriel", new float[listDataSize])
				.setColors("industriel", parent.color(101,176,126, alphaArea))
				.addDataSet("reptile")
				.setData("reptile", new float[listDataSize])
				.setColors("reptile", parent.color(219,65,230, alphaArea))
				.addDataSet("vegetal")
				.setData("vegetal", new float[listDataSize])
				.setColors("vegetal", parent.color(55,128,29, alphaArea));

		chartRecensement.getColor().setBackground(colorBckgC);

		
		//-----------------------SLIDERS------------------------------------------------------
		int widthGrSlider = 400;
		int gapSGr = 20;
		int marginSGr = 10;
		int widthSgr = widthGrSlider-marginSGr*2;
		int gapSlider = 20;
		int marginSlider = 10;
		int heightSlider = 25;

		Group environment = cp5.addGroup("environment")
				.setPosition(marginSGr,gapSGr)
				.setBackgroundColor(colorBckgGr)
				.setWidth(widthSgr)
				.setBackgroundHeight(430)
				.setBarHeight(30);

		cp5.addSlider("sSpeed")
		.setPosition(marginSlider, gapSlider)
		.setSize(widthSgr - 10*marginSlider, heightSlider)
		.setRange(1,20)
		.setValue(1)
		.setDecimalPrecision(0)
		.setNumberOfTickMarks(10)
		.setGroup(environment)
		;

		cp5.addColorWheel("sunColor")
		.setPosition(marginSlider, gapSlider*2+heightSlider+10)
		.setGroup(environment);
		
		cp5.addSlider("capacity")
		.setPosition(marginSlider, gapSlider*3 + heightSlider+230)
		.setSize(widthSgr - 10*marginSlider, 25)
		.setRange(0,3000)
		.setDecimalPrecision(0)
		.addListener(new ControlListener() {
			public void controlEvent(ControlEvent e) {
				Terrain.setElementCapacity((int) e.getController().getValue());
			}
		})
		.setGroup(environment)
		.setValue(Terrain.getElementCapacity());
		
		cp5.addButton("reset")
		.setPosition(marginSlider, gapSlider*4+heightSlider*2+230)
		.setSize(widthSgr - 2*marginSlider, 50)
		.setGroup(environment);
		
		Group ajouter = cp5.addGroup("ajouter")
				.setPosition(marginSGr,gapSGr)
				.setBackgroundColor(colorBckgGr)
				.setWidth(widthSgr)
				.setBackgroundHeight(150)
				.setBarHeight(30);
		
		int buttonHalfSize = (widthSgr - 2*marginSlider)/2;
		int heightButton = 30;
		cp5.addButton("addHomme")
		.setPosition(marginSlider, gapSlider)
		.setSize(buttonHalfSize, heightButton)
		.setGroup(ajouter);
		
		cp5.addButton("addCentrale")
		.setPosition(marginSlider*2+buttonHalfSize, gapSlider)
		.setSize(buttonHalfSize, heightButton)
		.setGroup(ajouter);
		
		cp5.addButton("addRaffinerie")
		.setPosition(marginSlider, gapSlider+heightButton+marginSlider)
		.setSize(buttonHalfSize, heightButton)
		.setGroup(ajouter);
		
		cp5.addButton("addIncinerateur")
		.setPosition(marginSlider*2+buttonHalfSize, gapSlider+heightButton+marginSlider)
		.setSize(buttonHalfSize, heightButton)
		.setGroup(ajouter);
		
		cp5.addButton("addVegetal")
		.setPosition(marginSlider, gapSlider+heightButton*2+marginSlider*2)
		.setSize(buttonHalfSize, heightButton)
		.setGroup(ajouter);
		
		cp5.addButton("addAnimal")
		.setPosition(marginSlider*2+buttonHalfSize, gapSlider+heightButton*2+marginSlider*2)
		.setSize(buttonHalfSize, heightButton)
		.setGroup(ajouter);
		
		//-------------------------------------------------------------------------------------
		
		float maxRange = 0.05f;
		ControlListener sliderListener = new ControlListener() {
			public void controlEvent(ControlEvent e) {
				float v = e.getController().getValue();
				switch (e.getController().getName()) {
				case "pHomme":
					Homme.setpReprodHomme(v);
					break;
				case "pElephant":
					Elephant.setpReprodElephant(v);
					break;
				case "pColibri":
					Colibri.setpReprodColibri(v);
					break;
				case "pAigle":
					Aigle.setpReprodAigle(v);
					break;
				case "pCrocodile":
					Crocodile.setpReprodCrocodile(v);
					break;
				case "pSerpent":
					Serpent.setpReprodSerpent(v);
					break;
				case "pArbre":
					Arbre.setpReprodArbre(v);
					break;
				case "pFleur":
					Fleur.setpReprodFleur(v);
					break;
				case "vHomme":
					Homme.setOldHomme((int)v);;
					break;
				case "vElephant":
					Elephant.setOldElephant((int)v);;
					break;
				case "vColibri":
					Colibri.setOldColibri((int)v);;
					break;
				case "vAigle":
					Aigle.setOldAigle((int)v);;
					break;
				case "vCrocodile":
					Crocodile.setOldCrocodile((int)v);;
					break;
				case "vSerpent":
					Serpent.setOldSerpent((int)v);;
					break;
				case "vArbre":
					Arbre.setOldArbre((int)v);;
					break;
				case "vFleur":
					Fleur.setOldFleur((int)v);
					break;
				default:
					break;
				}
			}
		};
		
		//REPRODUCTION ----------------------------------------------------------
		
		Group reproduction = cp5.addGroup("reproduction")
				.setPosition(marginSGr,gapSGr)
				.setBackgroundColor(colorBckgGr)
				.setWidth(widthSgr)
				.setBackgroundHeight(310)
				.setBarHeight(30);
		
		cp5.addSlider("pHomme")
		.setPosition(marginSlider, gapSlider)
		.setSize(widthSgr - 10*marginSlider, heightSlider)
		.setRange(0,maxRange)
		.setDecimalPrecision(3)
		.addListener(sliderListener)
		.setGroup(reproduction)
		.setValue((float)Homme.getpReprodHomme());
		
		cp5.addSlider("pElephant")
		.setPosition(marginSlider, gapSlider+heightSlider+marginSlider)
		.setSize(widthSgr - 10*marginSlider, heightSlider)
		.setRange(0,maxRange)
		.setDecimalPrecision(3)
		.addListener(sliderListener)
		.setGroup(reproduction)
		.setValue((float)Elephant.getpReprodElephant());
		
		cp5.addSlider("pColibri")
		.setPosition(marginSlider, gapSlider+(heightSlider+marginSlider)*2)
		.setSize(widthSgr - 10*marginSlider, heightSlider)
		.setRange(0,maxRange)
		.setDecimalPrecision(3)
		.addListener(sliderListener)
		.setGroup(reproduction)
		.setValue((float)Colibri.getpReprodColibri());
		
		cp5.addSlider("pAigle")
		.setPosition(marginSlider, gapSlider+(heightSlider+marginSlider)*3)
		.setSize(widthSgr - 10*marginSlider, heightSlider)
		.setRange(0,maxRange)
		.setDecimalPrecision(3)
		.addListener(sliderListener)
		.setGroup(reproduction)
		.setValue((float)Aigle.getpReprodAigle());
		
		cp5.addSlider("pCrocodile")
		.setPosition(marginSlider, gapSlider+(heightSlider+marginSlider)*4)
		.setSize(widthSgr - 10*marginSlider, heightSlider)
		.setRange(0,maxRange)
		.setDecimalPrecision(3)
		.addListener(sliderListener)
		.setGroup(reproduction)
		.setValue((float)Crocodile.getpReprodCrocodile());
		
		cp5.addSlider("pSerpent")
		.setPosition(marginSlider, gapSlider+(heightSlider+marginSlider)*5)
		.setSize(widthSgr - 10*marginSlider, heightSlider)
		.setRange(0,maxRange)
		.setDecimalPrecision(3)
		.addListener(sliderListener)
		.setGroup(reproduction)
		.setValue((float)Serpent.getpReprodSerpent());
		
		cp5.addSlider("pArbre")
		.setPosition(marginSlider, gapSlider+(heightSlider+marginSlider)*6)
		.setSize(widthSgr - 10*marginSlider, heightSlider)
		.setRange(0,maxRange)
		.setDecimalPrecision(3)
		.addListener(sliderListener)
		.setGroup(reproduction)
		.setValue((float)Arbre.getpReprodArbre());
		
		cp5.addSlider("pFleur")
		.setPosition(marginSlider, gapSlider+(heightSlider+marginSlider)*7)
		.setSize(widthSgr - 10*marginSlider, heightSlider)
		.setRange(0,maxRange)
		.setDecimalPrecision(3)
		.addListener(sliderListener)
		.setGroup(reproduction)
		.setValue((float)Fleur.getpReprodFleur());
		
		//VIE------------------------------------------------------------------------
		maxRange = 1000;
		Group vie = cp5.addGroup("vie")
				.setPosition(marginSGr,gapSGr)
				.setBackgroundColor(colorBckgGr)
				.setWidth(widthSgr)
				.setBackgroundHeight(310)
				.setBarHeight(30);
		
		cp5.addSlider("vHomme")
		.setPosition(marginSlider, gapSlider)
		.setSize(widthSgr - 10*marginSlider, heightSlider)
		.setRange(1,maxRange)
		.setDecimalPrecision(0)
		.addListener(sliderListener)
		.setGroup(vie)
		.setValue((float)Homme.getOldHomme());
		
		cp5.addSlider("vElephant")
		.setPosition(marginSlider, gapSlider+heightSlider+marginSlider)
		.setSize(widthSgr - 10*marginSlider, heightSlider)
		.setRange(1,maxRange)
		.setDecimalPrecision(0)
		.addListener(sliderListener)
		.setGroup(vie)
		.setValue((float)Elephant.getOldElephant());
		
		cp5.addSlider("vColibri")
		.setPosition(marginSlider, gapSlider+(heightSlider+marginSlider)*2)
		.setSize(widthSgr - 10*marginSlider, heightSlider)
		.setRange(1,maxRange)
		.setDecimalPrecision(0)
		.addListener(sliderListener)
		.setGroup(vie)
		.setValue((float)Colibri.getOldColibri());
		
		cp5.addSlider("vAigle")
		.setPosition(marginSlider, gapSlider+(heightSlider+marginSlider)*3)
		.setSize(widthSgr - 10*marginSlider, heightSlider)
		.setRange(1,maxRange)
		.setDecimalPrecision(0)
		.addListener(sliderListener)
		.setGroup(vie)
		.setValue((float)Aigle.getOldAigle());
		
		cp5.addSlider("vCrocodile")
		.setPosition(marginSlider, gapSlider+(heightSlider+marginSlider)*4)
		.setSize(widthSgr - 10*marginSlider, heightSlider)
		.setRange(1,maxRange)
		.setDecimalPrecision(0)
		.addListener(sliderListener)
		.setGroup(vie)
		.setValue((float)Crocodile.getOldCrocodile());
		
		cp5.addSlider("vSerpent")
		.setPosition(marginSlider, gapSlider+(heightSlider+marginSlider)*5)
		.setSize(widthSgr - 10*marginSlider, heightSlider)
		.setRange(1,maxRange)
		.setDecimalPrecision(0)
		.addListener(sliderListener)
		.setGroup(vie)
		.setValue((float)Serpent.getOldSerpent());
		
		cp5.addSlider("vArbre")
		.setPosition(marginSlider, gapSlider+(heightSlider+marginSlider)*6)
		.setSize(widthSgr - 10*marginSlider, heightSlider)
		.setRange(1,maxRange)
		.setDecimalPrecision(0)
		.addListener(sliderListener)
		.setGroup(vie)
		.setValue((float)Arbre.getOldArbre());
		
		cp5.addSlider("vFleur")
		.setPosition(marginSlider, gapSlider+(heightSlider+marginSlider)*7)
		.setSize(widthSgr - 10*marginSlider, heightSlider)
		.setRange(1,maxRange)
		.setDecimalPrecision(0)
		.addListener(sliderListener)
		.setGroup(vie)
		.setValue((float)Fleur.getOldFleur());
		
		//ACCORDION--------------------------------------------------------------------

		cp5.addAccordion("Options")
		.setPosition(parent.width-widthGrSlider-20,cursorY)
		.setWidth(widthGrSlider)
		.setBackgroundColor(colorBckgGr)
		.addItem(environment)
		.addItem(ajouter)
		.addItem(reproduction)
		.addItem(vie)
		.setCollapseMode(Accordion.MULTIPLES);
	}

	public void update() {

		if (parent.frameCount%20==0) {
			//Chart recensement
			HashMap<String, Integer> hash = terrain.getHashQuantities();
			for(Entry<String, Integer> entry : hash.entrySet()) {
				chartRecensement.push(entry.getKey(), entry.getValue());
			}

			//Charts ressources
			chartEau.push("quantite", (float)terrain.getEau().getQuantite());
			chartEau.push("qualite", (float) terrain.getEau().getQualite() * Eau.getqtInitEau());

			chartAir.push("quantite", (float)terrain.getAir().getQuantite());
			chartAir.push("qualite", (float) terrain.getAir().getQualite() * Air.getqtInitAir());

			chartMineral.push("quantite", (float)terrain.getMineral().getQuantite());
			chartMineral.push("qualite", (float) terrain.getMineral().getQualite() * 
					Mineral.getqtInitMineral());

			chartNourriture.push("quantite", (float)terrain.getNourriture().getQuantite());
			chartNourriture.push("qualite", (float) terrain.getNourriture().getQualite() * 
					10000);
		}
	}
}
