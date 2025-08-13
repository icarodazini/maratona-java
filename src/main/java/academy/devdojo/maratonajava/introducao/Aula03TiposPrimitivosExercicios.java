package academy.devdojo.maratonajava.introducao;
/*
Pratica
Crie variaveis para os campos descritos abaixo entre <> e imprima a seguinte mensagem:
Eu <nome>, morando no endereço <endereço>, confirmo que recebi o salario de <salario>, na data <data>
 */
public class Aula03TiposPrimitivosExercicios {
    public static void main(String[] args) {
        String nome = "Icaro";
        String endereco = "Rua Professor Pelino de Oliveira, Eldorado, JF";
        double salario = 2000;
        String dataRecebimentoSalario = "15/02/2025";

        String relatorio = "Eu "+ nome +", morando no endereço "+ endereco +", confirmo que recebi o salario de "+ salario +", na data "+ dataRecebimentoSalario +"";

        System.out.println(relatorio);

    }
}
