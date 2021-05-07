package Aplicatie;

import java.util.*;

//8) platforma food delivery(localuri, comenzi, soferi, useri)
public class Local {
    private int id;
    private String nume;
    private Map<Produs,Float> produse = new HashMap<>();
    private static int nrLocal;

    static{
        nrLocal = 0;
    }

    {
       id = ++nrLocal;
       produse = new HashMap<>();
    }

    public Local(){

    }

    public Local(String nume){
        this.nume = nume;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setProduse(Map<Produs,Float> produse) {
        this.produse = new HashMap<>(produse);
    }

    public Map<Produs,Float> getProduse() {
        return produse;
    }

    public void adaugaProdus(Produs produs ,float pret){
        produse.put(produs,pret);
    }

    public float getPretProdus(Produs produs){
        return produse.get(produs);
    }

    public void stergeProdus(String numeProdus) throws NoSuchElementException {
        boolean aFostSters = false;
        for(Produs produs : produse.keySet()){
            if(produs.getNume().equals(numeProdus)){
                produse.remove(produs);
                aFostSters = true;
            }
        }
        if(!aFostSters){
            throw new NoSuchElementException();
        }

    }

    public String afisareProduse(){
        StringBuilder toReturn = new StringBuilder();
        if(!produse.keySet().isEmpty()){
            for (Produs produs : produse.keySet()){
                toReturn.append(produs.toString() + "la pretul de: " +  produse.get(produs).toString() + "lei" + "\n");
            }
        }else{
            return "localul nu are produse";
        }

        return toReturn.toString();
    }

    @Override
    public String toString() {
        return "Local = " + nume + ":\n" +
                afisareProduse() + "\n";
    }
}
