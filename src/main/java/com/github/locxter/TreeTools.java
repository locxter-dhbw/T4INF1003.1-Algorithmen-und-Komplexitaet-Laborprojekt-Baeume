/******************************  TreeTools.java  ******************************/
package com.github.locxter;

/**
 * Tool-Klasse mit einigen Algorithmen fuer Baeume
 */

public class TreeTools {

    /**
     * Ermittelt die Hoehe eines Baumes
     *
     * @param b der zu uebergebende Baum
     * @return Hoehe des Baumes
     */
    public static int treeHeight(Tree b) {
        // Basisfall: Falls der Baum leer ist, hat er die Höhe 0
        if (b.empty()) return 0;
        // Rekursionsfall: Höhe des Baumes ergibt sich aus maximaler Höhe der Teilbäume + 1
        return Math.max(treeHeight(b.left()), treeHeight(b.right())) + 1;
    }

    /**
     * Ermittelt die Anzahl der Knoten eines Baumes
     *
     * @param b der zu uebergebende Baum
     * @return Anzahl der Knoten des Baumes
     */
    public static int anzahlKnoten(Tree b) {
        // Basisfall: Falls der Baum leer ist, hat er 0 Knoten
        if (b.empty()) return 0;
        // Rekursionsfall: Anzahl der Knoten ergibt sich aus der Knotenzahl der beiden Teilbäume + 1
        return anzahlKnoten(b.left()) + anzahlKnoten(b.right()) + 1;
    }

    /**
     * gibt den �bergebenen Baum in Inorder-Traversierung ohne Klammerung aus
     *
     * @param b der zu uebergebende Baum
     */
    public static void printTreeInorder(Tree b) {
        // Basisfall: Baum ist leer, also nichts ausgeben
        if (b.empty()) return;
        // Linken Teilbaum betrachten
        printTreeInorder(b.left());
        // Wurzel ausgeben
        StdOut.print(b.value());
        // Rechten Teilbaum betrachten
        printTreeInorder(b.right());
    }

    /**
     * gibt den �bergebenen Baum in Inorder-Traversierung mit Klammerung aus
     *
     * @param b der zu uebergebende Baum
     */
    public static void printTreeInorderWithParenthesis(Tree b) {
        // Basisfall: Baum ist leer, also nichts ausgeben
        if (b.empty()) return;
        // Linken Teilbaum betrachten (If-Abfrage hier nur für korrekte Klammerung nötig)
        if (!b.left().empty()) {
            StdOut.print('(');
            printTreeInorderWithParenthesis(b.left());
            StdOut.print(')');
        }
        // Wurzel ausgeben
        StdOut.print(b.value());
        // Rechten Teilbaum betrachten (If-Abfrage hier nur für korrekte Klammerung nötig)
        if (!b.right().empty()) {
            StdOut.print('(');
            printTreeInorderWithParenthesis(b.right());
            StdOut.print(')');
        }
    }

    /**
     * gibt den �bergebenen Baum in Levelorder-Traversierung aus
     *
     * @param b der zu uebergebende Baum
     */
    public static void printTreeLevelorder(Tree b) {
        // Angepasste Version der vorhandenen printTree-Funktion ohne Leerzeichen

        // Berechne die Hoehe des Baumes
        int resthoehe = treeHeight(b);

        //Gehe die Ebenen des Baumes durch
        for (int i = 0; i < resthoehe; i++) {
            //Drucke die Ebene
            printLevelWithoutSpaces(b, i);
        }
    }

