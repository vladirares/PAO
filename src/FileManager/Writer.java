package FileManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Aplicatie.Comanda;
import Aplicatie.Local;
import Aplicatie.Sofer;
import Aplicatie.User;

public class Writer implements RW<Object> {

    private static Writer instance;

    public static Writer getInstance(){
        if(instance == null){
            instance = new Writer();
        }
        return instance;
    }

    public void clear(String path) {
        try {
            FileWriter csvWriter = new FileWriter(path);
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void write(Object obj){
        String path = System.getProperty("user.dir") + "\\src\\Useri.csv";
        FileWriter csvWriter = null;

        switch (obj.getClass().getSimpleName()){
            case "User":
                path = System.getProperty("user.dir") + "\\src\\Useri.csv";
                try {
                    var obj2 = (User)obj;
                    csvWriter = new FileWriter(path,true);
                    csvWriter.append(obj2.getId()+",");
                    csvWriter.append(obj2.getNume()+",");
                    csvWriter.append(obj2.getAdresa()+"\n");
                    csvWriter.flush();
                    csvWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Local":
                path = System.getProperty("user.dir") + "\\src\\Localuri.csv";
                try {
                    var obj2 = (Local)obj;
                    csvWriter = new FileWriter(path,true);
                    csvWriter.append(obj2.getId()+",");
                    csvWriter.append(obj2.getNume()+"\n");
                    csvWriter.flush();
                    csvWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Comanda":
                path = System.getProperty("user.dir") + "\\src\\Comenzi.csv";
                try {
                    var obj2 = (Comanda)obj;
                    csvWriter = new FileWriter(path,true);
                    csvWriter.append(obj2.getId()+",");
                    csvWriter.append(obj2.getUser().getNume()+",");
                    csvWriter.append(obj2.getSofer().getNume()+"\n");
                    csvWriter.flush();
                    csvWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Sofer":
                path = System.getProperty("user.dir") + "\\src\\Soferi.csv";
                try {
                    var obj2 = (Sofer)obj;
                    csvWriter = new FileWriter(path,true);
                    csvWriter.append(obj2.getId()+",");
                    csvWriter.append(obj2.getNume()+",");
                    csvWriter.append(obj2.getVehicul().getClass().getSimpleName()+"\n");
                    csvWriter.flush();
                    csvWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
        }
    }

    private Writer(){}

}
