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
    }
}

