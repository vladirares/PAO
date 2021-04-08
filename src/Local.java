import java.util.*;

//8) platforma food delivery(localuri, comenzi, soferi, useri)
public class Local {
    private int id;
    private String nume;
    private Map<Produs,Float> itemeMancare;
    private static int nrLocal;

    static{
        nrLocal = 0;
    }

    {
       id = ++nrLocal;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setItemeMancare(Map<Produs,Float> itemeMancare) {
        this.itemeMancare = new HashMap<>(itemeMancare);
    }

    public Map<Produs,Float> getItemeMancare() {
        return itemeMancare;
    }

    @Override
    public String toString() {
        return "Local{" +
                "nume='" + nume + '\'' +
                ", itemeMancare=" + itemeMancare +
                '}';
    }
}
