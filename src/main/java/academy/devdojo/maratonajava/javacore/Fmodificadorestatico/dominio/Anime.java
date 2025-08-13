package academy.devdojo.maratonajava.javacore.Fmodificadorestatico.dominio;

public class Anime {
    private String nome;
    private static int[] episodios;

    // 0 - Bloco de inicializaçao estatico é executado quando a JVM carregar a classe
    // 1 - Alocado espaço em memoria pro objeto
    // 2 - Caada atributo da classe é criado e inicializado com valores default ou o que for passado
    // 3 - Bloco de inicializaçao é excutado
    // 4 - Construtor é executado

    static {
        System.out.println("Dentro do bloco de inicalizaçao 1");
        episodios = new int[100];
        for (int i = 0; i < episodios.length ; i++) {
            episodios[i] = i+1;
        }
    }

    static {
        System.out.println("Dentro do bloco de inicalizaçao 2");
    }

    static {
        System.out.println("Dentro do bloco de inicalizaçao 3");
    }

    {
        System.out.println("Dentro do bloco de inicalizaçao nao estatico");

    }

    public Anime(String nome) {
        this.nome = nome;
    }

    public Anime() {


        for (int episodios: Anime.episodios){
            System.out.print(episodios + " ");
        }
        System.out.println();
    }

    public String getNome() {
        return nome;
    }

    public int[] getEpisodios() {
        return episodios;
    }
}
