package ressource;

public class Air extends Ressource {
	private static int qtInitAir = 50000;
	
	public Air() {
		super(qtInitAir, 1);
	}
	
	public static int getqtInitAir() {
		return qtInitAir;
	}
	
	public void reset() {
		this.qualite = 1;
		this.quantite = qtInitAir;
	}
}