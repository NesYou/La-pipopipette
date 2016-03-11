package vs_ia;

import java.util.ListIterator;
import vs.Plateau;

public class Arc {
   Noeud noeudOrigine;
   public Noeud getNoeudOrigine() {
    return noeudOrigine;
   }

   Noeud noeudExtremite;
   public Noeud getNoeudExtremite() {
    return noeudExtremite;
   }

   public Arc(Plateau PlateauNoeudOrigine, Plateau PlateauNoeudExtremite, Graphe graphe){

    // recherchenoeudorigine
    ListIterator<Noeud> liNoeuds = graphe.listeNoeuds.listIterator();
    Boolean trouveOrigine = false;
    while (liNoeuds.hasNext()&&!trouveOrigine) {
       Noeud noeudCourant = liNoeuds.next();
       if (PlateauNoeudOrigine.equals(noeudCourant.getPlateau())){
        noeudOrigine = noeudCourant;
        trouveOrigine = true;
       }
    }
    // recherchenoeudextremite
    liNoeuds = graphe.listeNoeuds.listIterator();
    Boolean trouveExtremite = false;
    while (liNoeuds.hasNext()&&!trouveExtremite) {
       Noeud noeudCourant = liNoeuds.next();
       if (PlateauNoeudExtremite.equals(noeudCourant.getPlateau())){
        noeudExtremite = noeudCourant;
        trouveExtremite = true;
       }        
    }
    if (trouveOrigine && trouveExtremite) {
       graphe.listeArcs.add(this);
    } else {
       // message d'erreur
       StringBuffer erreur = new StringBuffer("Erreur arc: ("+PlateauNoeudOrigine
           +" -> "+PlateauNoeudExtremite+")\n   ");
       if (!trouveOrigine ) erreur.append(PlateauNoeudOrigine + "? ");
       if (!trouveExtremite ) erreur.append(PlateauNoeudExtremite + "? ");
       System.out.println(erreur);
    }

   }

   public String toString(){
    return new String("   arc: ( "
        + this.getNoeudOrigine().getPlateau()
        + " -> "
        + this.getNoeudExtremite().getPlateau()
        + " )"
    );
   }

}