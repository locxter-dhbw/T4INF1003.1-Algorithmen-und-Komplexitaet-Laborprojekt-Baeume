/***************************  LinkedQueue.java  ***************************/
package com.github.locxter;

/**
* Implementierung des ADT Queue (Schlange) mit Hilfe von Verweisen
* und darauf definierten Operationen: empty, enq, deq, front
*/
public class LinkedQueue implements Queue
{

    /**
    * Verweis auf den Schlangenanfang.
    */
    private Element head;

    /**
    * Verweis auf das Schlangenende.
    */
    private Element tail;

    /**
    * Erzeugt eine leere LinkedQueue.
    */
    public LinkedQueue()
    {
        head = tail = null;
    }

    /**
    * Testet, ob die LinkedQueue leer ist.
    *
    * @return true, falls die Schlage leer ist, sonst false.
    */
    public boolean empty()
    {
        return head == null;
    }

    /**
    * Fuegt eine Element in die Schlange ein.
    *
    * @param x Objekt, welches eingefuegt werden soll.
    */
    public void enq(Object x)
    {

        if (empty())
        tail = head = new Element();
        else
        {
            tail.next = new Element();          // Neuen anhaengen
            tail = tail.next;                   // Schlangenende 1 weitersetzen
        }
        tail.inhalt = x;                        // x zuweisen
        tail.next = null;                       // Schlangenende
    }

    /**
    * Entfernt das vorderste Schlangenelement.
    *
    * @throws RuntimeException
    *           Wird geworfen, falls die Schlange leer ist.
    */
    public void deq()
    {
        if (empty())                            // Falls Schlange leer, dann Abbruch
        throw new RuntimeException("deq: Queue ist leer");

        head = head.next;                       // Naechtster Element wird aktuell

        if (head == null)                       // wenn Kopf auf kein Objekt verweist
        tail = null;                            // Schlangenende setzen
    }

    /**
    * Liefert das vorderste Element der Schlange.
    *
    * @return Das vorderste Schlangenelement.
    * @throws RuntimeException
    *           Wird geworfen, falls die Schlange leer ist.
    */
    public Object front()
    {
        if (empty())                            // Falls Schlange leer, dann Abbruch
        throw new RuntimeException("front: Queue ist leer");

        return head.inhalt;
    }
}
