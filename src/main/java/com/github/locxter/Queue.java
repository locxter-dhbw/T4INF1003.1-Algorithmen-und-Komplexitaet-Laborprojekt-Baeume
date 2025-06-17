/******************************  Queue.java  *******************************/
package com.github.locxter;

/** Interface zum ADT Queue          
*/

public interface Queue {
    
    public boolean empty();                 // Testet, ob Queue leer ist
    public void enq(Object x);              // Fuegt x hinten ein
    public Object front();                  // Liefert vorderstes Element
    public void deq();                      // Entfernt vorderstes Element
}
