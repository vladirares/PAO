public class Bautura extends Produs {
    boolean esteAlcoolica;
    boolean esteCarbogazoasa;

    Bautura(){

    }

    Bautura(String nume){
        this.nume = nume;
    }

    Bautura(String nume, int greutate){
        this.nume = nume;
        this.greutate = greutate;
    }

    public boolean getEsteAlcoolica() {
        return esteAlcoolica;
    }

    public void setEsteAlcoolica(boolean esteAlcoolica) {
        this.esteAlcoolica = esteAlcoolica;
    }

    public boolean getEsteCarbogazoasa() {
        return esteCarbogazoasa;
    }

    public void setEsteCarbogazoasa(boolean esteCarbogazoasa) {
        this.esteCarbogazoasa = esteCarbogazoasa;
    }


}
