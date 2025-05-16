/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraS;

import ObjetosU.*;

public class ListaPersonas implements FuncEstr {

    static int VACIA = -1;
    static int LLENA = 10;
    private Persona[] elementos;
    private int ult = VACIA;
    private int cursor = VACIA;

    public ListaPersonas() {
        elementos = new Persona[LLENA];
        ult = VACIA;
        cursor = VACIA;
    }

    public ListaPersonas(ListaPersonas li) {
        elementos = new Persona[LLENA];
        ult = VACIA;
        cursor = VACIA;
        li.reset();
        reset();
        while (!li.oos()) {
            insert(li.copy());
            forward();
            li.forward();
        }
    }

    public void reset() {
        if (!isempty()) {
            cursor = 0;
        } else {
            cursor = VACIA;
        }
    }

    public void forward() {
        if (oos()) {
            System.out.println("Error No puede avanzar(oos)");
        } else {
            cursor++;
        }
    }

    public void insert(Persona x) {
        if (ult == -1) {
            ult = ult + 1;
            cursor = ult;
        } else {
            shiftD();
            ult++;
        }
        elementos[cursor] = x;
    }

    public void supress() {
        if (ult == 0) {
            cursor = VACIA;
            ult = VACIA;
        } else {
            shiftI();
            ult--;
        }
    }

    public Persona copy() {
        if (oos()) {
            System.out.println("Operacion Invalida");
            return null;
        } else {
            return elementos[cursor];
        }
    }

    public Boolean isempty() {
        return ult == VACIA;
    }

    public Boolean isfull() {
        return ult == (LLENA - 1);
    }

    public Boolean oos() {
        return ((cursor == VACIA) || (cursor == ult + 1));
    }

    private void shiftI() {
        for (int i = cursor; i <= ult; i++) {
            elementos[i] = elementos[i + 1];
        }
    }

    private void shiftD() {
        for (int i = ult; i >= cursor; i--) {
            elementos[i + 1] = elementos[i];
        }
    }

    public void muestroL() {
        int aux = cursor;
        int i = 1;
        System.out.println("El contenido de la lista es:");
        reset();
        while (cursor <= ult) {
            System.out.print("\nPosicion " + i + ": " + copy() + " - ");
            forward();
            i++;
        }
        System.out.println("--NULL");
        cursor = aux;
    }

    @Override
    public int cardinalidad() {//retorna la cantidad de elementos de la estructura
        if (ult == VACIA) {
            return 0;
        } else {
            return ult + 1;
        }
    }

    @Override
    public Boolean inStruc(Persona p) {
        if (isempty()) {
            return false;  // Lista vacía, no puede contener a la persona
        }

        reset();

        while (cursor <= ult) {
            String a = elementos[cursor].getDoc();
            if (a.equals(p.getDoc())) {
                return true;
            }
            forward();
        }
        return false;
    }

    @Override
    public void muestroEstruc() { // Muestra contenido de la estructura por pantalla.
        int i = 1;
        int aux = cursor;
        if (cursor == VACIA) {
            System.out.println("\nLa lista está vacia.");
        } else {
            System.out.println("\nEl contenido de la lista es:");
            reset();  // Reinicia el cursor al principio de la lista.

            while (cursor <= ult) {  // Recorre hasta el último elemento.
                System.out.print("\nPosicion " + i + ": " + copy() + " - ");
                forward();  // Avanza al siguiente elemento.
                i++;
            }

            System.out.println("NULL"); // Fin de la lista.
        }

        // Restaurar el valor original del cursor después de mostrar la lista.
        cursor = aux;
    }
    @Override
    public void invertir(ListaPersonas list) {
        list.reset();
        int total = list.cardinalidad();
        for (int i = total - 1; i >= 0; i--) {
            list.reset();
            for (int j = 0; j < i; j++) {
                list.forward();
            }
            insert(list.copy());
            forward();
        }
    }

    @Override
    public void elultimo(ListaPersonas list) {
        if (!list.isempty()) {
            list.reset();
            while (list.cursor < list.ult) {
                list.forward();
            }
            insert(list.copy());
        }
    }

}
