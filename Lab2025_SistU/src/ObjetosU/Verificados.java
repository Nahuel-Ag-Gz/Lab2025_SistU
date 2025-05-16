/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosU;

/**
 *
 * @author leonel
 */
public class Verificados {
    //insertar docente (facu)
    //insertar alumno (facu)
    //insertar alumno postgr (facu)
    //eliminacion(facu)
    //mostrar falta espacios.
    
    /*
    Repaso: clases.
    objeto funcional: con atributos(datos) y metodos(funciones operaciones, contructor)
    los 3 tipos de constructores: por defecto, con argumentos y de copia.
    sets y gets
    lista polimorfica: tipo de dato persona con sub clases(una clase que yo defina puede ser un atributo de otra clase)
    repasar pilas y filas. tipo estatico y dinamico. definicion de metodo sobrecargado.
    
    conceptos de herencia: Padre - Hijo y casteos. los hijjos tienen sus datos propios y a su vez los del padre.
    
    parcial: analisis de sentencias, preguntas para lo teorico.
             codigo a completar. ejecutar con una serie de sentencias en el main y corregir las incorrectas o comentarlas.
             y justificar el porque. Teoria de clase abstracta e interfaces o excepciones(try, catch, finally etc.).
    
    
    si un atributo es un arreglo o un array list debo solicitar memoria en algun lado.
    sino el constructor debe encargarse.
    que pasa cundo yo le paso con argumentos y copia un arreglo, no se puede asignar directamente, necesitamos un copyof por ej:
    si llega un arreglo mayor de tamaño por parametro debo descartar el arreglo y pedir memoria para los nuevos datos.
    
    Integer es una clase no un tipo como int. (rapper: clase envoltoria de los tiposprimitivos)
    interfaces heredan entre interfaces y las clases implementan interfaces.
    ver la diapositiva con las cajitas naranjas.
    
    
    */
    
    
    
    /*Tareas: Agregar las funcinoes de la interface al menu
    http://youtube.com/watch?v=WRlXaAGZhIQ
    public void reset() {
    if (!isempty()) {
        cursor = 0;
    } else {
        cursor = VACIA;
    }
}
    
    private static void buscarpersona(ListaPersonas lista, Scanner sc) {
    System.out.println("Ingrese el Dni de la Persona:");
    String dni = sc.nextLine();

    lista.reset(); // volvemos al inicio
    boolean encontrado = false;

    while (!lista.oos()) {
        Persona p = lista.copy();
        if (p != null && dni.equals(p.getDoc())) {
            System.out.println("Persona encontrada: " + p);
            encontrado = true;
            break;
        }
        lista.forward();
    }

    if (!encontrado) {
        System.out.println("Persona no encontrada.");
    }
lista.reset(); 
}
    
    
    
    
    
    
    
    
     private static void modificarPersona(ListaPersonas lista, Scanner sc) {
        lista.muestroEstruc();
        int i=-3,pos=0;
        System.out.print("Ingrese la posicion a modificar: ");
        
        while(i==-3){
        pos = sc.nextInt();
        sc.nextLine();
        if (pos>0&&pos<=lista.cardinalidad()){i=1;}else System.out.print("Intentelo nuevamente: ");
        }
        
            lista.reset();
        for (i = 1; i < pos; i++) lista.forward();
        
        System.out.println("Persona actual:\n" + lista.copy());
        if (lista.copy() instanceof AlumnoPostGrado){
            Persona a= crearAlumnoPostGrado(sc);
            lista.supress();
            lista.insert(a);
        }if (lista.copy() instanceof Alumno){
            Persona a=crearAlumno(sc);
            lista.supress();
            lista.insert(a);
        
        }if (lista.copy() instanceof Docente){
            Persona a= crearDocente(sc);
            lista.supress();
            lista.insert(a);
        }
        System.out.println("Persona modificada.");
        }
       
    
    
    */
}
