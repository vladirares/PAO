import static java.lang.Math.*;

public class Ingredient implements Comparable<Ingredient> {
    private String nume;
    private float cantitate;
    private float pretBucata;

    Ingredient(){

    }

    Ingredient(String nume){
        this.nume = nume;
    }

    Ingredient(String nume, float cantitate){
        this.nume = nume;
        this.cantitate = cantitate;
    }

    Ingredient(String nume, float cantitate, float pretBucata){
        this.nume = nume;
        this.cantitate = cantitate;
        this.pretBucata = pretBucata;
    }

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
    public String toString() {
        return "Ingrediente{" +
                "nume='" + nume + '\'' +
                ", cantitate=" + cantitate +
                '}';
    }

    @Override
    public int compareTo(Ingredient o) {
        return nume.compareTo(o.nume) ;
    }
}
