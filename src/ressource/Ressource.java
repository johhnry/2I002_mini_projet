package ressource;

public abstract class Ressource {
	public double quantite;
	public double qualite;
	
	public Ressource(double quantite, double qualite) {
		this.quantite = quantite;
		this.qualite  = qualite;
	}

	public void reduireQt(double r) {
		if(this.quantite>= r) this.quantite -= r;
	}

	public void augmenterQt(double r) {
		this.quantite += r;
	}

	public void reduireQual(double r) {
		if(this.qualite>= r) this.qualite -= r;
	}

	public void augmenterQual(double r) {
		if(this.qualite <= 1-r) this.qualite += r;
	}

	public double getQuantite() {
		return quantite;
	}

	public double getQualite() {
		return qualite;
	}
	
	public String toString() {
		return "qt : "+quantite+" / ql : "+qualite;
	}
	
	public abstract void reset();
}