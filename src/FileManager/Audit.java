package FileManager;

import Aplicatie.User;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Audit {

    public static void writeToAudit(String nume){
        final String path = System.getProperty("user.dir") + "\\src\\Audit.csv";
        FileWriter csvWriter = null;
        try {
            csvWriter = new FileWriter(path,true);
            csvWriter.append("Thread:"+Thread.currentThread().getName()+","+ nume + ",");
            csvWriter.append(LocalDateTime.now().toString()+"\n");
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
