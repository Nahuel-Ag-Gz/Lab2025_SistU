package ObjetosU;

import java.util.ArrayList;

public class Docente extends PersUniv {
    private String Cargo;
    private ArrayList<String> Materias;

    // Constructor por defecto
    public Docente() {
        super();
        this.Cargo = "";
        this.Materias = new ArrayList<>();
    }

    // Constructor con argumentos
    public Docente(String nbre, String nroDoc, String direccion, int[] fechaNac,
                   String facultad, String carrera, int[] fechaIngre,
                   String cargo, ArrayList<String> materias) {
        super(nbre, nroDoc, direccion, fechaNac, facultad, carrera, fechaIngre);
        this.Cargo = cargo;
        this.Materias = new ArrayList<>(materias);
    }

    // Constructor copia
    public Docente(Docente otro) {
        super(otro);
        this.Cargo = otro.Cargo;
        this.Materias = new ArrayList<>(otro.Materias);
    }

    public String getCargo() {
        return Cargo;
    }

    public ArrayList<String> getMat() {
        return new ArrayList<>(Materias);
    }

    public void setCargo(String cargo) {
        this.Cargo = cargo;
    }

    public void addMat(String materia) {
        Materias.add(materia);
    }

    public void delMat(String materia) {
        Materias.remove(materia);
    }

    public void showMats() {
        System.out.println("Materias dictadas:");
        for (String mat : Materias) {
            System.out.println("- " + mat);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nCargo: ").append(Cargo);
        sb.append("\nMaterias: ");
        for (String mat : Materias) {
            sb.append("\n- ").append(mat);
        }
        return sb.toString();
    }
}
