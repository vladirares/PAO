import java.util.Set;
import java.util.TreeSet;

public abstract class Produs {
    private final Set<Ingredient> reteta;
    protected String nume;
    protected int greutate;

    Produs(){
        reteta = new TreeSet<>();
    }

    public Set<Ingredient> getReteta() {
        return reteta;
    }

    public void addIngredient(Ingredient ingredient){this.reteta.add(ingredient);}

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getGreutate() {
        return greutate;
    }

    public void setGreutate(int greutate) {
        this.greutate = greutate;
    }

    @Override
    public String toString() {
        return  "nume= " + nume + "\n" +
                "reteta=" + reteta + "\n" +
                "masa=" + greutate + "kg\n";
    }
}
