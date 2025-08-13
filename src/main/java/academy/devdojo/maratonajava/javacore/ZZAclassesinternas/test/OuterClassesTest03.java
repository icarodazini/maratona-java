package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest03 {
    private String name = "Icaro";
    static class Nasted {
        private String lastName = "Dazini";
        void print(){
            System.out.println(new OuterClassesTest03().name + " " + lastName);
        }
    }

    public static void main(String[] args) {
        Nasted nasted = new Nasted();
        nasted.print();
    }
}
