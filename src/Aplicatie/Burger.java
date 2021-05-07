package Aplicatie;

public class Burger extends Produs {
    public Burger(){

    }

    public Burger(String nume){
        this.nume = nume;
    }

    public Burger(String nume, int greutate){
        this.nume = nume;
        this.greutate = greutate;
    }
}
