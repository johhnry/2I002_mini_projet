package ressource;

public class Mineral extends Ressource {
	
	private static int qtInitMineral = 1000000;
	
	public Mineral() {
		super(qtInitMineral, 1);
	}
	
	public static int getqtInitMineral() {
		return qtInitMineral;
	}
	
	public void reset() {
		this.qualite = 1;
		this.quantite = qtInitMineral;
	}
}