package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringBuilderTest01 {
    public static void main(String[] args) {
        String nome = "Icaro Dazini";
        nome.concat("DEVagar");
        nome.substring(0,3);
        System.out.println(nome);
        StringBuffer sb = new StringBuffer("Icaro Dazini");
        sb.append(" de Almeida").append(" DEVagar");
        sb.reverse();
        sb.reverse();
        sb.delete(0,4);
        System.out.println(sb);
    }
}
