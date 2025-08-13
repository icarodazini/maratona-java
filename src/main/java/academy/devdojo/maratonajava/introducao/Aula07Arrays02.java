package academy.devdojo.maratonajava.introducao;

public class Aula07Arrays02 {
    public static void main(String[] args) {
        //Byte, short, int, float, double 0
        //char '/u0000' ' '
        // boolean false
        // String null
        String[] nomes = new String[4];
        nomes[0] = "Icaro";
        nomes[1] = "Edson";
        nomes[2] = "Rosana";
        nomes[3] = "Eric";

        for (int i = 0; i < nomes.length; i++) {
            System.out.println(nomes[i]);
        }
    }
}
