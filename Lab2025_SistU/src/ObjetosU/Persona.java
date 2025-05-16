package ObjetosU;

public class Persona {
    private String Nbre;
    private String NroDoc;
    private String Direccion;
    private int[] fechaNac;

    // Constructor por defecto
    public Persona() {
        this.Nbre = "";
        this.NroDoc = "";
        this.Direccion = "";
        this.fechaNac = new int[3];
    }

    // Constructor con argumentos
    public Persona(String nbre, String nroDoc, String direccion, int[] fechaNac) {
        this.Nbre = nbre;
        this.NroDoc = nroDoc;
        this.Direccion = direccion;
        this.fechaNac = fechaNac.clone();
    }

    // Constructor copia
    public Persona(Persona otra) {
        this.Nbre = otra.Nbre;
        this.NroDoc = otra.NroDoc;
        this.Direccion = otra.Direccion;
        this.fechaNac = otra.fechaNac.clone();
    }

    public String getNbre() {
        return Nbre;
    }

    public String getDoc() {
        return NroDoc;
    }

    public String getDir() {
        return Direccion;
    }

    public int[] getfNac() {
        return fechaNac.clone();
    }

    public void setNbre(String nbre) {
        this.Nbre = nbre;
    }

    public void setDoc(String nroDoc) {
        this.NroDoc = nroDoc;
    }

    public void setDir(String direccion) {
        this.Direccion = direccion;
    }

    public void setfNac(int[] fechaNac) {
        this.fechaNac = fechaNac.clone();
    }

    @Override
    public String toString() {
        return "Nombre: " + Nbre + "\nDocumento: " + NroDoc + "\nDireccion: " + Direccion +
               "\nFecha Nacimiento: " + fechaNac[0] + "/" + fechaNac[1] + "/" + fechaNac[2];
    }
}
