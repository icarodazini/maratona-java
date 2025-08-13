package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

import com.sun.security.jgss.GSSUtil;

import java.security.PublicKey;

public interface DataLoader {
    public static final int MAX_DATA_SIZE = 10;
    public abstract void loader();

    public default void checkPermission() {
        System.out.println("Fazendo checagem de permissoes");
    }

    public static void retrieveMaxDataSize(){
        System.out.println("Dentro do retrieveMaxDataSize na interface");
    }
}
