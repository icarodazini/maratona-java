package academy.devdojo.maratonajava.javacore.Fmodificadorestatico.dominio;

public class Carro {
    private String nome;
    private double velocidadeMaxima;
    private static double velicidadeLimite = 250;

    public Carro(String nome, double velocidadeMaxima) {
        this.nome = nome;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public void imprime() {
        System.out.println("---------");
        System.out.println("Nome " + this.nome);
        System.out.println("Velicidade maxima " + this.velocidadeMaxima);
        System.out.println("Velocidade limite " + this.velicidadeLimite);
    }

    public static void setVelocidadeLimite(double velicidadeLimite){
        Carro.velicidadeLimite = velicidadeLimite;
    }
    public static double getVelocidadeLimite(){
        return Carro.velicidadeLimite;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }
}
