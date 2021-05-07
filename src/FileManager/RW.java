package FileManager;

import java.util.ArrayList;

public interface RW<T extends Object>{
    default ArrayList<String[]> read(T obj) {
        return null;
    }
    default void write(T obj) {}
}
