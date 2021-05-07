package Aplicatie;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Comanda {
    private int id;
    private User user;
    private Sofer sofer;
    private Map<Produs,Float> produse = new HashMap<>();

    private static int nrComanda;

    static{
        nrComanda = 0;
    }

    {
        id = ++nrComanda;
    }

    public Comanda(){

    }

    public Comanda(User user, Sofer sofer){
        this.user = user;
        this.sofer = sofer;
    }

    public Comanda(User user, Sofer sofer, Map<Produs,Float> produse){
        this.user = user;
        this.sofer = sofer;
        this.produse = produse;
    }

    public void setId(int id) {
        this.id = id;
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

    public void adaugaProdus(Produs produs,float cantitate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

        Date date = new Date();
        Date date2 = this.getUser().getDataNasterii();
        Calendar calendar = GregorianCalendar.getInstance();
        Calendar calendar2 = GregorianCalendar.getInstance();
        calendar.setTime(date);
        calendar2.setTime(date2);
        int an = calendar.get(Calendar.YEAR);
        int luna = calendar.get(Calendar.MONTH);
        int zi = calendar.get(Calendar.DAY_OF_MONTH);
        int an2 = calendar2.get(Calendar.YEAR);
        int luna2 = calendar2.get(Calendar.MONTH);
        int zi2 = calendar2.get(Calendar.DAY_OF_MONTH);

        Date anNastere = sdf.parse(zi2+"/"+luna2+"/"+an2);
        Date today = sdf.parse(zi+"/"+luna+"/"+an);

        long diffInMillies = Math.abs(today.getTime() - anNastere.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        if(produs instanceof Bautura && ((Bautura) produs).getEsteAlcoolica() && diff < 365 * 18){
            throw new Exception("Minorii nu pot cumpara bauturi alcoolice");
        }else{
            produse.put(produs,cantitate);
        }

    }

    @Override
    public String toString() {
        return "Comanda{" +
                "id=" + id +
                ", user=" + user +
                ", sofer=" + sofer +
                ", produse=" + produse +
                '}';
    }
}
