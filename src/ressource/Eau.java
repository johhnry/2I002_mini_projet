package ressource;

public class Eau extends Ressource {
	private static int qtInitEau = 100000;
	public Eau() {
		super(qtInitEau, 1);
	}
	
	public static int getqtInitEau() {
		return qtInitEau;
	}
	
	public void reset() {
		this.qualite = 1;
		this.quantite = qtInitEau;
	}
}