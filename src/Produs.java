import java.util.Set;
import java.util.TreeSet;

public abstract class Produs {
    private Set<Ingredient> reteta;
    private String nume;

    public Set<Ingredient> getReteta() {
        return reteta;
    }

    public void setReteta(Set<Ingredient> reteta) {
        this.reteta = new TreeSet<>(reteta);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }


}
