package FileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader implements RW<Object> {
    private static Reader instance;


    public static Reader getInstance(){
        if(instance == null){
            instance = new Reader();
        }
        return instance;
    }

    public ArrayList<String[]> readFromFile(String path) throws IOException {
//        ArrayList<String> iesire = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        String row;
        ArrayList<String[]> iesire = new ArrayList<>();
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            iesire.add(data);
        }
        csvReader.close();
        return iesire;
    }

    private Reader(){}

    @Override
    public ArrayList<String[]> read(Object obj) {
        String path = System.getProperty("user.dir") + "\\src\\Useri.csv";

        switch (obj.getClass().getSimpleName()){
            case "User":
                path = System.getProperty("user.dir") + "\\src\\Useri.csv";
                break;
            case "Local":
                path = System.getProperty("user.dir") + "\\src\\Localuri.csv";
                break;
            case "Comanda":
                path = System.getProperty("user.dir") + "\\src\\Comenzi.csv";
                break;
            case "Sofer":
                path = System.getProperty("user.dir") + "\\src\\Soferi.csv";
                break;
            default:
        }

        try {
            return readFromFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
