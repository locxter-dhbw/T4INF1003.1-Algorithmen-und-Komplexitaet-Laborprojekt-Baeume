/********************************  Tree.java  *********************************/
package com.github.locxter;

/** Interface Tree 
*/

public interface Tree { 

    public boolean empty();                  // liefert true, falls Baum leer ist
    public Tree left();                      // liefert linken Teilbaum
    public Tree right();                     // liefert rechten Teilbaum
    public Object value();                   // liefert Objekt in der Wurzel

}
