package ressource;

public class Mineral extends Ressource {
	
	public Mineral() {
		super(1000000, 1);
	}
	
	public String toString() {
		return "Mineral ("+super.toString()+")";
	}
}