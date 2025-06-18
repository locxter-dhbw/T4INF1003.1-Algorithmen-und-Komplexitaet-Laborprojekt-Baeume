/******************************  TreeToolsTest.java  **************************/
package com.github.locxter;

/**
 * Test fuer die Klasse TreeTools
 */

public class TreeToolsTest {

    public static void main(String[] argv) {

        // Erzeuge einen Test-Baum
        LinkedTree a = new LinkedTree(new Character('A'));
        LinkedTree b = new LinkedTree(new Character('B'));
        LinkedTree m = new LinkedTree(a, new Character('*'), b);
        LinkedTree f = new LinkedTree(new Character('F'));
        LinkedTree p = new LinkedTree(f, new Character('+'), m);
        LinkedTree x = new LinkedTree(new Character('X'));
        LinkedTree y = new LinkedTree(new Character('Y'));
        LinkedTree n = new LinkedTree(x, new Character('-'), y);
        LinkedTree d = new LinkedTree(p, new Character('/'), n);


        // Testet treeHeight(), anzahlKnoten(), 
        // printTreeInorderWithParenthesis(), printTreeLevelorder()

        TreeTools.printTree(d);

        StdOut.println("Baumhoehe laut Methode (sollte 4 sein): " + TreeTools.treeHeight(d));

        StdOut.println("Anzahl Knoten laut Methode (sollte 9 sein): " + TreeTools.anzahlKnoten(d));

        StdOut.print("Ausdruck ohne Klammerung: ");
        TreeTools.printTreeInorder(d);
        StdOut.println();

        StdOut.print("Ausdruck mit Klammerung: ");
        TreeTools.printTreeInorderWithParenthesis(d);
        StdOut.println();

        StdOut.print("Baum ebenenweise: ");
        TreeTools.printTreeLevelorder(d);
        StdOut.println();


        // Testet searchTreeSort()

        StdOut.println("Sortiere  6194283");
        int[] arr = {6, 1, 9, 4, 2, 8, 3};
        arr = TreeTools.searchTreeSort(arr);
        StdOut.print("Ergebnis (sollte 1234689 sein): ");
        for (int i = 0; i < arr.length; i++)
            StdOut.print(arr[i]);

        StdOut.println();



        //----------------------------------------------
        //Aufgabe b)

        // Einlesen der Anzahl Suchbaeume und Knoten durch User

        StdOut.println("Bitte gewuenschte Anzahl Knoten pro Baum eingeben");
        int numberOfNodesPerTree = StdIn.readInt();

        StdOut.println("Bitte gewuenschte Anzahl Baeume eingeben");
        int numberOfRandomTrees = StdIn.readInt();

        StdOut.println("Erzeuge " + numberOfRandomTrees + " Suchbaeume mit je " + numberOfNodesPerTree + " Knoten");


        //Gesamthöhe der Baeume bestimmen

        int collectiveHeight = 0;

        //Baueme mit Zufälligen Werten erstellen

        for (int i = 1; i <= numberOfRandomTrees; i++) {

            // Zufällige Zahlen erzeugen
            int[] values = new int[numberOfNodesPerTree];
            for (int j = 0; j < numberOfNodesPerTree; j++) {
                values[j] = j;
            }
            // Zahlen zufällig anordnen
            StdRandom.shuffle(values);

            // Erstelle Suchbaum mit diesen Werten
            SearchTree tree = new SearchTree();
            for (int val : values) {
                tree.insert(val);
            }

            // Höhe des aktuellen Baums bestimmen
            int height = TreeTools.treeHeight(tree);
            collectiveHeight += height;
            StdOut.println("Hoehe Suchbaum " + i + ": " + height);
        }

        // Durchschnitt berechnen
        double averageHeight = (double) collectiveHeight / numberOfRandomTrees;
        double c = averageHeight / (Math.log(numberOfNodesPerTree) / Math.log(2));

        StdOut.printf("Durchschnittliche Hoehe: %.2f (entspricht %.2f * log2(n))%n", averageHeight, c);
    }
}

