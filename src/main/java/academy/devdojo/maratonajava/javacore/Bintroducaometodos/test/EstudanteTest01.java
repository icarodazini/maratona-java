package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Estudante;
import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.ImpressoraEstudante;

public class EstudanteTest01 {
    public static void main(String[] args) {
        Estudante estudante01 = new Estudante();
        Estudante estudante02 = new Estudante();
        ImpressoraEstudante impressoraEstudante = new ImpressoraEstudante();

        estudante01.nome = "Icaro";
        estudante01.idade = 17;
        estudante01.sexo = 'M';

        estudante02.nome = "Rosana";
        estudante02.idade = 54;
        estudante02.sexo = 'F';

        impressoraEstudante.imprimir(estudante01);
        impressoraEstudante.imprimir(estudante02);

        System.out.println("----------------------");

        impressoraEstudante.imprimir(estudante01);
        impressoraEstudante.imprimir(estudante02);
    }
}
