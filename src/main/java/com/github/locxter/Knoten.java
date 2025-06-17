/******************************  Knoten.java  ********************************/
package com.github.locxter;

/** Hilfs-Klasse Knoten fuer Baeume mit einem Konstruktor
*/

public class Knoten {
    
    Object inhalt;                              // Knoteninhalt
    Knoten links, rechts;                       // linker, rechter Teilbaum
    
    public Knoten(Object x) {                   // konstruiere Knoten       
        inhalt = x;                             // mit Inhalt x
        links = rechts = null;                  // Nullverweis fuer die Soehne
    }
} 

