package ressource;

public class Eau extends Ressource {

	public Eau() {
		super(100000, 1);
	}
	
	public String toString() {
		return "Eau ("+super.toString()+")";
	}
}