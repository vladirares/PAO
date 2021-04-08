import java.util.Map;

public class Comanda {
    private final int id;
    private User user;
    private Sofer sofer;
    private Map<Produs,Float> produse;

    private static int nrComanda;

    static{
        nrComanda = 0;
    }

    {
        id = ++nrComanda;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Sofer getSofer() {
        return sofer;
    }

    public void setSofer(Sofer sofer) {
        this.sofer = sofer;
    }

    public Map<Produs, Float> getProduse() {
        return produse;
    }

    public void setProduse(Map<Produs, Float> produse) {
        this.produse = produse;
    }

    public static int getNrComanda() {
        return nrComanda;
    }

    public static void setNrComanda(int nrComanda) {
        Comanda.nrComanda = nrComanda;
    }

}
