package ObjetosU;

public class PersUniv extends Persona {
    private String Facultad;
    private String Carrera;
    private int[] fechaIngre;

    // Constructor por defecto
    public PersUniv() {
        super();
        this.Facultad = "";
        this.Carrera = "";
        this.fechaIngre = new int[3];
    }

    // Constructor con argumentos
    public PersUniv(String nbre, String nroDoc, String direccion, int[] fechaNac,
                    String facultad, String carrera, int[] fechaIngre) {
        super(nbre, nroDoc, direccion, fechaNac);
        this.Facultad = facultad;
        this.Carrera = carrera;
        this.fechaIngre = fechaIngre.clone();
    }

    // Constructor copia
    public PersUniv(PersUniv otra) {
        super(otra);
        this.Facultad = otra.Facultad;
        this.Carrera = otra.Carrera;
        this.fechaIngre = otra.fechaIngre.clone();
    }

    public String getFac() {
        return Facultad;
    }

    public String getCar() {
        return Carrera;
    }

    public int[] getfIng() {
        return fechaIngre.clone();
    }

    public void setFac(String facultad) {
        this.Facultad = facultad;
    }

    public void setCar(String carrera) {
        this.Carrera = carrera;
    }

    public void setfIng(int[] fechaIngre) {
        this.fechaIngre = fechaIngre.clone();
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nFacultad: " + Facultad +
               "\nCarrera: " + Carrera +
               "\nFecha Ingreso: " + fechaIngre[0] + "/" + fechaIngre[1] + "/" + fechaIngre[2];
    }
}
