/******************************  TreeTools.java  ******************************/
package com.github.locxter;

/**
* Tool-Klasse mit einigen Algorithmen fuer Baeume
*/

public class TreeTools {

    /**
    * Ermittelt die Hoehe eines Baumes
    * @param b der zu uebergebende Baum
    * @return Hoehe des Baumes
    */
    public static int treeHeight(Tree b) {
        // TODO

    }

    /**
    * Ermittelt die Anzahl der Knoten eines Baumes
    * @param b der zu uebergebende Baum
    * @return Anzahl der Knoten des Baumes
    */
    public static int anzahlKnoten(Tree b) {
        // TODO
        
    }  

    /**
    * gibt den �bergebenen Baum in Inorder-Traversierung mit Klammerung aus
    * @param b der zu uebergebende Baum
    */
        public static void printTreeInorderWithParenthesis(Tree b) {
        // TODO
        
    }  

    /**
    * gibt den �bergebenen Baum in Levelorder-Traversierung aus
    * @param b der zu uebergebende Baum
    */
    public static void printTreeLevelorder(Tree b) {
        // TODO
        
    }  

    /**
    * Sortiert gegebene Zahlenfolge per Suchbaum
    * @param zahlen zu sortierende Zahlenfolge
    * @return sortierte Folge
    */
    public static int[] searchTreeSort(int[] zahlen) {
        // TODO
        
    }  

    /**
    * Helfermethode zum sortieren von Elementen im SearchTree
    * @param b SearchTree mit zu sortierendem Inhalt
    * @param k Stack in den der SearchTree Inhalt sortiert werden soll
    */
    private static void tree2SortedStack(Tree b, Stack k) {
        // TODO 
        
    }


    /**
    * Druckt einen Baum auf der Konsole ebenenweise aus.
    * Nutzt treeHeight(Tree), printLevel(Tree,int,int) und spaces(int).
    * @param b der zu druckende Baum
    */
    public static void printTree(Tree b) {

        // Berechne die Hoehe des Baumes
        int resthoehe = treeHeight(b);

        //Gehe die Ebenen des Baumes durch
        for (int i = 0; i < resthoehe; i++) {
            //Drucke die Ebene, beruecksichtige Anzahl der Leerzeichen
            //fuer korrekte Einrueckung
            printLevel(b, i, spaces(resthoehe - i));
            StdOut.println();
            StdOut.println();
        }
    }

    /**
    * Druckt eine Ebene eines Baumes aehnlich der Breitensuche.
    * 0 ist dabei die Wurzel. Vor und nach jedem Element werden Leerzeichen 
    * eingefuegt.
    * @param b der auszugebende Baum
    * @param ebene die gewuenschte Ebene beginnend bei 0
    * @param spaces Anzahl von Leerzeichen vor und nach jedem Element
    */
    public static void printLevel(Tree b, int level, int spaces) {

        // Wenn 0 erreicht, drucke Element mit Leerzeichen
        if (level == 0) {

            for (int i = 0; i < spaces; i++) StdOut.print(" ");
            if (b != null) {
                StdOut.print(b.value());
            }
            else { // Wenn Nullzeiger uebergeben wurde, ein Leerzeichen drucken
                StdOut.print(" ");
            }
            for (int i = 0; i <= spaces; i++) 
                StdOut.print(" ");

        } else {

            // Steige rekursiv ab, betrachte Soehne als Teilbaeume und verringere
            // dabei die zu druckende Ebene. In endende Aeste wird mit dem Nullzeiger
            // gelaufen.
            if (b != null && !b.left().empty()) {
                printLevel(b.left(), level - 1, spaces);
            }
            else {
                printLevel(null, level - 1, spaces);
            }

            if (b != null && !b.right().empty()) {
                printLevel(b.right(), level - 1, spaces);
            }
            else {
                printLevel(null, level - 1, spaces);
            }
        }
    }

    /**
    * Berechnet die Anzahl an benoetigten Leerzeichen fuer
    * eine korrekte Einrueckung, also 0.5 * (2^(level) - 2).
    * @param level die Ebene, Blaetter sind Ebene 1, darueber aufsteigend
    * @return Anzahl der Leerzeichen zur Elementtrennung
    */
    private static int spaces(int level) {

        if (level == 1) {
            return 0;
        }
        else {
            // verdoppele die Leerzeichen gegenueber der Ebene darunter
            // und fuege ein weiteres Leerzeichen hinzu
            return 2 * spaces(level - 1) + 1;
        }
    }
}
