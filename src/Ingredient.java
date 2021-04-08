import static java.lang.Math.*;

public class Ingredient implements Comparable<Ingredient> {
    private String nume;
    private float cantitate;
    private float pretBucata;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public float getCantitate() {
        return cantitate;
    }

    public void setCantitate(float cantitate) {
        this.cantitate = cantitate;
    }

    public float getPretBucata() {
        return pretBucata;
    }

    public void setPretBucata(float pretBucata) {
        this.pretBucata = pretBucata;
    }

    public float getPret(){return pretBucata * cantitate;}

    @Override
    public int compareTo(Ingredient o) {
        return Float.compare(this.pretBucata,o.pretBucata) ;
    }
}
