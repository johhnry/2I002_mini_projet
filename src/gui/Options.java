package gui;

import java.util.HashMap;
import java.util.Map.Entry;
import controlP5.*;
import processing.core.PApplet;
import ressource.Air;
import ressource.Eau;
import ressource.Mineral;
import terrain.Terrain;

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
				.setBarHeight(20);

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
		/*Group sliders = cp5.addGroup("sliders")
				.setPosition(parent.width-widthGrSlider-20,cursorY)
				.setBackgroundColor(colorBckgGr)
				.setWidth(widthGrSlider)
				.setBackgroundHeight(700)
				.setBarHeight(20);*/

		int gapSGr = 20;
		int marginSGr = 10;
		int widthSgr = widthGrSlider-marginSGr*2;
		int gapSlider = 20;
		int marginSlider = 10;
		int heightSlider = 25;

		Group environment = cp5.addGroup("environment")
				.setPosition(marginSGr,gapSGr+20)
				.setBackgroundColor(colorBckgGr)
				.setWidth(widthSgr)
				.setBackgroundHeight(500)
				.setBarHeight(20);

		cp5.addSlider("sSpeed")
		.setPosition(marginSlider, gapSlider)
		.setSize(widthSgr - 10*marginSlider, heightSlider)
		.setRange(1,20)
		.setValue(1)
		.setDecimalPrecision(0)
		.setNumberOfTickMarks(10)
		.setGroup(environment);

		cp5.addColorWheel("sunColor")
		.setPosition(marginSlider, gapSlider*2+heightSlider+10)
		.setGroup(environment);

		cp5.addAccordion("Options")
		.setPosition(parent.width-widthGrSlider-20,cursorY)
		.setWidth(widthGrSlider)
		.setBackgroundColor(colorBckgGr)
		.addItem(environment)
		//.setCollapseMode()
		;
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
