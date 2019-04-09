package ressource;

public class Nourriture extends Ressource{
	public Nourriture() {
		super(0, 1);
	}
	
	
	public String toString() {
		return "Nourriture ("+super.toString()+")";
	}
}
