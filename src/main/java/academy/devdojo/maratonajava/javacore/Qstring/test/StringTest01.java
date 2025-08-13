package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringTest01 {
    public static void main(String[] args) {
        String nome = "Icaro "; // String constant pool
        String nome2 = "Icaro ";
        nome.concat(" Dazini"); // nome += " Dazini"
        System.out.println(nome);
        System.out.println(nome == nome2);
        String nome3 = new String("Icaro");
        System.out.println(nome2 == nome3);
        System.out.println(nome2 == nome3.intern());
    }
}
