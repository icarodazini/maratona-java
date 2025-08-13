package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest02 {
    public static void main(String[] args) {
        // \d -> representa um dígito
        // \D -> representa um não dígito
        // \s -> representa um espaço em branco \t \n \f \r
        // \S -> representa um não espaço em branco
        // \w -> representa um caractere alfanumérico (a-zA-Z0-9_)
        // \W -> representa um não alfanumérico

        String regex = "\\S";
//        String texto = "abaaba";
        String texto2 = "h2 b@4 i!#r@ 2 n";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto2);
        System.out.println("Texto:  " + texto2);
        System.out.println("indice: 0123456789");
        System.out.println("Regex: " + regex);
        System.out.println("Posiçoes encontradas:");
        while (matcher.find()) {
            System.out.println("Posiçao: " + matcher.start() + " " + matcher.group() + " ");
        }
    }
}
