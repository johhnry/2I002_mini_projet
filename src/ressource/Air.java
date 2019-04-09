package ressource;

public class Air extends Ressource {
	public Air() {
		super(50000, 1);
	}
	
	public String toString() {
		return "Air ("+super.toString()+")";
	}
}