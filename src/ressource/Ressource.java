package ressource;
import java.util.Vector;

import element.Element;

public abstract class Ressource extends Element {

  public Integer quantite;

  public Integer qualite;

    public Vector  myTerrain;
    public Vector  myVivant;

  public void reduireQt() {
  }

  public void augmenterQt() {
  }

  public void reduireQual() {
  }

  public void augmenterQual() {
  }

}