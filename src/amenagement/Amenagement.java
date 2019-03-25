package amenagement;
import java.util.Vector;

import element.Element;
import ressource.Ressource;

public abstract class Amenagement extends Element {

  public Ressource useRessources;

  public Ressource impactRessources;

  public Integer qtUseRessources;

  public Integer qtImpactRessources;

    public Vector  myTerrain;

}