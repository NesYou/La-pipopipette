package vs_ia;


import java.util.LinkedList;
import java.util.ListIterator;
import vs.Plateau;

public class Noeud {
	
   Plateau plateau;
   
   public Plateau getPlateau() {
    return plateau;
   }

   Graphe graphe;

   public Noeud (Plateau plateau, Graphe graphe){
    this.plateau = plateau;
    this.graphe = graphe;
    graphe.listeNoeuds.add(this);
   }

   public String toString(){
    return new String("   noeud: "+ this.getPlateau());
   }

   public Object[] getChildren(Noeud noeud){
    LinkedList<Noeud> children = new LinkedList<Noeud> ();
    ListIterator<Arc> liArc = graphe.listeArcs.listIterator();
    while (liArc.hasNext()){
       Arc arcCourant = liArc.next();
       if (arcCourant.getNoeudOrigine().getPlateau().equals(noeud.getPlateau())){
        children.add(arcCourant.getNoeudExtremite());
       }
    }
    return children.toArray();
   }

   public Boolean hasChildren(){
    return (getChildren(this).length != 0 );
   }
}