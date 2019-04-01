package vivant;

import ressource.Eau;
import ressource.Ressource;

public interface Sustenter {
	public void manger(Ressource r);
	public void boire(Eau eau);
}