 package Ejecuciones;

import EstructuraS.ListaPersonas;
import GUI.GUI;
import ObjetosU.*;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        ListaPersonas lista = new ListaPersonas();
        GUI PantallaP = new GUI();
        PantallaP.setVisible(true);
                   // 👉 Esta línea hace que la GUI arranque maximizada manso
        //PantallaP.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        //PantallaP.setVisible(true);
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Agregar Persona");
            System.out.println("2. Eliminar Persona");
            System.out.println("3. Modificar Persona");
            System.out.println("4. Mostrar Lista");
            System.out.println("5. Buscar Persona por DNI");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 ->
                    agregarPersona(lista, sc);
                case 2 ->
                    eliminarPersona(lista, sc);
                case 3 ->
                    modificarPersona(lista, sc);
                case 4 ->
                    lista.muestroL();
                case 5 ->
                    buscarPorDNI(lista, sc);
                case 0 ->
                    System.out.println("Saliendo...");
                default ->
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 0);
    }

    private static void buscarPorDNI(ListaPersonas lista, Scanner sc) {
        System.out.print("Ingrese el DNI a buscar: ");
        String dni = sc.nextLine().trim();

        boolean encontrado = false;
        lista.reset();

        for (int i = 0; i < lista.cardinalidad(); i++) {
            Persona p = lista.copy();
            if (p.getDoc().equalsIgnoreCase(dni)) {
                System.out.println("Persona encontrada en posicion " + i + ":");
                System.out.println(p);
                encontrado = true;
                break;
            }
            lista.forward();
        }

        if (!encontrado) {
            System.out.println("No se encontro ninguna persona con DNI " + dni + ".");
        }
        //lista.reset();
    }

    
    private static void agregarPersona(ListaPersonas lista, Scanner sc) {
        Persona p = new Persona();
        PersUniv persAux = new PersUniv();

        System.out.print("Nombre: ");
        p.setNbre(sc.nextLine());
        System.out.print("Documento: ");
        p.setDoc(sc.nextLine());
        System.out.print("Direccion: ");
        p.setDir(sc.nextLine());
        p.setfNac(pedirFecha(sc, "Nacimiento"));

        System.out.print("Facultad: ");
        persAux.setFac(sc.nextLine());
        System.out.print("Carrera: ");
        persAux.setCar(sc.nextLine());
        persAux.setfIng(pedirFecha(sc, "Ingreso"));

        System.out.println("\nSeleccione tipo de persona:");
        System.out.println("1. Alumno");
        System.out.println("2. Alumno PostGrado");
        System.out.println("3. Docente");
        System.out.print("Opcion: ");
        int tipo = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        Persona nueva = switch (tipo) {
            case 1 ->
                crearAlumno(persAux, p, sc);
            case 2 ->
                crearAlumnoPostGrado(persAux, p, sc);
            case 3 ->
                crearDocente(sc, persAux, p);
            default ->
                null;
        };

        if (nueva != null) {
            lista.insert(nueva);
            System.out.println("Persona agregada exitosamente.");
        } else {
            System.out.println("Tipo invalido.");
        }
    }
     


    private static Alumno crearAlumno(PersUniv persAux, Persona p, Scanner sc) {
        Alumno a = new Alumno();
        a.setNbre(p.getNbre());
        a.setDoc(p.getDoc());
        a.setDir(p.getDir());
        a.setfNac(p.getfNac());
        a.setFac(persAux.getFac());
        a.setCar(persAux.getCar());
        a.setfIng(persAux.getfIng());

        System.out.print("Registro: ");
        a.setReg(sc.nextLine());

        return a;
    }

    private static AlumnoPostGrado crearAlumnoPostGrado(PersUniv persAux, Persona p, Scanner sc) {
        AlumnoPostGrado apg = new AlumnoPostGrado();
        apg.setNbre(p.getNbre());
        apg.setDoc(p.getDoc());
        apg.setDir(p.getDir());
        apg.setfNac(p.getfNac());
        apg.setFac(persAux.getFac());
        apg.setCar(persAux.getCar());
        apg.setfIng(persAux.getfIng());

        System.out.print("Registro: ");
        apg.setReg(sc.nextLine());
        System.out.print("Carrera de Postgrado: ");
        apg.setcarPos(sc.nextLine());

        return apg;
    }

    private static Docente crearDocente(Scanner sc, PersUniv persAux, Persona p) {
        Docente docente = new Docente();

        // Cargar datos personales y universitarios
        docente.setNbre(p.getNbre());
        docente.setDoc(p.getDoc());
        docente.setDir(p.getDir());
        docente.setfNac(p.getfNac());
        docente.setFac(persAux.getFac());
        docente.setCar(persAux.getCar());
        docente.setfIng(persAux.getfIng());

        // Cargar campo específico: Cargo
        System.out.print("Cargo: ");
        String cargo = sc.nextLine();
        docente.setCargo(cargo);

        // Cargar materias usando addMat
        String materia;
        System.out.println("Ingrese materias (vacio para terminar):");
        do {
            System.out.print("Materia: ");
            materia = sc.nextLine();
            if (!materia.isEmpty()) {
                docente.addMat(materia);  // 👈 Aquí se agrega cada materia individual
            }
        } while (!materia.isEmpty());

        return docente;
    }

    private static void eliminarPersona(ListaPersonas lista, Scanner sc) {
        lista.muestroL();
        System.out.print("Ingrese la posicion a eliminar: ");
        int pos = sc.nextInt();
        sc.nextLine();
        lista.reset();
        for (int i = 1; i < pos; i++) {
            lista.forward();
        }
        lista.supress();
        System.out.println("Elemento eliminado.");
    }

    private static void modificarPersona(ListaPersonas lista, Scanner sc) {
        lista.muestroEstruc();
        int pos;

        do {
            System.out.print("Ingrese la posicion a modificar: ");
            pos = sc.nextInt();
            sc.nextLine(); // limpiar buffer
        } while (pos < 1 || pos > lista.cardinalidad());

        lista.reset();
        for (int i = 1; i < pos; i++) {
            lista.forward();
        }

        Persona original = lista.copy();
        System.out.println("Persona actual:\n" + original);

        Persona p = new Persona();
        PersUniv persAux = new PersUniv();

        // Datos personales
        System.out.print("Desea cambiar los datos personales (nombre, documento, direccion, fecha de nacimiento)? (s/n): ");
        String respuestaPers = sc.nextLine().trim().toLowerCase();

        if (respuestaPers.equals("s")) {
            System.out.print("Nombre: ");
            p.setNbre(sc.nextLine());
            System.out.print("Documento: ");
            p.setDoc(sc.nextLine());
            System.out.print("Direccion: ");
            p.setDir(sc.nextLine());
            p.setfNac(pedirFecha(sc, "Nacimiento"));
        } else {
            p.setNbre(original.getNbre());
            p.setDoc(original.getDoc());
            p.setDir(original.getDir());
            p.setfNac(original.getfNac());
        }

        // Datos universitarios
        System.out.print("Desea cambiar los datos universitarios (facultad, carrera, fecha de ingreso)? (s/n): ");
        String respuestaUniv = sc.nextLine().trim().toLowerCase();

        if (respuestaUniv.equals("s")) {
            System.out.print("Facultad: ");
            persAux.setFac(sc.nextLine());
            System.out.print("Carrera: ");
            persAux.setCar(sc.nextLine());
            persAux.setfIng(pedirFecha(sc, "Ingreso"));
        } else if (original instanceof PersUniv pu) {
            persAux.setFac(pu.getFac());
            persAux.setCar(pu.getCar());
            persAux.setfIng(pu.getfIng());
        }

        Persona nueva = null;

        if (original instanceof AlumnoPostGrado) {
            nueva = crearAlumnoPostGrado(persAux, p, sc);
        } else if (original instanceof Alumno) {
            nueva = crearAlumno(persAux, p, sc);
        } else if (original instanceof Docente) {
            persAux.setNbre(p.getNbre());
            persAux.setDoc(p.getDoc());
            persAux.setDir(p.getDir());
            persAux.setfNac(p.getfNac());
            nueva = crearDocente(sc, persAux, p);
        }

        lista.supress();
        lista.insert(nueva);
        System.out.println("Persona modificada correctamente.");
    }

    private static int[] pedirFecha(Scanner sc, String tipo) {
        System.out.println("Fecha de " + tipo + " (dd mm yyyy): ");
        int d = sc.nextInt(), m = sc.nextInt(), a = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        return new int[]{d, m, a};
    }

}
