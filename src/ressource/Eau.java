package ressource;

public class Eau extends Ressource {
	private static int qtInitEau = 100000;
	public Eau() {
		super(qtInitEau, 1);
	}
	
	public String toString() {
		return "Eau ("+super.toString()+")";
	}
	
	public static int getqtInitEau() {
		return qtInitEau;
	}
}