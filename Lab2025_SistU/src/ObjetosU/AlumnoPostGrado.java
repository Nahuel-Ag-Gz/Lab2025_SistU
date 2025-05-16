package ObjetosU;

public class AlumnoPostGrado extends Alumno {
    private String CarreraPostG;

    // Constructor por defecto
    public AlumnoPostGrado() {
        super();
        this.CarreraPostG = "";
    }

    // Constructor con argumentos
    public AlumnoPostGrado(String nbre, String nroDoc, String direccion, int[] fechaNac,
                           String facultad, String carrera, int[] fechaIngre,
                           String registro, String carreraPostG) {
        super(nbre, nroDoc, direccion, fechaNac, facultad, carrera, fechaIngre, registro);
        this.CarreraPostG = carreraPostG;
    }

    // Constructor copia
    public AlumnoPostGrado(AlumnoPostGrado otro) {
        super(otro);
        this.CarreraPostG = otro.CarreraPostG;
    }

    public String getcarPos() {
        return CarreraPostG;
    }

    public void setcarPos(String cp) {
        this.CarreraPostG = cp;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCarrera de Postgrado: " + CarreraPostG;
    }
}