    /**
     * Druckt eine Ebene eines Baumes nach dem Prinzip der Breitensuche.
     * 0 ist dabei die Wurzel.
     *
     * @param b      der auszugebende Baum
     * @param ebene  die gewuenschte Ebene beginnend bei 0
     */
    public static void printLevelWithoutSpaces(Tree b, int level) {
        // Angepasste Version der vorhandenen printLevel-Funktion ohne Leerzeichen

        // Wenn 0 erreicht, drucke Element
        if (level == 0) {
            if (b != null) {
                StdOut.print(b.value());
            }
        } else {

            // Steige rekursiv ab, betrachte Soehne als Teilbaeume und verringere
            // dabei die zu druckende Ebene. In endende Aeste wird mit dem Nullzeiger
            // gelaufen.
            if (b != null && !b.left().empty()) {
                printLevelWithoutSpaces(b.left(), level - 1);
            } else {
                printLevelWithoutSpaces(null, level - 1);
            }

            if (b != null && !b.right().empty()) {
                printLevelWithoutSpaces(b.right(), level - 1);
            } else {
                printLevelWithoutSpaces(null, level - 1);
            }
        }
    }

    /**
     * Sortiert gegebene Zahlenfolge per Suchbaum
     *
     * @param zahlen zu sortierende Zahlenfolge
     * @return sortierte Folge
     */
    public static int[] searchTreeSort(int[] zahlen) {
        // Leeren Suchbaum anlegen
        SearchTree sTree = new SearchTree();
        // Zahlen in Suchbaum einfügen
        for (int zahl : zahlen) {
            sTree.insert(zahl);
        }
        // Suchbaum mittels Inorder-Traversierung geordnet auf einen Stack legen (durch LiFo verkehrt herum)
        LinkedStack sortedStack = new LinkedStack();
        tree2SortedStack(sTree, sortedStack);
        // Stack in Array umwandeln für Rückgabe (wegen LiFo wird das Array rückwärts durchlaufen)
        int[] sorted = new int[zahlen.length];
        for (int i = sorted.length - 1; i >= 0 && !sortedStack.empty(); i--) {
            sorted[i] = (int) sortedStack.top();
            sortedStack.pop();
        }
        return sorted;
    }

    /**
     * Helfermethode zum sortieren von Elementen im SearchTree
     *
     * @param b SearchTree mit zu sortierendem Inhalt
     * @param k Stack in den der SearchTree Inhalt sortiert werden soll
     */
    private static void tree2SortedStack(Tree b, Stack k) {
        // Angepasste Version der oben schon verwendeten Inorder-Traversierung mit Stack

        // Basisfall: Baum ist leer, also nichts ausgeben
        if (b.empty()) return;
        // Linken Teilbaum betrachten
        tree2SortedStack(b.left(), k);
        // Wurzel ausgeben
        k.push(b.value());
        // Rechten Teilbaum betrachten
        tree2SortedStack(b.right(), k);
    }

    /**
     * Druckt einen Baum auf der Konsole ebenenweise aus.
     * Nutzt treeHeight(Tree), printLevel(Tree,int,int) und spaces(int).
     *
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
     *
     * @param b      der auszugebende Baum
     * @param ebene  die gewuenschte Ebene beginnend bei 0
     * @param spaces Anzahl von Leerzeichen vor und nach jedem Element
     */
    public static void printLevel(Tree b, int level, int spaces) {

        // Wenn 0 erreicht, drucke Element mit Leerzeichen
        if (level == 0) {

            for (int i = 0; i < spaces; i++) StdOut.print(" ");
            if (b != null) {
                StdOut.print(b.value());
            } else { // Wenn Nullzeiger uebergeben wurde, ein Leerzeichen drucken
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
            } else {
                printLevel(null, level - 1, spaces);
            }

            if (b != null && !b.right().empty()) {
                printLevel(b.right(), level - 1, spaces);
            } else {
                printLevel(null, level - 1, spaces);
            }
        }
    }

    /**
     * Berechnet die Anzahl an benoetigten Leerzeichen fuer
     * eine korrekte Einrueckung, also 0.5 * (2^(level) - 2).
     *
     * @param level die Ebene, Blaetter sind Ebene 1, darueber aufsteigend
     * @return Anzahl der Leerzeichen zur Elementtrennung
     */
    private static int spaces(int level) {

        if (level == 1) {
            return 0;
        } else {
            // verdoppele die Leerzeichen gegenueber der Ebene darunter
            // und fuege ein weiteres Leerzeichen hinzu
            return 2 * spaces(level - 1) + 1;
        }
    }
}
