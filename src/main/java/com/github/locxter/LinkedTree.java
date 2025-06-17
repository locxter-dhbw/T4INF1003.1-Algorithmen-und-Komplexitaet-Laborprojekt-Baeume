/****************************  LinkedTree.java  ******************************/
package com.github.locxter;

/** Klasse LinkedTree mit Konstruktoren und Methoden.
* 
*  Ein LinkedTree enthaelt einen Verweis auf den Wurzelknoten, der auf weitere
*  Knoten (repraesentieren den linken bzw. rechten Teilbaum) verweisen kann.
*/

public class LinkedTree implements Tree {

    Knoten wurzel;                               // Wurzel des Baums

    public LinkedTree() {                        // konstruiert einen leeren Baum
        wurzel = null;                           // Wurzel verweist auf nichts
    }

    public LinkedTree(Object x) {                // konstruiert ein Blatt
        wurzel = new Knoten(x);                  // lege Knoten mit Inhalt x an
    }

    public LinkedTree(LinkedTree l, Object x, LinkedTree r) { // konstr. Baum
        wurzel = new Knoten(x);                  // lege Knoten mit Inhalt x an
        if (l != null)                           // wenn l nicht null, setze
            wurzel.links = l.wurzel;             // wurzel von l als linken Sohn
        if (r != null)                           // wenn r nicht null, setze
            wurzel.rechts = r.wurzel;            // wurzel von r als rechten Sohn
    }

    private LinkedTree(Knoten k) {               // konstruiert einen Baum
        wurzel = k;                              // aus ubergebenem Knoten
    }                                            // (nur fuer internen Gebrauch)

    public boolean empty() {                     // liefert true,
        return wurzel == null;                   // falls Baum leer ist
    }

    public Object value() {                      // liefert Element in der Wurzel
        if (empty())
            throw new RuntimeException(" Baum ist leer ");
        return wurzel.inhalt;
    }

    public Tree left() {                         // liefert linken Teilbaum
        if (empty())
            throw new RuntimeException(" Baum ist leer ");
        return new LinkedTree(wurzel.links);     // Erzeuge Baum, der linken Sohn
    }                                            // als Wurzelknoten enthaelt

    public Tree right() {                        // liefert rechten Teilbaum
        if (empty())
            throw new RuntimeException(" Baum ist leer ");
        return new LinkedTree(wurzel.rechts);    // Erzeuge Baum, der rechten Sohn
    }                                            // als Wurzelknoten enthaelt
}
