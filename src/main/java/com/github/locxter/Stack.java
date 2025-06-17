/*****************************  Stack.java  **********************************/
package com.github.locxter;

/** Interface fuer den ADT Stack                                           
 */

public interface Stack {

    public boolean empty();     // liefert true, falls Stack leer, false sonst
    public void push(Object x); // legt Objekt x auf den Stack    
    public Object top();        // liefert oberstes Stackelement
    public void pop();          // entfernt oberstes Stackelement
}
