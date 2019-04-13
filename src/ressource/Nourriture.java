package ressource;

public class Nourriture extends Ressource{
	private static int qtInitNourriture = 0;
	
	public Nourriture() {
		super(qtInitNourriture, 1);
	}
	
	
	public String toString() {
		return "Nourriture ("+super.toString()+")";
	}
	
	public static int getQtInitNourriture() {
		return qtInitNourriture;
	}
	
	public void reset() {
		this.qualite = 1;
		this.quantite = qtInitNourriture;
	}
}
