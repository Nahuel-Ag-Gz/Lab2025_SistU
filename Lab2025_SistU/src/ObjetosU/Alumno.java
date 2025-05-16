package ObjetosU;

public class Alumno extends PersUniv {
    private String Registro;

    // Constructor por defecto
    public Alumno() {
        super();
        this.Registro = "";
    }

    // Constructor con argumentos
    public Alumno(String nbre, String nroDoc, String direccion, int[] fechaNac,
                  String facultad, String carrera, int[] fechaIngre, String registro) {
        super(nbre, nroDoc, direccion, fechaNac, facultad, carrera, fechaIngre);
        this.Registro = registro;
    }

    // Constructor copia
    public Alumno(Alumno otro) {
        super(otro);
        this.Registro = otro.Registro;
    }

    public String getReg() {
        return Registro;
    }

    public void setReg(String registro) {
        this.Registro = registro;
    }

    @Override
    public String toString() {
        return super.toString() + "\nRegistro: " + Registro;
    }
}
