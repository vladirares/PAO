import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import static java.lang.Math.round;

public class Main {
    public static void main(String []arg){

        App aplicatie = App.getApp();

        //1.adaugare sofer + afisare soferi + stergere sofer
        Sofer s1 = new Sofer();
        Sofer s2 = new Sofer();
        s1.setVehicul(new Bicicleta());
        s1.setNume("Bretiliu Clopidogrel");
        s2.setVehicul(new Motocicleta());
        s2.setNume("Vladimir Popescu");
        aplicatie.adaugaSofer(s1);
        aplicatie.adaugaSofer(s2);

        aplicatie.adaugaSofer(new Sofer("Andrei Balasoiu",new Bicicleta()));
        aplicatie.adaugaSofer(new Sofer("Dragomir Alexandru",new Masina()));

        aplicatie.afiseazaSoferi();

        System.out.println("------------------------------------------------");

        aplicatie.stergeSofer(2);

        aplicatie.afiseazaSoferi();


        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");

        //2.adaugare local + afisare localuri + sterege local

        aplicatie.adaugaLocal(new Local("McStarbucks"));
        aplicatie.adaugaLocal(new Local("KFC"));
        aplicatie.adaugaLocal(new Local("Uveit"));

        aplicatie.afiseazaLocaluri();

        System.out.println("------------------------------------------------");

        aplicatie.stergeLocal(3);
        aplicatie.afiseazaLocaluri();


        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");

        //3. adaugare user + afisare useri + stergere user

        aplicatie.adaugaUser(new User("Ionescu Ion","Splaiul Independentei"));
        aplicatie.adaugaUser(new User("Claudia Popescu","Strada Tunari nr 4"));
        aplicatie.afiseazaUseri();

        System.out.println("------------------------------------------------");

        aplicatie.stergeUser(2);

        aplicatie.afiseazaUseri();

        System.out.println("------------------------------------------------");

        //4. adaugare produse la localuri

        aplicatie.getLocal(1).adaugaProdus(new Burger("McBurger",1),15f);
        aplicatie.getLocal(1).adaugaProdus(new Burger("McBurger",1),15f);
        aplicatie.getLocal(2).adaugaProdus(new Bautura("Pepsi",2),5f);
        aplicatie.getLocal(2).adaugaProdus(new Bautura("Mirinda",1),3.5f);
        aplicatie.getLocal(2).adaugaProdus(new Burger("Double Booster",1),13f);

        aplicatie.afiseazaLocaluri();

        // 5. adaugare comenzi

        aplicatie.adaugaComanda(new Comanda(aplicatie.getUser(1), aplicatie.getSofer(1),new HashMap<>()));
        aplicatie.getSofer(1).setEsteLiber(false);
        aplicatie.afiseazaComenzi();

        // 6. adaugare produse la comanda + verificare bauturi alcoolice la minori

        aplicatie.getUser(1).setDataNasterii(new Date());
        Bautura neumarkt = new Bautura("Neumarkt",1);
        neumarkt.setEsteAlcoolica(true);

        try {
            aplicatie.getComanda(1).adaugaProdus(new Burger("Mc Chicken",1),2);
            aplicatie.afiseazaComenzi();
            aplicatie.getComanda(1).adaugaProdus(neumarkt,2);
        } catch (Exception e) {
            System.out.println("a aruncat exceptie");
        }
        System.out.println("\n------------------------------------------------");
        System.out.println("------------------------------------------------");

        // 7. adaugare ingrediente + afisarea lor in oridine alfabetica
        Bautura cafeaCuLapte = new Bautura("cafea cu lapte",3);
        cafeaCuLapte.addIngredient(new Ingredient("lapte",1));
        cafeaCuLapte.addIngredient(new Ingredient("cafea",2));
        aplicatie.getLocal(1).adaugaProdus(cafeaCuLapte,12);
        System.out.println(aplicatie.getLocal(1));

        //8. asigneaza soferi in functie de vehiculul condus si ora curenta (la ore de varf sunt prioritizati soferii
        //   cu motociclete si biciclete)

        Comanda c2 = new Comanda();
        c2.setUser(new User("Bratan Andrei","Militari Residence"));
        try {
            c2.adaugaProdus(new Burger("McWooper",2),3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            aplicatie.asigneazaSofer(c2);
        } catch (NoDriverException e) {
            System.out.println("nu s-a gasit sofer");
        }

        //9. afisarea curierilor care sunt in deplasare

        aplicatie.afiseazaSoferiOcupati();

        System.out.println("\n------------------------------------------------");
        System.out.println("------------------------------------------------");

        //10. afisarea localurilor cu bauturi alcoolice
        Bautura bere = new Bautura();
        bere.setEsteAlcoolica(true);
        aplicatie.getLocal("KFC").adaugaProdus(bere,5);
        aplicatie.afiseazaLocaluriCuBauturiAlcoolice();

    }


}
