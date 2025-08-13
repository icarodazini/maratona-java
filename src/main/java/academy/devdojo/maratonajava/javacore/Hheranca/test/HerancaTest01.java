package academy.devdojo.maratonajava.javacore.Hheranca.test;

import academy.devdojo.maratonajava.javacore.Hheranca.dominio.Endereco;
import academy.devdojo.maratonajava.javacore.Hheranca.dominio.Funcionario;
import academy.devdojo.maratonajava.javacore.Hheranca.dominio.Pessoa;

public class HerancaTest01 {
    public static void main(String[] args) {
        Endereco endereco = new Endereco();
        Pessoa pessoa = new Pessoa("Icaro Dazini ");
        Funcionario funcionario = new Funcionario("Paulinho o loko");

        endereco.setRua("Rua Professor Pelino de Oliveira ");
        endereco.setCep("12345-678 ");

        pessoa.setCpf("15445633429 ");
        pessoa.setEndereco(endereco);
        pessoa.imprime();

        System.out.println("------------------");

        funcionario.setCpf("90123-456");
        funcionario.setEndereco(endereco);
        funcionario.setSalario(20000);
        funcionario.imprime();
    }
}
