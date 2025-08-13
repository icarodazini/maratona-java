package academy.devdojo.maratonajava.javacore.Eblocosinicializacao.dominio;

public class Anime {
    private String nome;
    private int[] episodios;

    // 1 - Alocado espaço em memoria pro objeto
    // 2 - Caada atributo da classe é criado e inicializado com valores default ou o que for passado
    // 3 - Bloco de inicializaçao é excutado
    // 4 - Construtor é executado

    {
        System.out.println("Dentro do bloco de inicalizaçao");
        episodios = new int[100];
        for (int i = 0; i < episodios.length ; i++) {
            episodios[i] = i+1;
        }
    }

    public Anime(String nome) {
        this.nome = nome;
    }

    public Anime() {


        for (int episodios: this.episodios){
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
