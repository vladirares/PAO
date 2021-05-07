package Aplicatie;

public class Sofer {
    private int id;
    private String nume;
    private Vehicul vehicul;
    private boolean esteLiber;

    private static int nrSofer;

    static{
        nrSofer = 0;
    }

    {
        id = ++nrSofer;
        esteLiber = true;
    }


    public void setId(int id) {
        this.id = id;
    }

    public Sofer(){

    }

    public Sofer(String nume){
        this.nume = nume;
    }

    public Sofer(String nume, Vehicul vehicul){
        this.nume = nume;
        this.vehicul = vehicul;
    }

    public Vehicul getVehicul() {
        return vehicul;
    }

    public void setVehicul(Vehicul vehicul) {
        this.vehicul = vehicul;
    }


    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public boolean getEsteLiber() {
        return esteLiber;
    }

    public void setEsteLiber(boolean esteLiber) {
        this.esteLiber = esteLiber;
    }

    @Override
    public String toString() {
        return "id=" + id + "\n" +
                ", nume='" + nume + "\n" +
                ", vehicul=" + vehicul + "\n" +
                ", esteLiber=" + esteLiber ;
    }
}
