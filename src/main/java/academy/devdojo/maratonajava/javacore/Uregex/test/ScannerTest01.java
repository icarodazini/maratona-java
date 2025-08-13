package academy.devdojo.maratonajava.javacore.Uregex.test;

import javax.xml.transform.Source;
import java.util.Scanner;

public class ScannerTest01 {
    public static void main(String[] args) {
        String texto = "Icaro,Carrilho,Heloisa,true,200";
        Scanner scanner = new Scanner(texto);
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int numero = scanner.nextInt();
                System.out.println("Número: " + numero);
            } else if (scanner.hasNextBoolean()) {
                boolean b = scanner.nextBoolean();
                System.out.println("Boolean: " + b);
            } else {
                System.out.println(scanner.next());
            }
        }
    }
}
