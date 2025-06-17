/*****************************  SearchTree.java  ********************************/
package com.github.locxter;

/** Implementierung eines binaeren Suchbaums
*
*  Implementierung der im Interface Menge angekuendigten Methoden 
*  lookup, insert und delete
*  
*  Die Methode delete verwendet zusaetzlich die private Hilfs-Methode findMax. 
*/

public class SearchTree extends LinkedTree implements Menge {

    public Comparable lookup(Comparable x) { 
                                                // sucht x im SuchBaum 
        Knoten k = wurzel;                      // beginne bei wurzel
        while (k != null)                       // solange ein Knoten vorliegt
        if (x.compareTo(k.inhalt) < 0 )         // vergleiche x mit Knoteninhalt
        k = k.links;                            // steige je nach Vergleich in den
        else if (x.compareTo(k.inhalt) > 0)     // linken oder rechten Teilbaum hinab
        k = k.rechts;                    
        else                                    // oder (d.h. bei Gleichheit)
        return (Comparable) k.inhalt;           // liefere das Objekt zurueck 
        
                                                // Wenn kein Knoten mehr vorhanden
        return null;                            // (letztes k ist Blatt) liefere null 
    }

    public boolean insert(Comparable x) {       // versucht x einzufuegen
        
        if (wurzel == null) {                   // Wenn Baum leer
            wurzel = new Knoten(x);             // fuege neuen Knoten ein
            return true;                        // melde Erfolg
        }
        else {                                  // andernfalls
            Knoten vater = null;
            Knoten k = wurzel;                  // Hilfsknoten 
            while (k != null) {                 // solange ein Knoten vorliegt
                vater = k;                      // merke aktuellen Knoten als Vater
                if (x.compareTo(k.inhalt) < 0)  // falls x < k.inhalt                 
                    k = k.links;                // steige nach links ab               
                else if (x.compareTo(k.inhalt) > 0)  
                                                // falls x > k.inhalt          
                    k  = k.rechts;              // steige nach rechts ab       
                else                            // falls x und k.inhalt gleich,
                    return false;               // melde Misserfolg
            }
            
            if (x.compareTo(vater.inhalt) < 0)  // falls x kleiner als vater
                vater.links = new Knoten(x);    // haenge neuen Knoten links an
            else                                // falls x groesser als vater 
                vater.rechts = new Knoten(x);   // haenge neuen Knoten rechts an
            return true;                        // melde Erfolg
        }
    }

    public boolean delete(Comparable x) {       // loescht x aus SuchBaum
        
        Knoten vater = null,                    // Hilfsknoten vater und sohn
        sohn  = wurzel;                         // sohn wird mit wurzel initialisiert
        
                                                // suche zu loeschendes Element:
        while (sohn != null &&                  // solange sohn noch vorhanden und 
        x.compareTo(sohn.inhalt) != 0) {        // x nicht gefunden
            vater = sohn;                       // gehe eine Ebene tiefer:
            if (x.compareTo(sohn.inhalt) < 0)   // sohn wird zum neuen vater,
                sohn = sohn.links;              // linker oder rechter sohn des alten
            else                                // sohns wird neuer sohn, je nachdem in
                sohn = sohn.rechts;             // welchem Teilbaum x sein muesste
        }
                                                // finde Ersatzknoten fuer Element:
        if (sohn != null) {                     // wenn sohn != null, wurde x gefunden
            Knoten ersatzKnoten;                // Ersatzknoten, ersetzt sohn im Baum
            
            if (sohn.links == null)             // wenn linker Sohn von sohn leer,
                ersatzKnoten = sohn.rechts;     // Ersatzknoten ist re. Sohn von sohn
            else if (sohn.rechts == null)       // wenn rechter Sohn von sohn leer,
                ersatzKnoten = sohn.links;      // Ersatzknoten ist li. Sohn von sohn
            else {                              // wenn beide Soehne vorhanden,
                ersatzKnoten = sohn;            // Ersatzknoten ist sohn selbst
                                                // hole groesstes Elem. im li. Teilbaum
                Comparable tmp = (Comparable) (findMax(ersatzKnoten.links).inhalt);
                delete(tmp);                    // loesche dieses Element aus dem Baum
                ersatzKnoten.inhalt = tmp;      // setze dieses Element in ersatzKnoten
            }
                                                // Setze ersatzKnoten in Baum ein:
            if (vater == null)                  // Sonderfall: Element war in wurzel             
                wurzel = ersatzKnoten;          // ersatzKnoten ist neuer Wurzelknoten
            else if (x.compareTo(vater.inhalt) < 0) 
                                                // andernfalls untersuche, ob      
                vater.links = ersatzKnoten;     // ersatzKnoten neuer linker oder
            else                                // rechter Sohn des Vaters wird
                vater.rechts = ersatzKnoten;  
            return true;                        // melde Erfolg
        }
        else                                    // Element wurde nicht gefunden,
            return false;                       // melde Misserfolg
    }

    private Knoten findMax(Knoten t) {          // liefert Knoten mit maximalen Element
        
        while (t.rechts != null)                // solange rechter Sohn vorhanden,
            t = t.rechts;                       // steige mit t in den re. Teilbaum ab
        return t;                               // liefere t
    }  
}
