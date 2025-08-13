package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Estudante;

public class EstudanteTest02 {
    public static void main(String[] args) {
        Estudante estudante01 = new Estudante();
        Estudante estudante02 = new Estudante();

        estudante01.nome = "Icaro";
        estudante01.idade = 17;
        estudante01.sexo = 'M';

        estudante02.nome = "Rosana";
        estudante02.idade = 54;
        estudante02.sexo = 'F';

        estudante01.imprimi();
        estudante02.imprimi();
    }
}
