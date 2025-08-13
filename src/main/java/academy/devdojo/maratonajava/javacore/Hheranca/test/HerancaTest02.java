package academy.devdojo.maratonajava.javacore.Hheranca.test;

import academy.devdojo.maratonajava.javacore.Hheranca.dominio.Funcionario;

public class HerancaTest02 {
    // 0 - Bloco de inicializaçao estatico da superclasse é executado quando a JVM carregar a superclasse
    // 1 - Bloco de inicializaçao estatico da subclasse é executado quando a JVM carregar a subclasse
    // 2 - Alocado espaço em memoria pro objeto da superclasse
    // 3 - Caada atributo da superclasse é criado e inicializado com valores default ou o que for passado
    // 4 - Bloco de inicializaçao da superclasse é excutado na ordem em que aparece
    // 5 - Construtor é executado da superclasse
    // 6 - Alocado espaço em memoria pro objeto da subclasse
    // 7 - Caada atributo da subclasse é criado e inicializado com valores default ou o que for passado
    // 8 - Bloco de inicializaçao da subclasse é excutado na ordem em que aparece
    // 9 - Construtor é executado da subclasse
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Paulo bebado");
    }
}
