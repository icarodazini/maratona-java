package academy.devdojo.maratonajava.javacore.Vio.test.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Vio.test.Ycolecoes.dominio.Smartphone;

public class EqualsTest01 {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("123456", "Samsung");
        Smartphone s2 = new Smartphone("123456", "Samsung");
        System.out.println(s1.equals(s2));
    }
}
