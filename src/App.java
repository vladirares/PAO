import java.util.*;

public class App {
    private static App app;
    private final List<Local> localuri;
    private final List<Sofer> soferi;
    private final List<User> useri;
    private final List<Comanda> comenzi;

    private App() {
        this.localuri = new ArrayList<Local>();
        this.soferi = new ArrayList<Sofer>();
        this.useri = new ArrayList<User>();
        this.comenzi = new ArrayList<>();
    }

    public static App getApp(){
        if(app == null){
            app = new App();
        }
        return app;
    }

    public void adaugaLocal(Local l){localuri.add(l);}
    public void stergeLocal(String numeLocal){
        localuri.removeIf(x -> x.getNume().equals(numeLocal));
    }
    public void stergeLocal(int id){
        localuri.removeIf(x -> x.getId()==id);
    }

    public void adaugaSofer(Sofer s){soferi.add(s);}
    public void stergeSofer(int id){
        soferi.removeIf(x -> x.getId()==id);
    }
    public void adaugaUser(User u){useri.add(u);}
    public void stergeUser(int id){
        useri.removeIf(x -> x.getId() == id);
    }

    public Local getLocal(String numeLocal){
        for(Local x : localuri){
            if(x.getNume().equals(numeLocal)) {
                return x;
            }
        }
        return null;
    }

    public Local getLocal(int id){
        for(Local x : localuri){
            if(x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    public Sofer getSofer(int id){
        for(Sofer x : soferi){
            if(x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    public List<Sofer> getSoferi() {
        return soferi;
    }

    public void afiseazaSoferi(){
        for(Sofer sofer : soferi){
            System.out.println("\n"+sofer+"\n");
        }
    }

    public void afiseazaLocaluri(){
        for(Local local : localuri){
            System.out.println("\n"+local+"\n");
        }
    }

    public void afiseazaUseri(){
        for(User user : useri){
            System.out.println("\n"+user+"\n");
        }
    }

    public void afiseazaComenzi(){
        for(Comanda comanda : comenzi){
            System.out.println("\n"+comanda+"\n");
        }
    }

    public void afiseazaSoferiOcupati(){
        for(Sofer sofer : soferi){
            if(!sofer.getEsteLiber())
            {
                System.out.println(sofer);
            }
        }
    }

    public void afiseazaLocaluriCuBauturiAlcoolice(){
        List<Local> l = new ArrayList<>();
        for(Local local : localuri){
            Set<Produs> produse = local.getProduse().keySet();
            for(Produs produs : produse){
                if(produs instanceof Bautura && ((Bautura) produs).getEsteAlcoolica()){
                    l.add(local);
                }
            }
        }
        for(Local x : l){
            System.out.println(x.getNume());
        }
    }

    public User getUser(int id){
        for(User x : useri){
            if(x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    public List<User> getUseri(String nume){
        List<User> listaUseri = new ArrayList<>();
        for(User user : useri){
            if(user.getNume().equals(nume)){
                listaUseri.add(user);
            }
        }
        return listaUseri;
    }

    public void adaugaComanda(Comanda c){
        comenzi.add(c);
    }

    public Comanda getComanda(int id){
        for(Comanda comanda : comenzi){
            if (comanda.getId() == id){
                return comanda;
            }
        }
        return null;
    }

    public void stergeComanda(int id){
        comenzi.removeIf(x ->x.getId()==id);
    }

    public List<Comanda> getComenzi(String numeUser){
        List<Comanda> comenziUser = new ArrayList<>();
        for(Comanda comanda : comenzi){
            if(comanda.getUser().getNume().equals(numeUser)){
                comenziUser.add(comanda);
            }
        }
        return comenziUser;
    }

    public void asigneazaSofer(Comanda comanda) throws NoDriverException {
        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        int ora = calendar.get(Calendar.HOUR_OF_DAY);

        if(ora < 19 && ora > 13){
            if(soferi.size()>0){
                for(Sofer sofer : soferi){
                    if(sofer.getEsteLiber() &&
                            (sofer.getVehicul() instanceof Motocicleta ||
                                    sofer.getVehicul() instanceof Bicicleta ) ){
                        sofer.setEsteLiber(false);
                        comanda.setSofer(sofer);
                    }else if(sofer.getEsteLiber()){
                        comanda.setSofer(sofer);
                    }
                }
            }else{
                throw new NoDriverException("Nu exista soferi disponibili");
            }
        }else{
            boolean gasitSofer = false;
            for(Sofer sofer : soferi){
                if(sofer.getEsteLiber()){
                    sofer.setEsteLiber(false);
                    comanda.setSofer(sofer);
                    gasitSofer = true;
                    break;
                }
            }if(!gasitSofer){
                throw new NoDriverException("Nu exista soferi disponibili");
            }
        }

    }

}
