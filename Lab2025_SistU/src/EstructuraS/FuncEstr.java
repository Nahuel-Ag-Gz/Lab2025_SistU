/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EstructuraS;
import ObjetosU.*;
/**
 *
 * @author leonel
 */
public interface FuncEstr {
    public int cardinalidad();
     public Boolean inStruc(Persona p);
     public void muestroEstruc();
     public void invertir(ListaPersonas list);//invertir el orden de la estrucutura para casos como imprimir el historial de cambios (de mas reciente a antiguo o inversamente).
     public void elultimo(ListaPersonas list);
}
