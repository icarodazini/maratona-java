package academy.devdojo.maratonajava.javacore.Gassociacao.test;

import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Aluno;
import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Local;
import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Professor;
import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Seminario;

public class AssociacaoTest {
    public static void main(String[] args) {
        Local local = new Local("Rua Professor Pelino de Oliveira");
        Aluno aluno = new Aluno("Icaro de Almeida Dazini ", 17);
        Professor professor = new Professor(" Lucas Carrilho", "Desenvolvimento de Software");
        Aluno[] alunosParaSeminario = {aluno};

        Seminario seminario = new Seminario("Aprenda a programar aqui", alunosParaSeminario, local);

        Seminario[] seminariosDisponiveis = {seminario};

        professor.setSeminarios(seminariosDisponiveis);

        professor.imprime();
    }
}
