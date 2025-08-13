package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

public class RuntimeExceptionTest02 {
    public static void main(String[] args) {
        divisao(2,1);

        System.out.println("Código finalizado");
    }

    /**
     *
     * @param a
     * @param b
     * @return
     * @throws IllegalArgumentException caso b seja zero
     */

    private static int divisao(int a, int b){
        if (b == 0){
            throw new RuntimeException("Argumento ilegal, nao pode ser 0");
        }
        return a/b;
    }
}
