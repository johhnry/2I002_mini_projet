package amenagement.industriel;

import processing.core.PApplet;
import terrain.Terrain;

public class Raffinerie extends Industriel {
	private static String filename = "raffinerie.obj";
	private static String filename_destroy = "raffinerie_destroy.obj";

	public Raffinerie(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
	}

	@Override
	public void utiliser() {
		terrain.getMineral().reduireQt(10);
		terrain.getEau().reduireQt(5);
	}

	@Override
	public void rejeter() {
		terrain.getMineral().reduireQual(0.001);
		terrain.getEau().reduireQual(0.002);
		terrain.getAir().reduireQual(0.003);
	}

	@Override
	public boolean update() {
		utiliser();
		rejeter();
		if (terrain.getMineral().getQuantite() <= 0) {
			this.destroy(filename_destroy);
		}
		return true;
	}
}