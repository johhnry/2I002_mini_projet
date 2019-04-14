package amenagement.industriel;

import processing.core.PApplet;
import terrain.Terrain;

public class CentraleNucleaire extends Industriel {
	private static final String filename = "centrale.obj";
	private static final String filename_destroy = "centrale_destroy.obj";

	public CentraleNucleaire(PApplet parent, Terrain terrain, double theta, double phi) {
		super(parent, terrain, filename, filename_destroy, theta, phi);
	}

	public CentraleNucleaire(PApplet parent, Terrain terrain) {
		super(parent, terrain, filename, filename_destroy);
	}

	public void utiliser() {
		terrain.getMineral().reduireQt(2);
		terrain.getEau().reduireQt(2);
	}

	public void rejeter() {
		terrain.getMineral().reduireQual(0.003);
		terrain.getEau().reduireQual(0.002);
		terrain.getAir().reduireQual(0.001);
	}

	public boolean update() {
		utiliser();
		rejeter();
		if (terrain.getMineral().getQuantite() <= 0) {
			this.destroy();
		}
		return true;
	}
}