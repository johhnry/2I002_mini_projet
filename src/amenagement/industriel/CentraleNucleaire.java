package amenagement.industriel;

import processing.core.PApplet;
import terrain.Terrain;

public class CentraleNucleaire extends Industriel {
	private static String filename = "centrale.obj";
	private static String filename_destroy = "centrale_destroy.obj";

	public CentraleNucleaire(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, theta, phi);
	}

	@Override
	public void utiliser() {
		terrain.getMineral().reduireQt(5);
		terrain.getEau().reduireQt(0.5);
	}

	@Override
	public void rejeter() {
		terrain.getMineral().reduireQual(0.003);
		terrain.getEau().reduireQual(0.002);
		terrain.getAir().reduireQual(0.001);
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