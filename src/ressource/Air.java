package ressource;

public class Air extends Ressource {
	private static int qtInitAir = 50000;
	
	public Air() {
		super(qtInitAir, 1);
	}
	
	public String toString() {
		return "Air ("+super.toString()+")";
	}
	
	public static int getqtInitAir() {
		return qtInitAir;
	}
}