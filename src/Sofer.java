public class Sofer {
    private int id;
    private String nume;
    private Vehicul vehicul;

    private static int nrSofer;

    static{
        nrSofer = 0;
    }

    {
        id = ++nrSofer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

}
