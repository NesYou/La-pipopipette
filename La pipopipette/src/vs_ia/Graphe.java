package vs_ia;

import java.util.LinkedList;
import java.util.ListIterator;

public class Graphe {
   LinkedList<Noeud> listeNoeuds = new LinkedList<Noeud> ();
   LinkedList<Arc> listeArcs = new LinkedList<Arc> ();

   public Object[] getNoeuds(){
    return listeNoeuds.toArray();
   }

   public Object[] getArcs(){
    return listeArcs.toArray();
   }

   public String toString(){
    StringBuffer texte = new StringBuffer("*** graphe ***\n");
    ListIterator<Noeud> liNoeud = this.listeNoeuds.listIterator();
    while (liNoeud.hasNext()){
       Noeud noeudCourant = liNoeud.next();
       texte.append(noeudCourant.toString()+"\n" );
    }
    ListIterator<Arc> liArc = this.listeArcs.listIterator();
    while (liArc.hasNext()){
       Arc arcCourant = liArc.next();
       texte.append(arcCourant.toString()+"\n" );
    }
    return texte.toString();
   }
}