# Orientação a Objetos
- Foi criada para mapear o mundo real para o mundo computacional.
- Partir do principio que as informações podem ser agrupadas.
- Classe é o que nos temos no Java para representar algo do mundo real com funcionalidades em comum, como Pessoas. Classe = Template
- A classe terá atributos: 
Pessoas: Nome, Idade, Sexo

![[Pasted image 20250128171756.png]]
- Método main é o ponto de entrada para executar as classes.
- PackageDominio/Domain: Classes que representam a lógica do negócio/que vão para o banco de dados

## Criação de objetos dentro da PSVM

```java
package com.thisbeto.maratonajava.javacore.introducaoclasses.dominio;
public class Estudante {  
    public String nome;  
    public int idade;  
    public char sexo;  
  
}
```
- Dois pacotes diferentes
```java
package com.thisbeto.maratonajava.javacore.introducaoclasses.test;  
  
import com.thisbeto.maratonajava.javacore.introducaoclasses.dominio.Estudante;  
  
public class EstudanteTest01 {  
    public static void main(String[] args) {  
        Estudante estudante = new Estudante();  
        
		estudante.nome = "This";  
		estudante.idade = 21;  
		estudante.sexo = 'H';  
		System.out.println(estudante.nome);  
		System.out.println(estudante.idade);  
		System.out.println(estudante.sexo);  
    }
}
```

- Variável de referencia do tipo estudante, e para criar objetos é sempre necessário usar o "new" + o nome do objeto que será criado.
- Variável Estudante que faz referencia a um objeto, e graças a isso é possível acessar os atributos da classe.

## Coesão
- Não usar classes juntas. Por exemplo, embora Professor e Aluno sejam dois tipos, SEMPRE separar eles em classes diferentes. Assim como não colocar PSVM nessa classe.
- Ser especifico, ALTA COESÃO É BOM. Um propósito por Classe

## Referência de Objetos
- carro1 = carro2; Referencia de Objetos. Só pode fazer isso quando tem objetos do mesmo tipo
## Métodos

```java
public class Calculadora {  
    public void somaDoisNumeros(){  
        System.out.println(10 + 10);  
    }    public void subtraiDoisNumeros(){  
        System.out.println(21 - 2);  
    }
}
```

- Duas classes diferentes, no caso vai ser meio que puxado da outra classe a função a ser executada, que não necessariamente precisa ser printada.
```java
public class CalculadoraTest01 {  
    public static void main(String[] args) { 
     
        Calculadora calculadora = new Calculadora();  
        calculadora.somaDoisNumeros();  
        System.out.println("Finalizando CalculadoraTest01");  
        calculadora.subtraiDoisNumeros();  
    
    }
}
```

## Parâmetros 
- Variáveis locais dentro de um método. 
```java
public class Calculadora {  
    public void multiplicaDoisNumeros(int num1, int num2){  // PARAMETRO É AQUI
    System.out.println(num1 * num2);  
}
```

```java
public class CalculadoraTest02 {  
    public static void main(String[] args) {  
        Calculadora calculadora = new Calculadora();  
        calculadora.multiplicaDoisNumeros(10,20);  // ARGUMENTO É AQUI, VAI PRECISAR COLOCAR NUMEROS PARA ATRIBUIR VALORES AO INT 1 E INT 2
    }
}
```

## Retorno

```java
public double divideDoisNumeros(double num1, double num2){  
    if(num2 == 0) {  
        return 0;  
    }    return num1/num2;  
}
```

```java
public class CalculadoraTest03 {  
    public static void main(String[] args) {  
        Calculadora calculadora = new Calculadora();  
        double result = calculadora.divideDoisNumeros(20,2);  
        System.out.println(result);  
    }
}
```

```java
public void imprimeDivsaoDeDoisNumeros(double num1, double num2) {  
    if (num2 == 0) {  
        System.out.println("Não existe divisão por 0");  
        return; // Esse return vai voltar pro CalculadoraTest03 e caso o num2 seja igual a 0 e nem vai executar o sout abaixo  
    }  
    System.out.println(num1/num2);  
}
```

## Parâmetros tipo primitivo 

- Quando estamos passando variáveis do tipo primitivo, a variável original nunca vai ser alterada. No caso a variável que estava num1 e num2 não vai mudar porque está sendo passada uma copia dos valores, então ela vai sempre continuar lá.

```java
public void alteraDoisNumeros(int num1, int num2){  
        num1 = 99;  
        num2 = 33;  
        System.out.println("Dentro do alteraDoisNumeros");  
        System.out.println("Num1 " +num1);  
        System.out.println("Num2 " +num2);  
    }
}

public class CalculadoraTest04 {  
    public static void main(String[] args) {  
        Calculadora calculadora = new Calculadora();  
        int num1 = 1;  
        int num2 = 2;  
        calculadora.alteraDoisNumeros(num1,num2);  
        System.out.println("Dentro CalculadoraTest04");  
        System.out.println("Num1 " +num1);  
        System.out.println("Num2 " +num2);  
    }
}
/*Dentro do alteraDoisNumeros
Num1 99
Num2 33
Dentro CalculadoraTest04
Num1 1
Num2 2
*/
```

## Parâmetros tipo referência

- O objeto não está presente na Impressora porque ele vai ver na chamada do método como argumento
- Quando chamo a impressora ele vai fazer referencia ao que estiver ali, seja o 01 ou 02. Não vai ser padrão, quando ele termina a ação de imprimir ele desvincula essa referencia e ja parte pra conexão com o 02 
```java
public class ImpressoraEstudante {  
    public void imprime(Estudante estudante) {  
        System.out.println("------------");  
        System.out.println(estudante.nome);  
        System.out.println(estudante.idade);  
        System.out.println(estudante.sexo);  
  
    }
}

public class EstudanteTest01 {  
    public static void main(String[] args) {  
        Estudante estudante01 = new Estudante();  
        Estudante estudante02 = new Estudante();  
        ImpressoraEstudante impressora = new ImpressoraEstudante();  
        estudante01.nome = "Betão";  
        estudante01.idade = 25;  
        estudante01.sexo = 'H';  
  
        estudante02.nome = "Giane";  
        estudante02.idade = 20;  
        estudante02.sexo = 'M';  
  
        impressora.imprime(estudante01);  
        impressora.imprime(estudante02);
/*Dentro do alteraDoisNumeros
Num1 99
Num2 33
Dentro CalculadoraTest04
Num1 1
Num2 2
*/
```
- Quando alteramos algo dentro do objeto, nos mantemos essas alterações pras outras referencias que tem relação com aquele objeto. Não alterar no método.

## Referencia This
- Serve para referenciar alguma variável, como nesse exemplo dentro da classe. Vendo isso, da pra perceber que não é necessário criar a referencia ali.
```java
public class Estudante {  
    public String nome;  
    public int idade;  
    public char sexo;  
  
    public void imprime(){  
        System.out.println("----------------");  
        System.out.println(this.nome);  
        System.out.println(this.idade);  
        System.out.println(this.sexo);  
    }
}
```

## Varargs
- Sintaxe criada para facilitar algumas chamadas de arrays. Quando você vai chamar, tu consegue modificar o valor dele 

```java
public void somaVarArgs(int... numeros){  
    int soma = 0;  
    for (int num: numeros) {  
        soma += num;  
    }    System.out.println(soma);  
}


//DEPOIS PRINTANDO:
calculadora.somaVarArgs(1,2,3,4,5,6,7,8,9);
```

## Modificador de acesso private, get e set

- Modificadores de acesso privado só vão poder ser acessados pelo objeto. Quando criamos atributos privados, precisamos de uma "camada" para acessá-los, usando assim o set e o get.
- É possível gerar automaticamente isso dentro da IDE com alt + insert.
- Bom em situações que você quer chamar um valor e criar uma variável mas não quer que ela seja modificada.
```java
public class Pessoa {  
    private String nome;  
    private int idade;  
  
    public void setNome(String nome){  
        this.nome = nome;  
    }  
    public void setIdade(int idade){  
        if (idade < 0) {  
            System.out.println("Idade inválida");  
            return;  
        }        this.idade = idade;  
    
    }    public String getNome(){  
        return this.nome;  
    }    public int getIdade(){  
        return this.idade;  
    }
```

```java
public class PessoaTest01 {  
    public static void main(String[] args) {  
        Pessoa pessoa = new Pessoa();  
        pessoa.setNome("Peter Parker");  
        pessoa.setIdade(18);  
 
        System.out.println(pessoa.getNome());  
        System.out.println(pessoa.getIdade());  
    }
}
```

## Sobrecarga de métodos
- Dois métodos com o mesmo nome, mas a quantidade/tipos dos parâmetros DIFERENTES.
``` java
public class Anime {  
    private String nome;  
    private String tipo;  
    private int episodios;  
    private String genero;  
  
    public void init(String nome, String tipo, int episodios) {  
        this.nome = nome;  
        this.tipo = tipo;  
        this.episodios = episodios;  
    }  
    public void init(String nome, String tipo, int episodios, String genero){  
        this.init(nome, tipo, episodios);  
        this.genero = genero;  
    }
```

## Construtores
- Sempre estão presente nos .class. No entanto, se a gente não adiciona manualmente, o JAVA adiciona automaticamente. Em TODOS os métodos eles estão presentes.
- A vantagem deles é que eles te FORÇAM a seguir algumas regras. Como a obrigatoriedade de ter um nome, por exemplo.
- Ele sempre vai ser a primeira coisa a ser executada no .class
- É possível sobrecarregá-lo também igual fizemos com os métodos.

``` java
public Anime(String nome, String tipo, int episodios, String genero) {  
    this.nome = nome;  
    this.tipo = tipo;  
    this.episodios = episodios;  
    this.genero = genero;  
}  
  
public Anime(String nome, String tipo, int episodios, String genero, String estudio) {  
    this(nome,tipo,episodios,genero);  
    this.estudio = estudio;  
}
```
- Se adicionar VOID, NÃO É CONSTRUTOR! Vira um método.
- No caso o que vai aparecer primeiro vai ser o DE BAIXO, que ta fazendo referencia com aquele `this(nome,tipo,epsodios,genero);` pro de cima.

## Blocos de inicialização
- A inicialização dos objetos acontecem antes mesmo da execução do construtor.
- É um bloco que pode ser colocado em qualquer lugar do código que vai ser executado toda vez que você executar uma instancia desse objeto.
0 - Bloco de inicialização é executado quando a JVM carregar a classe
1 - Alocado espaço em memoria pro objeto  
2 - Cada atributo de classe é criado e inicializado com valores default o o que for passado  
3 - Bloco de inicialização é executado  
4 - Construtor é executado  
- A principal diferença é que o bloco é executado independente do construtor chamado
- Nesse exemplo, já que eu to chamando o nome do anime e ele não tem nenhum episodio, ele vai printar como nulo. 
``` java
{  
    System.out.println("Dentro do bloco de inicialização");  
    episodios = new int[100];  
    for (int i = 0; i < episodios.length; i++) {  
        episodios[i] = i+1;  
}
```

## Modificador Static
- Modificador de acesso Static vai fazer o atributo pertencer a classe, e todos os outros objetos vão compartilhar do mesmo valor.
- Ao alterar de uma estancia, será alterada de todos os objetos em existência dessa classe.
``` java
public class Carro {  
     private String nome;  
     private double velocidadeMaxima;  
     public static double velocidadeLimite = 250;  
  
    public Carro(String nome, double velocidadeMaxima) {  
        this.nome = nome;  
        this.velocidadeMaxima = velocidadeMaxima;  
    }
}

public class CarroTest01 {  
    public static void main(String[] args) {  
        Carro c1 = new Carro("BMW",280);  
        Carro c2 = new Carro("Mercedes",275);  
        Carro c3 = new Carro("Audi",290);  
        Carro.velocidadeLimite = 180;  // ALTERA DE TODOS OS OBJETOS.
        c1.imprime();  
        c2.imprime();  
        c3.imprime();  
    }
```

## Métodos Estáticos
- NÃO é possível usar dentro de métodos estáticos variáveis que NÃO SEJAM estáticas. Porém, o contrário é possível.
- É recomendado usar método estático quando os métodos não acessam um atributo/variável da instancia. 
``` java
public static void setVelocidadeLimite(double velocidadeLimite) {  
   Carro.velocidadeLimite = velocidadeLimite;  
}  
  
public static double getVelocidadeLimite(){  
   return velocidadeLimite;  
}
```

## Blocos de inicialização estático
- Ao colocar static no episódios, ele vai pertencer a classe Anime, independente da quantidade de objetos criados, será um valor só para todos eles.
- Com atributos estáticos não faz sentido usar this. O certo é usar o nome da classe .atributo estático.
- Para não repetir mais de uma vez, mesmo eu criando vários objetos, o bloco estático vem pra isso.
- No caso, ele tem a mesma inicialização no mesmo momento, por isso o sout não se repetiria.
- A ordem é muito importante de se lembrar. Importante perceber que se tentar acessar nome dentro do bloco de inicialização não será possível porque ainda não foi alocado espaço pro objeto que não é estático.
- Se tiver mais de um bloco estático, eles serão executados na ordem em que aparecem, apenas uma vez.

``` java
public static void setVelocidadeLimite(double velocidadeLimite) {  
   Carro.velocidadeLimite = velocidadeLimite;  
}  
  
public static double getVelocidadeLimite(){  
   return velocidadeLimite;  
}
```

**0 - Bloco de inicialização é executado quando a JVM carregar a classe** *ISSO ACONTECE ANTES DE QUALQUER COISA!*
1 - Alocado espaço em memoria pro objeto  
2 - Cada atributo de classe é criado e inicializado com valores default o o que for passado  
3 - Bloco de inicialização é executado  
4 - Construtor é executado  

## Associação
### Arrays com Objetos
- A variável de referencia jogadores faz referencia ao Array com 3 posições. 
- As variáveis jogador1, 2 e 3 existem separadamente. Cada um deles faz referencia a um objeto em memória. 

![[Pasted image 20250203230100.png]]

``` java
public class Jogador {  
    private String nome;  
  
    public void imprime(){  
        System.out.println(this.nome);  
    }  
    public Jogador(String nome) {  
        this.nome = nome;  
    }
```

``` java
public class JogadorTest01 {  
    public static void main(String[] args) {  
        Jogador jogador1 = new Jogador("Neymar");  
        Jogador jogador2 = new Jogador("Messi");  
        Jogador jogador3 = new Jogador("Cristiano Ronaldo");  
        Jogador[] jogadores = {jogador1,jogador2,jogador3}; 
          
        for (Jogador jogador: jogadores){  
            jogador.imprime();  
        }  
    }
}
```

### Associação unidirecional um para muitos

- **Um pra um:** Jogador 1 -- 1 Time
- O setTime que está dentro do Jogador vai fazer referencia ao objeto time criado, que se refere a classe Time mesmo.

``` java  
public class Jogador {  
    private String nome;  
    private Time time;  
  
    public void imprime(){  
        System.out.println(this.nome);  
        if(time != null){  
            System.out.println(time.getNome());  
        }    }  
    public Jogador(String nome) {  
        this.nome = nome;  
    }  
    public Time getTime() {  
        return time;  
    }  
    public void setTime(Time time) {  
        this.time = time;  
    }  
    public String getNome() {  
        return nome;  
    }  
    public void setNome(String nome) {  
        this.nome = nome;  
    }}
```

``` java   
public class Time {  
    private String nome;  
  
    public Time(String nome) {  
        this.nome = nome;  
    }  
    public String getNome() {  
        return nome;  
    }  
    public void setNome(String nome) {  
        this.nome = nome;  
    }}
```

``` java
public class JogadorTest02 {  
    public static void main(String[] args) {  
        Jogador jogador1 = new Jogador("Neymar");  
        Time time = new Time("Santos");  
  
        jogador1.setTime(time);  
        jogador1.imprime();  
    }}
```


### Associação unidirecional muitos para um
- **Um pra muitos:** Escola 1 -- N Profesores

``` java
public class Escola {  
    private String nome;  
    private Professor[] professores;  
  
    public Escola(String nome) {  
        this.nome = nome;  
    }  
    public Escola(String nome, Professor[] professores) {  
        this.nome = nome;  
        this.professores = professores;  
    }  
    public void imprime(){  
        System.out.println(this.nome);  
        if(professores == null) return;  
        for (Professor professor : professores) {  
            System.out.println(professor.getNome());  
        }  
    }  
    public String getNome() {  
        return nome;  
    }  
    public void setNome(String nome) {  
        this.nome = nome;  
    }  
    public Professor[] getProfessores() {  
        return professores;  
    }  
    public void setProfessores(Professor[] professores) {  
        this.professores = professores;  
    }}

```

``` java
public class Professor {  
    private String nome;  
  
    public Professor(String nome) {  
        this.nome = nome;  
    }  
    public String getNome() {  
        return nome;  
    }  
    public void setNome(String nome) {  
        this.nome = nome;  
    }  
}
```

``` java
public class EscolaTest01 {  
    public static void main(String[] args) {  
        Professor professor1 = new Professor("Cesar");  
        Professor professor2 = new Professor("Mario");  
        Professor[] professores = {professor1, professor2};  
        Escola escola = new Escola("ILV", professores);  
  
        escola.imprime();  
  
    }
```

### Associação bidirecional

- **Muitos pra um:** 1 Time -- N Jogadores

![[Pasted image 20250204172229.png]]

``` java
public class Time {  
    private String nome;  
    private Jogador[] jogadores;  
  
    public Time(String nome) {  
        this.nome = nome;  
    }  
    public Time(String nome, Jogador[] jogadores) {  
        this.nome = nome;  
        this.jogadores = jogadores;  
    }  
    public void imprime(){  
        System.out.println(this.nome);  
        if (jogadores == null) return;  
        for (Jogador jogador: jogadores) {  
            System.out.println(jogador.getNome());  
        }   
    }  
    public Jogador[] getJogadores() {  
        return jogadores;  
    }  
    public void setJogadores(Jogador[] jogadores) {  
        this.jogadores = jogadores;  
    }  
    public String getNome() {  
        return nome;  
    }  
    public void setNome(String nome) {  
        this.nome = nome;  
    }}

```


```java
public class Jogador {  
    private String nome;  
    private Time time;  
  
    public void imprime(){  
        System.out.println(this.nome);  
        if(time != null){  
            System.out.println(time.getNome());  
        }    }  
    public Jogador(String nome) {  
        this.nome = nome;  
    }  
    public Time getTime() {  
        return time;  
    }  
    public void setTime(Time time) {  
        this.time = time;  
    }  
    public String getNome() {  
        return nome;  
    }  
    public void setNome(String nome) {  
        this.nome = nome;  
    }}
```

```java
public class JogadorTest03 {  
    public static void main(String[] args) {  
        Jogador jogador = new Jogador("Borré");  
        Jogador jogador2 = new Jogador("L.D");  
        Time time = new Time("Internacional");  
        Jogador[] jogadores = {jogador, jogador2};  
  
        jogador.setTime(time);  
        jogador2.setTime(time);  
        time.setJogadores(jogadores);  
  
        System.out.println("--- Jogador ---");  
  
        jogador.imprime();  
  
        System.out.println("--- Time ---");  
  
        time.imprime();  
    }}

```


- **Muitos pra muitos:** Estudante N -- N Curso



## Leitura de dados pelo console
``` java
public class LeituraDoTecladoTest01 {  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
        System.out.println("Digite seu nome: ");  
        String nome = input.nextLine();  
        System.out.println("Digite sua idade: ");  
        int idade = input.nextInt();  
        System.out.println("Digite M ou F para seu sexo: ");  
        char sexo = input.next().charAt(0);  
  
        System.out.println("----------");  
        System.out.println("Nome: " +nome);  
        System.out.println("Idade: " +idade);  
        System.out.println("Sexo: " +sexo);  
    }
}
```

## Herança
- Quando falamos em herança, falamos sobre a extensão de funcionalidades de alguma classe, mantendo o relacionamento entre elas.
- Pessoa é genérico, o funcionário É uma pessoa porem com alguns campos mais especializados

`public class Funcionario extends Pessoa`

- Quando colocamos o extends, estamos querendo dizer que Funcionário vai ter todos os atributos e métodos que Pessoa tem, porque o Funcionário É uma Pessoa.
- NÃO EXISTE MAIS DE UMA HERANÇA!
### Super Classe
- Sobre escrita: É possível escrever o método com a mesma assinatura da Classe Mãe (Pessoa) dentro do Funcionário. Nisso, as alterações que eu fizer ali vão acontecer quando executar o objeto funcionário. Ele atua como um método sobrecarregado, então o nome precisa ser igual ao original.
- Para executar TUDO o que está no metodo original + com as adições que eu quero colocar, eu vou chamar o "super". Toda as vezes que usar a palavra super, estamos nos referindo ao objeto genérico.

``` java
public class Funcionario extends Pessoa {  
    private double salario;  
  
    @Override  
    public void imprime() {  
        super.imprime();  
        System.out.println(this.salario);  
    }
``` 

### Protected
- Qualquer SUBCLASSE em QUALQUER pacote vai ter acesso aos atributos como se tivesse o atributo dentro da própria classe.
- Protected = Acesso direto a variável a todas as subclasses independente de onde elas tiverem, porem todas as classes que estão no mesmo pacote também terão acesso.

### Construtores
- Agora ao criar uma pessoa, o construtor mostra a OBRIGATORIEDADE de passar um nome.
- Como agora o construtor força Pessoa a ter um nome, a classe Funcionário que estendida vai ter que ter um nome também.
``` java
public class Pessoa {  
    protected String nome;  
    protected String cpf;  
    protected Endereco endereco;  
  
    public Pessoa(String nome){  
        this.nome = nome;  
    }  
    public Pessoa(String nome, String cpf){  
        this(nome);  
        this.cpf = cpf;  
    }
```

``` java
public class Funcionario extends Pessoa {  
    private double salario;  
  
    public Funcionario(String nome){  
        super(nome);  
    }
``` 

- Se você tem um construtor na Super Classe e não existe nenhum outro construtor na Sub classe, é necessário criar um construtor que vai atender os requisitos para criar o objeto da Super Classe.
- No caso de cima, Pessoa OBRIGATORIAMENTE precisa de um nome e como funcionário é uma pessoa, é preciso também pedir o nome com o super(nome)
- RESUMO: Todas as vezes que adicionar um construtor na Classe Mãe, esse construtor terá um ARGUMENTO. OBRIGATORIAMENTE você precisa alterar em todas as classes filhas.

### Sequência de Inicialização 
- Quando temos Herança, a Super Classe SEMPRE precisa ser inicializada primeira. Porque teoricamente precisamos das informações da Classe Mãe primeiro.

`Dentro do bloco de inicialização estático de Pessoa`
`Dentro do bloco de inicialização estático de Funcionário`
`Dentro do bloco de inicialização de Pessoa 1`
`Dentro do bloco de inicialização de Pessoa 2`
`Dentro do construtor de Pessoa`
`Dentro do bloco de inicialização de Funcionário 1`
`Dentro do bloco de inicialização de Funcionário 2`
`Dentro do construtor de Funcionário`


0 - Bloco de inicialização estático da SUPER CLASSE é executado quando a JVM carregar a SUPER CLASSE
1 - Bloco de inicialização estático da SUB CLASSE é executado quando a JVM carregar a SUB CLASSE
2 - Alocado espaço em memoria pro objeto da SUPER CLASSE
3 - Cada atributo da SUPER CLASSE é criado e inicializado com valores default o o que for passado da SUPER CLASSE
4 - Bloco de inicialização da SUPER CLASSE é executado na ordem em que aparecem
5 - Construtor da SUPER CLASSE é executado  
6 - Alocado espaço em memoria pro objeto da SUB CLASSE
7 - Cada atributo da SUB CLASSE é criado e inicializado com valores default o o que for passado da SUB CLASSE
8 - Bloco de inicialização da SUB CLASSE é executado na ordem em que aparecem
9 - Construtor da SUB CLASSE é executado  

## Sobrescrita do método toString
- O método `toString()` em Java retorna uma representação textual de um objeto. Quando sobrescrito, ele pode exibir os valores dos atributos do objeto de forma legível.
- Ele é estendido do Objeto, puxando os valores diretos sem precisar usar um get, por exemplo.

## Modificador final
### Tipo primitivo
- São constantes em que NÃO PODEM ter o valor alterado uma vez que esse valor foi associado, geralmente vai vir acompanhado do método estático.
- Uma vez que associado o valor, não é possível alterar no código.

`public static final double VELOCIDADE_LIMITE = 250;`

### Tipo referência
- A referencia dessa variável comprador tem para esse objeto NUNCA poderá ser alterada
`private final Comprador COMPRADOR = new Comprador();`
- Isso significa que, depois que a referência `COMPRADOR` foi inicializada com `new Comprador()`, você **não pode mudar essa referência** para outro objeto, mas **pode modificar os atributos internos** do objeto.
- Variáveis de referencias quando são finais, o que não da para alterar é a referencia para o objeto.
- Tem relação com Singleton pattern (Estudar depois)

### Classes e métodos
- Lida diretamente com herança.
- Quando não queremos estender uma classe, colocamos final nela. Não vai deixar puxar.
- String é um tipo de classe final.
- Quando colocamos um final em métodos, ele nunca poderá ser sobrescrito. O comportamento definido por ele na superclasse vai ser padrão para todo mundo. 
- Não poderá ser sobrecarregado.

## Enumeração
- Tipo de classe em que todos os atributos criados serão constantes. Um exemplo bom de entender é com o Tipo Cliente, ou de Dias da Semana. Vai depender muito do caso. Usar quando for necessário fazer uma escolha dentro de uma quantidade limitada de opções e nos precisamos forçar um tipo para ser utilizado.

``` java
//Chamei o tipoCliente primeiro

public class Cliente {  
    private String nome;  
    private TipoCliente tipoCliente;  
  
    public Cliente(String nome, TipoCliente tipoCliente) {  
        this.nome = nome;  
        this.tipoCliente = tipoCliente;  
    }
 
// Depois foi criada a classe Enum com o tipoCliente

public enum TipoCliente {  
    PESSOA_FISICA,  
    PESSOA_JURIDICA  
}

// Depois foi chamada o tipoCliente no construtor

public class ClienteTest01 {  
    public static void main(String[] args) {  
        Cliente cliente1 = new Cliente("Sasuke", TipoCliente.PESSOA_FISICA);  
        Cliente cliente4 = new Cliente("Naruto",TipoCliente.PESSOA_JURIDICA);

```

### Construtores e atributos
- É possível criar um enum dentro de uma classe mesmo, no entanto fica meio bagunçado.

``` java
public class Cliente {  
    public enum TipoPagamento {  
        DEBITO, CREDITO  
    }  
    private String nome;  
    private TipoCliente tipoCliente;  
    private TipoPagamento tipoPagamento;  
   }
   ```

- Não se faz muito útil, porque fica meio bagunçado.
- É possível criar atributos dentro de um enum e atribuir valores a ele, como fizemos no exemplo. Podemos usar construtores para isso e definir isso, da mesma forma que usar get.
```java
public enum TipoCliente {  
    PESSOA_FISICA(1, "Pessoa Física"),  
    PESSOA_JURIDICA(2, "Pessoa Jurídica");  
  
    public String nomeRelatorio;  
    public final int VALOR;  
  
    TipoCliente (int valor, String nomeRelatorio) {  
        this.VALOR = valor;  
        this.nomeRelatorio = nomeRelatorio;  
    }
}
``` 

### Sobrescrita de métodos
- Conseguimos sobrescrever métodos dentro de enum para não usar tantos IF's.
- No caso, foi sobrescrito dentro de Débito e Crédito.
- Já que nosso método calcularDesconto não tem nenhum comportamento, ele pode se tornar abstrato, por que não está sendo chamado diretamente.
``` java 
public enum TipoPagamento {  
    DEBITO {  
        @Override  
        public double calcularDesconto(double valor) {  
            return valor * 0.1;  
        }    
        }, CREDITO {  
        @Override  
        public double calcularDesconto(double valor) {  
            return valor * 0.05;  
        }    
    };  
    
    public abstract double calcularDesconto(double valor);  
    
}
``` 

###  Busca por atributos
- Exemplo: Temos um nome de um relatório (String) e queremos pegar o número baseado nela.
- Usamos o value e iteramos com um for para buscar

``` java 
public static TipoCliente tipoClientePorNomeRelatorio(String nomeRelatorio) {  
    for (TipoCliente tipoCliente : values()) {  
        if(tipoCliente.getNomeRelatorio().equals(nomeRelatorio)){  
            return tipoCliente;  
        }    }    return null;  
}

TipoCliente tipoCliente = TipoCliente.valueOf("PESSOA_FISICA");  
// Aqui se deixar diferente ele vai dar errado porque o valueOf retorna no nome  
System.out.println(tipoCliente);  
TipoCliente tipoCliente2 = TipoCliente.tipoClientePorNomeRelatorio("Pessoa Física");  
// Estamos devolvendo "Pessoa física" que é um atributo e ele vai nos devolver o nome do objeto, que é PESSOA_FISICA  
System.out.println(tipoCliente2);

```

##  Classes Abstratas
- Quando colocamos uma classe com abstract, estamos setando aquela classe como um "template", a qual DEVERÁ ser estendida para as demais.
- Será uma SUPER CLASSE.
- Não é possível criar um objeto de uma classe abstrata.
- Não deve confundir com o FINAL, pois elas tem sentidos OPOSTOS.

``` java 
// Funcionário é a nossa classe abstrata e nosso template
public abstract class Funcionario {  
    protected String nome;  
    protected double salario;  
  
    public Funcionario(String nome, double salario) {  
        this.nome = nome;  
        this.salario = salario;  
    }   
 }
```

``` java
// Gerente é a subclasse, a qual eu vou estender funcionário e vou poder criar uma subclasse. Vou poder criar um new objeto a partir dela.
public class Gerente extends Funcionario{  
    public Gerente(String nome, double salario) {  
        super(nome, salario);  
    }
```

###  Métodos Abstratos
- Não é possível ter um método abstrato em uma classe concreta (que não é abstrata).
- Mas uma classe abstrata pode ter ambos.
- Podemos utilizar quando quisermos obrigar todas as subclasses a proverem uma implementação de um método.
- O calculaBonus funciona no estilo de uma sinalização, de que quando estendermos a classe funcionário (para Gerente, Caixa, Desenvolvedor), devemos implementar lá dentro o bônus individual dele.
- O cálculo do calculaBonus vai ser baseado do que está dentro do objeto.
- Sempre será necessário SOBRESCREVER O MÉTODO (usar o override), mesmo que fique vazio.
```java
public abstract class Funcionario {  
    protected String nome;  
    protected double salario;  
  
    public Funcionario(String nome, double salario) {  
        this.nome = nome;  
        this.salario = salario;  
        calculaBonus();  
    }  
    public abstract void calculaBonus();  
}
```

``` java
public class Desenvolvedor extends Funcionario{  
    public Desenvolvedor(String nome, double salario) {  
        super(nome, salario);  
    }  
    @Override  
    public void calculaBonus() {  
        this.salario = salario + salario * 0.05;  
    }
}
```

### Métodos abstratos regras
- Se você tiver uma classe abstrata e estender ela em outra classe abstrata, ela não será obrigada a implementar os métodos. MAS, se tiver mais subclasses envolvidas (se elas forem concretas), será necessário chamar nelas.
- No entanto, ao fazer a sobrescrita na classe abstrata estendida, ela já resolve o problema das classes filhas.

```java
public abstract class Pessoa {  
    public abstract void imprime();  
}

public abstract class Funcionario extends Pessoa {  
    protected String nome;  
    protected double salario;  
  
    public Funcionario(String nome, double salario) {  
        this.nome = nome;  
        this.salario = salario;  
        calculaBonus();  
    }  
    public abstract void calculaBonus();  
  
    @Override  
    public void imprime() {  
        System.out.println("Imprimindo...");  
    }}
```

##  Interfaces
- São bem parecidas com classes abstratas.
- Dentro da interface do Java, todos os métodos são públicos e abstratos.
- Não utilizamos extends, e sim implements

```java
public interface DataLoader {  
    void load();  
}

public class DataBaseLoader implements DataLoader {  
    @Override  
    public void load() {  
        System.out.println("Carregando dados do banco de dados");  
    }
}
```

### Implementando múltiplas interfaces
- Usando implements, é possível estender várias interfaces.
- Interfaces podem ter métodos com implementação, os quais não precisam estar inicializados em todas as subclasses, podendo ter um valor padrão.
- É possível também alterar esse valor, assim como nas abstratas. Basta chamar o método dentro da classe e seria sobrescrito.
```java
public interface DataLoader {  
    void load();  
  
    default void checkPermission(){  
        System.out.println("Fazendo checagem de permissões");  
    }
}
```

### Atributos e métodos estáticos
private -> default -> protected -> public
- Por padrão, todos os atributos em uma interface são constantes.
- A partir do Java 8, temos a possibilidade de adicionar métodos estáticos (não serão sobrescritos)
## Polimorfismo
- Explicando Polimorfismo, usando elementos do mundo real, nós temos um controle da TV que consegue acessar ambas TVS, seja a do modelo de 2019 e 2020. No entanto, a função Youtube NÃO conseguimos acessar, somente as que estão presentes no nosso controle
![[Pasted image 20250219224550.png]]
- A garantia que a herança dá é que todos os atributos da super classe podem ser chamados na subclasse porque eles serão herdados. O nome disso é Widening Cast.
![[Pasted image 20250219225358.png]]
- Polimorfismo também possibilita o uso de métodos genéricos que deixam o código mais limpo e com maior facilidade de escalabilidade.

```java
public class CalculadoraImposto {  
  
    public static void calcularImposto(Produto produto){  
        System.out.println("Relatório de imposto");  
        double imposto = produto.calcularImposto();  
        System.out.println("Produto: "+produto.getNome());  
        System.out.println("Preço: "+produto.getValor());  
        System.out.println("Imposto a ser pago: "+imposto);  
    }  
}

public class ProdutoTest01 {  
    public static void main(String[] args) {  
        Computador computador = new Computador("NUC10i7", 5000);  
        Tomate tomate = new Tomate("Tomate DevDojo", 10);  
        Televisao tv = new Televisao("Samsung 50 pol", 4000);  
  
        CalculadoraImposto.calcularImposto(computador);  
        System.out.println("------------");  
        CalculadoraImposto.calcularImposto(tomate);  
        System.out.println("------------");  
        CalculadoraImposto.calcularImposto(tv);  
    }}
```

Widening cast -> Caminho mais amplo, passando de um objeto mais espficifico para um objeto mais genérico.

O que precisamos fazer para acessar a dataValidade do tomate é o contrário do widening, também conhecido como narrowing cast. Quando colocamos tomate entre parênteses, no caso criamos ali uma nova variável de referencia e fazemos um cast como se fosse um tipo primitivo. No caso, o produto não saberia qual produto selecionar, mas nós avisamos o Java que é o tomate.

- O **`instanceof`** é um operador usado para verificar se um objeto é uma instância de uma classe ou de uma de suas subclasses. Ele é comumente utilizado para garantir que um objeto seja do tipo esperado antes de realizar algum tipo de operação sobre ele.

```java
public class CalculadoraImposto {  
  
    public static void calcularImposto(Produto produto){  
        System.out.println("Relatório de imposto");  
        double imposto = produto.calcularImposto();  
        System.out.println("Produto: "+produto.getNome());  
        System.out.println("Preço: "+produto.getValor());  
        System.out.println("Imposto a ser pago: "+imposto);  
        if (produto instanceof Tomate) {  
            Tomate tomate = (Tomate) produto; // ((Tomate) produto).getDataValidade();  
            System.out.println(tomate.getDataValidade());  
        }    }  
}

public class ProdutoTest03 {  
    public static void main(String[] args) {  
        Produto produto = new Computador("Ryzen 9", 3000);  
  
  
        Tomate tomate = new Tomate("Americano",20);  
        tomate.setDataValidade("11/11/2011");  
  
        CalculadoraImposto.calcularImposto(tomate);  
    }}
```

Programação orientada a interface também se resume a uma maneira mais simples de acessar as interfaces. 
```java
RepositorioBancoDeDados repositorioBancoDeDados = new RepositorioBancoDeDados();
repositorioBancoDeDados.salvar();
```
Esse código não é escalável, e caso eu precise trocar, teria que alterar todo o objeto e a declaração.
```java
Repositorio repositorio = new RepositorioMemoria();  
repositorio.salvar();
```
Como o repositório é uma interface e possuiu o método salvar, é possível alterar qualquer um dos objetos que possuam o método salvar dentro de si. O que facilita, onde só é necessário trocar qual objeto quer referenciar.

## Exceções

![[Pasted image 20250222223511.png]]
- Existem diversos tipos de exceções, algumas estão no nosso controle e outras fora.
- Se criamos um atributo e ele não pode receber valor negativo (como uma data), são fluxos que conseguimos ter controle
- Agora se estamos tentando ler um arquivo, e esse arquivo tem permissão de leitura. No entanto, daqui uma semana alguém altera isso e tu fica sem acesso. Outro exemplo é conexão com banco de dados, que pode estar sem conexão a internet, etc.
- Exceções no JAVA são um OBJETO. Da classe Throwable.

### Error: 
- Situações que não temos como recuperar 
- Um sistema rodando e não tem mais memoria pra continuar. Out of memory Error. 
- Quando temos erros, a JVM para de rodar.
- Outro erro é o StackOverFlow, que é quando você estoura a memoria da stack de chamadas do método.
- A solução para esses problemas é arrumar o código.
```java
// Tentou chamar o método varias vezes e estourou as tentativas.
public class StackOverFlowTest01 {  
    public static void main(String[] args) {  
        recursiviade();  
    }  
    public static void recursiviade(){  
        recursiviade();  
    }
```

### Exception e RunTimeException
- Temos exceções checadas e não checadas.
 **Unchecked:**
 Nesse caso, não é necessário fazer validação para seu código compilar. Essas exceções que são RunTime e suas filhas, quando é o programa que lança, quase 100% das vezes o problema é você que fez algo de errado no código.
 * Ex: Tentar acessar um objeto que não existe, será lançado um NullPointer
 Resumindo: Nesse caso, o problema é o código que você escreveu!
```java
int[] nums = {1,2};  
System.out.println(nums[2]);

// ArrayIndexOutOfBoundsException Erro do progamador! Não existe posição 2 nesse array.
```

 **Checked:** 
 Filhas da classe Excpetion diretamente, se não tratadas, não é possível nem complicar o código.
 * Ex: Ao trabalhar com arquivos, caso tenha feito alguma coisa errada, provavelmente será lançada um IOException.
- Nesse código, estamos criando um arquivo. Com o try, ele tenta criar o arquivo e no sout ele confirma. Agora no catch, a gente deixa especifico o erro que pode dar caso o arquivo não seja criado, que é o IOException, e como é um objeto nos referenciamos ele.  
- **NUNCA deixar um bloco catch em branco. Porque deixando em branco, tu está IGNORANDO e não está avisando pra NINGUEM que tem uma exceção acontecendo.**

```java
private static void criarNovoArquivo(){  
    File file = new File("arquivo\\teste.txt");  
    try{  
        boolean isCriado = file.createNewFile();  
        System.out.println("Arquivo criado " +isCriado);  
    } catch (IOException e) {  
        e.printStackTrace();  
    }
```

`printStackTrace();`  Printa no console, caso tenha caído na exceção, os possíveis erros. 
Catch é para lidar com exceções, não usar para regras de negócios.
- Dica do DevDojo: Caso tenha um erro, procurar na INTERNET! Não perguntar, correr atrás, isso te torna um desenvolvedor DIFERENTE!

### Lançando exceção unchecked
- RunTimeExcpetions você não é obrigado a fazer o tratamento.
- O Try e Catch não acabam com o código. O que significa que no metódo, o código vai acabar e não vai ter dado nenhum retorno. Isso permite que a JVM não crashe, porque vai estar te retornando 0.
```java
public static void main(String[] args) {  
    System.out.println(divisao(1,0););  
}  
  
private static int divisao(int a, int b){  
    try {  
        return a/b;  
    } catch (ArithmeticException e) {  
        e.printStackTrace();  
    }    return 0;
```
Outra maneira BEM mais simplificada de fazer isso é sendo mais especifico, nesse caso nos vamos setar qual exceção está correndo. Está é uma prática muito interessante, até para outros desenvolvedores entenderem melhor o que está acontecendo.
```java
private static int divisao(int a, int b) {  
        if (b == 0) {  
            throw new IllegalArgumentException("Argumento ilegal, não pode ser 0");  
        }        return a / b;  
    }}
```
- Lembrar que isso não é obrigado a fazer com as exceções de RunTime.
- Caso queira avisar as outras pessoas que estão usando o método, colocar throws depois da assinatura + exceção. Isso é uma flag que indica a possibilidade de acontecer tal exceção. 
- Não é muito comum isso.

`private static int divisao(int a, int b) throws IllegalArgumentException {`

### Lançando exceção checked
- Quando colocamos um "throws IOException", por exemplo, em um método, você será obrigado a tratar ele (fazer um try catch) quando for chamado ou jogar para outro método. Se for o main, o método main que trata dessa "batata quente".
- Quando usar o throws IOException ou Try/Catch?
**Uso de `try-catch` em Métodos Privados**
1. Encapsulamento do Tratamento: Quando um método é privado, ele não é acessível diretamente de fora da classe. Portanto, faz sentido encapsular o tratamento de exceções dentro desse método, usando `try-catch`. Isso é especialmente útil quando o método privado está realizando tarefas internas específicas e a classe deseja gerenciar diretamente qualquer problema que surja. 
2. Manutenção da Lógica de Negócio: Como os métodos privados geralmente são usados para tarefas de suporte dentro de uma classe, lidar com exceções dentro desses métodos (usando `try-catch`) ajuda a manter a lógica de negócios da classe intacta e centralizada. A classe pode, assim, lidar com erros e tomar decisões apropriadas sem expor esses detalhes para métodos externos ou outras classes. 
**Uso de `throw Exception` em Métodos Públicos** 
1. Delegação de Responsabilidade**: Métodos públicos expõem a funcionalidade de uma classe para outros objetos ou classes. Quando um método público lança uma exceção (`throws Exception`), ele está delegando a responsabilidade de lidar com essa exceção para o chamador. Isso permite que o chamador decida como tratar a exceção de acordo com suas necessidades específicas. 
2. Flexibilidade para o Chamador: Ao lançar uma exceção, os métodos públicos permitem que os chamadores tratem os erros de maneiras que façam sentido para eles, sem impor um tratamento específico. Isso pode ser útil em APIs ou bibliotecas, onde diferentes chamadores podem ter requisitos distintos de tratam

É possível fazer algo hibrido também: Imagine que você tem um carrinho de compras e você quer pagar, quando você tenta pagar e falha, voce quer ver no seu console que o pagamento falhou e quando esse pagamento falha, você quer dar pro cliente alguma alternativa de tentar novamente. Então você quer capturar a exceção, mostrar no console e quer retornar pra quem está chamando o método. Assim como o exemplo do arquivo.


```java
public class ExceptionTest02 {  
    public static void main(String[] args) throws IOException{  
        criarNovoArquivo();  
    }  
    private static void criarNovoArquivo() throws IOException {  
        File file = new File("arquivo\\teste.txt");  
        try{  
            boolean isCriado = file.createNewFile();  
            System.out.println("Arquivo criado " +isCriado);  
        } catch (IOException e) {  
            e.printStackTrace();  
            throw e;  
        }  
    }
```

* O `throw e;` **relança a exceção** e, como o método `criarNovoArquivo()` tem a declaração `throws IOException`, ele está **delegando a responsabilidade** para o método que o chamou — no caso, o `main`.
* Se o `main` não tratar a exceção com um `try-catch`, a exceção chega até a JVM, que encerrará o programa e exibirá a stack trace.
* Se o método `criarNovoArquivo()` **não tivesse** o `throws IOException`, você **seria obrigado a tratar a exceção dentro dele** (com `try-catch`) ou **no momento em que o chamasse**.
### Bloco Finally
- Caso bem especifico. 
- Se estamos trabalhando com recursos  e eles precisam ser fechados, a melhor parte para fazer isso é durante o finally.
- Finally é um bloco de código que vai ser SEMPRE executado.
```java
    private static String abreConexao() {  
        try{  
            System.out.println("Abrindo arquivo");  
            System.out.println("Escrevendo dados no arquivo");  
            return "conexão aberta";  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            System.out.println("Fechando recurso liberado pelo SO");  
        }        return null;  
    }}
```

### Capturando múltiplas exceções

```java
public class RuntimeExceptionTest04 {  
    public static void main(String[] args) {  
    try {  
        throw new ArrayIndexOutOfBoundsException();  
    } catch (ArrayIndexOutOfBoundsException e) {  
        System.out.println("Dentro do ArrayIndexOutOfBoundsException ");  
    } catch (IndexOutOfBoundsException e) {  
        System.out.println("Dentro do IndexOutOfBoundsException");  
    } catch (IllegalArgumentException e) {  
        System.out.println("Dentro do IllegalArgumentException");  
    } catch (ArithmeticException e) {  
        System.out.println("Dentro do ArithmeticException");  
    } catch (RuntimeException e) {  
        System.out.println("Dentro do RuntimeExcpetion");  
    }    }}
```

- Quando lançamos uma exceção e estamos trabalhando com múltiplas, ele vai procurar nos catchs até encontrar a que lhe pertence. Exceções que são filhas, como a do ArrayIndex (Classe pai: IndexOut), vai ser chamado na primeira que aparecer.
- Se não temos o catch correto de acordo com o erro, o programa crasha.
- É interessante trabalhar com isso porque se cair na mais genérica que é o pai de todos, o Runtime, nos conseguimos trabalhar com esse erro. 
- Um tipo mais genérico SEMPRE deve ficar abaixo do mais especifico, nesse caso, Runtime tem que estar abaixo. Os outros catchs se tornam inúteis, porque sempre vai cair na primeira. 
### Multi catch em linha
* Tomar cuidado que não podemos fazer isso com classes em herança
```java
    try {  
        talvezLanceExcpetion();  
    } catch (SQLException | FileNotFoundException e) {  
        e.printStackTrace();  
    }}  
  
private static void talvezLanceExcpetion() throws SQLException, FileNotFoundException{  
}
```
- Isso possibilita fazer um mesmo tratamento para diversas exceções, caso as condições sejam as mesmas
```java
try {  
    throw new RuntimeException();  
} catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | ArithmeticException e) {  
    System.out.println("Dentro do ArrayIndexOutOfBoundsException | IllegalArgumentException | ArithmeticExceptio ");  
} catch (RuntimeException e) {  
    System.out.println("Dentro do RuntimeExcpetion");  
}
```
- Nesse caso, trabalhos com 3 exceções que possuem o mesmo tratamento e se caso der algo errado, elas caem para a mais genérica.

### Try with resources
- Temos certeza que o Reader vai chamar o .close porque o Closeable é uma classe estendida, e possuiu o AutoCloseable também estendido. O que nos tira a preocupação de ter que chamar o finally para fechar, verificar se está nulo, etc.
- Quando estamos trabalhando com o Try with Resources, podemos tirar o catch. No entanto, precisamos declarar o throws com a exceção que tá sendo avançada.
public static void lerArquivo(){  

```java
    try (Reader reader = new BufferedReader(new FileReader("test.txt"))) {  
  
    } catch (IOException e) {  
  
    }
}
```

- É possível eu colocar quantas variáveis tu quiser, mas elas precisam ter o Closeable.
```java
public static void lerArquivo(){  
    try (Leitor1 leitor1 = new Leitor1();  
         Leitor2 leitor2 = new Leitor2();) {  
  
    } catch (IOException e) {  
  
    }}
// Fechando leitor 2
// Fechando leitor 1
```
- Saída: eles são fechados na ordem inversa que eles foram declarados. Isso é util quando vamos trabalhar com uma cadeia em banco de dados e precisamos fechar as conexões em ordem inversa.

### Exceção customizada
- É possível criar exceções, caso desejarmos fazer um tratamento especifico. Ex: Exceção caso o login e senha estejam incorretos.
- Podemos escolher se queremos fazer uma Checked ou Unchecked.

```java
public class LoginInvalidoException extends Exception {  
    public LoginInvalidoException() {  
        super("Lógin inválido");  
    }  
    public LoginInvalidoException(String message) {  
        super(message);  
    }}

public class LoginInvalidoExceptionTest01 {  
    public static void main(String[] args) {  
        try {  
            logar();  
        } catch (LoginInvalidoException e) {  
            e.printStackTrace();  
        }    }  
    private static void logar() throws LoginInvalidoException{  
        Scanner teclado = new Scanner(System.in);  
        String usernameDB = "Goku";  
        String senhaDB = "ssj";  
        System.out.println("Usuário: ");  
        String usernameDigitado = teclado.nextLine();  
        System.out.println("Senha: ");  
        String senhaDigitada = teclado.nextLine();  
        if (!usernameDB.equals(usernameDigitado) || !senhaDB.equals(senhaDigitada)) {  
            throw new LoginInvalidoException("Usuário ou senha inválidos");  
        }  
        System.out.println("Usuário logado com sucesso!");  
    }}
```

### Exceção e regras de sobrescrita
- Quando estamos sobrescrevendo um método, você não é obrigado a declarar as mesmas exceções que aquele método está declarando, porque a funcionalidade da sobrescrita pode ser diferente (como não possuir exceção). É possível também colocar só uma exceção caso tenha mais de uma, mas ai será necessário colocar o Try/Catch.
- Não é possível declarar uma exceção mais genérica do que as que tem dentro do método original, entretanto o contrário pode.
- Não é possível adicionar nenhuma exceção do tipo Checked que não foi declarada no método original.

```java
public class Pessoa {  
    public void salvar() throws LoginInvalidoException, IOException {  
        System.out.println("Salvando pessoa");  
    }}

// FUNCIONÁRIO SOBRESCREVE PESSOA
public class Funcionario extends Pessoa{  
    public void salvar() throws LoginInvalidoException{  
        System.out.println("Salvando funcionário");  
    }}

public class SobrescritaComExcepetionTest01 {  
    public static void main(String[] args) {  
        Pessoa pessoa = new Pessoa();  
        Funcionario funcionario = new Funcionario();  
  
        try {  
            funcionario.salvar();  
        } catch (LoginInvalidoException e) {  
            throw new RuntimeException(e);  
        }    }
```

## Classes Utilitárias
### Wrappers
- Eles são úteis em várias situações, especialmente quando você precisa usar tipos primitivos em contextos que exigem objetos, ou seja, quando queremos passar esses números por referencia e chamar alguns métodos.
- Array list e collections NÃO trabalham com tipos primitivos, apenas com wrappers.
- Preferir usar os tipos primitivos, mas caso não de, vai de wrappers mesmo
```java
byte byteP = 1;
short shortP = 1;
int intP = 1;
long longP = 10;
float floatP = 10F;
double doubleP = 10D;
char charP = 'W';
boolean booleanP = false;

Byte byteW = 127;
Short shortW = 1;
Integer intW = 1;
Long longW = 10L;
Float floatW = 10F;
Double doubleW = 10D;
Character charW = 'W';
Boolean booleanW = false;
```

| **Característica**                  | **Tipos Primitivos**        | **Classes Wrapper**                               |
| ----------------------------------- | --------------------------- | ------------------------------------------------- |
| **Natureza**                        | Tipos básicos               | Objetos (classes)                                 |
| **Pacote**                          | Fazem parte da linguagem    | Pertencem ao pacote `java.lang`                   |
| **Uso em Coleções (Ex: ArrayList)** | Não são aceitos diretamente | Aceitos (pois são objetos)                        |
| **Valores nulos**                   | Não suportam `null`         | Podem ser `null`                                  |
| **Métodos disponíveis**             | Nenhum                      | Possuem vários métodos úteis                      |
| **Conversões (Ex: String → int)**   | Feitas com funções externas | Feitas com métodos da classe (`Integer.parseInt`) |
| **Autoboxing/Unboxing**             | Não aplicável               | Suportam conversões automáticas                   |
| **Consumo de memória**              | Menor                       | Maior (por serem objetos)                         |
| **Exemplo de declaração**           | `int x = 10;`               | `Integer x = 10;`                                 |
| **Comparação com ==**               | Compara valores             | Compara referências (salvo casos até 127)         |
| **Uso em Generics**                 | Não permitido               | Permitido                                         |

- Dois conceitos importantes: **Autoboxing/Unboxing**
 Autoboxing:  Transformar um tipo primitivo em Wrapper
 `Integer intW = 1;`
 
 UnBoxing: Transformar um Wrapper em tipo primitivo
 `int i = intW;`

O método **`parse`** em Java serve para **converter (ou analisar)** uma **String** que representa um valor (como um número) em um **tipo de dado primitivo correspondente**.

- `Double.parseDouble("3.14")` → converte `"3.14"` para `3.14` (double)
- `Long.parseLong("1000")` → converte `"1000"` para `1000` (long)
- `Boolean.parseBoolean("TruE")` → converte `"true"` para `true` (boolean)

### String
- String são imutáveis. Nunca é possível alterar um valor no String pool
- Tomar cuidado ao associar um novo valor a variável de referencia.
- Usamos o .equals para validar se o valor delas é igual.
- Toda string que você cria no JAVA, ela é alocada dentro do String pool, mas se você criar ela uma segunda vez, o JAVA não vai duplicar.


```java
public class StringTest01 {  
    public static void main(String[] args) {  
        String nome = "Alberto"; // String constant pool  
        String nome2 = "Alberto";  
        System.out.println(nome == nome2);  
        System.out.println(nome.equals(nome2));  
    }}
```
#### 1. Por que `nome == nome2` é `true`?

O operador **`==`** em Java, quando usado com objetos (como `String`), **compara as referências na memória** — ou seja, verifica se as duas variáveis apontam para o **mesmo objeto**.

No caso de **Strings literais** (como `"Alberto"`), o Java utiliza um mecanismo chamado **String Constant Pool**.

✅ **Como funciona:**

- Quando você escreve `String nome = "Alberto";`, o Java coloca a String no **pool de Strings**.
- Ao fazer `String nome2 = "Alberto";`, como `"Alberto"` **já está no pool**, o Java **reutiliza a mesma referência** em vez de criar um novo objeto.

🔎 **Resultado:** Tanto `nome` quanto `nome2` apontam para **o mesmo local na memória** → `nome == nome2` é `true`.

---

#### 2. Por que `nome.equals(nome2)` é `true`?

O método **`.equals()`** compara **o conteúdo** das Strings, não as referências.

- Como `"Alberto"` é o conteúdo de ambas, o resultado será `true`, independentemente das referências.

#### E se fosse criado com `new`?

Se você fizer assim:

```java
String nome = new String("Alberto");
String nome2 = new String("Alberto"); // 1 variavel de referencia, 2 objeto do tipo string, 3 uma string no pool string caso não exista
System.out.println(nome == nome2);      // false (referências diferentes)
System.out.println(nome.equals(nome2)); // true  (conteúdo igual)
```

🔔 **Por quê?**

- O `new String("Alberto")` cria **novos objetos** na heap, ignorando o pool de Strings.
- Por isso, `==` é `false` (referências diferentes), mas `.equals()` é `true` (conteúdo igual).

Ao usar `nome.concat("String"`), ele vai criar a String dentro do pool, e se não associar uma nova variável, como `nomeNovo = nome.concat("String")`, esse valor se perde.

`.concat()` → Concatena (une) duas Strings, formando uma nova String.
`.intern()` → Faz uma String usar a versão do pool, unificando referências.
`.charAt()` → Retorna o caractere de uma String em uma posição específica. (Começa em 0)
`.length()` → Retorna o número total de caracteres em uma String.
`.replace()` → Percorre a String e faz a substituição dos caracteres, o primeiro é o Substituído e o outro o Substituto.
`.toUpperCase()` → Converte todos os caracteres da String para maiúsculas.
`.toLowerCase()` → Converte todos os caracteres da String para minúsculas.
`.substring()` → Retorna uma parte da String, baseada em um índice inicial e opcionalmente um final.
`.trim()` → Remove espaços em branco do início e do fim da String.

### String Builder
- Aqui, não tem mais o conceito de String imutável, porque SB não é uma String.
- Quando você trabalha com SB, você não está mexendo mais com String Pool, mas sim com os métodos dentro do objeto String Builder.
- Quando vamos criar uma nova String builder, temos essas opções de criação:

`StringBuilder(int capacity)`  
`StringBuilder(String str)`   
`StringBuilder(CharSequence seq)`

Ele possui o método toString dentro dele, por isso, ao tentar printar dessa forma sai o nome diretamente.

```java
StringBuilder sb = new StringBuilder("Xis Beto");  
System.out.println(sb);
```

String Builder e String Buffer acabam PERFORMANDO BEM MELHOR do que as Strings normais é porque eles oferecem uma capacidade de fazer a mudança de String sem precisar alocar espaço dentro do String Pool.

```
sb.append(); é o igual ao string.concat();
```

Tomar cuidado com os métodos chamados e com o que você quer, ou seja, se você quer mexer num SB, o método precisa retornar um SB. Ao usar um `.substring`, que retorna string, você não vai conseguir alterar o valor dentro da SB. Mas agora com um `.reverse`, as coisas são diferentes, pois é retornado um SB.

StringBuffer também funciona com esses princípios.

### Date
- Primeira classe para datas
- Pouco usado hoje em dia.
- Trabalha com milissegundos, utilizando LONG. Começando desde 01/01/1970.
- Praticamente todos esses métodos estão obsoletos.
### Calendar
- Segunda classe para datas criada, com o objetivo de consertar os problemas de Date.
- É uma classe abstrata, não é possível usar new.
- Pouco usado também, mas caso vá trabalhar com sistemas legados, é importante saber. Alguns exemplos aqui:
```java
Calendar c = Calendar.getInstance();  
if (c.getFirstDayOfWeek() == Calendar.SUNDAY){  
    System.out.println("Domingo é o primeiro dia da semana");  
}  
System.out.println(c.get(Calendar.DAY_OF_WEEK));  
System.out.println(c.get(Calendar.DAY_OF_MONTH));  
System.out.println(c.get(Calendar.DAY_OF_YEAR));  
System.out.println(c.get(Calendar.DAY_OF_WEEK_IN_MONTH));  
  
c.add(Calendar.DAY_OF_MONTH, 0);  
c.roll(Calendar.HOUR, 12);  
Date date = c.getTime();  
System.out.println(date);
```

#### DateFormat
- Métodos pré-definidos para formatação de Datas. É uma classe abstrata.
- São 6 tipos principais.
```java
Calendar calendar = Calendar.getInstance();  
DateFormat[] df = new DateFormat[7];  
df[0] = DateFormat.getInstance();   // 27/02/2025 18:03
df[1] = DateFormat.getDateInstance();  // 27 de fev. de 2025
df[2] = DateFormat.getDateTimeInstance();  // 27 de fev. de 2025 18:03:26
df[3] = DateFormat.getDateInstance(DateFormat.SHORT);  // 27/02/2025
df[4] = DateFormat.getDateInstance(DateFormat.MEDIUM); // 27 de fev. de 2025
df[5] = DateFormat.getDateInstance(DateFormat.LONG);  // 27 de fevereiro de 2025
df[6] = DateFormat.getDateInstance(DateFormat.FULL); 
// quinta-feira, 27 de fevereiro de 2025

for (DateFormat dateFormat : df) { System.out.println(dateFormat.format(calendar.getTime())); }
```

O método `getInstance()` retorna a data e hora atual do sistema,
Com o `for-each`, você percorre cada um dos formatos de data armazenados no array `df` e, para cada formato, você usa o método `format()` para formatar a data armazenada no `calendar` (que foi obtida com o `calendar.getTime()`) e imprimir no console..

### Internacionalização Datas com Locale
- Classe criada para formatar datas, moedas e números. Podemos escolher qual país queremos pegar esses dados, usando as abreviações do país (importante consultar as ISOS).
```java
Locale localeItaly = new Locale("it","IT");
DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL, localeItaly);
System.out.println("Italia: " +df1.format(calendar.getTime()));

// Italia: giovedì 27 febbraio 2025
```


### Internacionalização Números e Moedas com Locale
`Locale.getDefault()` -> Retorna como está configurado o Local no computador, para saber como os números/datas vão ser formatados.
NumberFormat é uma classe abstrata. Para pegar um objeto colocamos `NumberFormat.getInstance();`

| Método                           | Formatação                          | Adiciona Símbolo de Moeda? | Exemplo (Brasil)    |
|----------------------------------|----------------------------------|---------------------|-------------------|
| `NumberFormat.getInstance()`    | Apenas separadores de milhar e decimal | ❌ Não            | `1.234.567,89`   |
| `NumberFormat.getCurrencyInstance()` | Formatação de moeda com símbolo | ✅ Sim             | `R$ 1.234.567,89` |
Ou seja, **`getInstance()` é para números genéricos, enquanto `getCurrencyInstance()` é específico para valores monetários**.
`NumberFormat.setMaximumFractionDigits(2)` define o número máximo de casas decimais que um número pode ter ao ser formatado pelo `NumberFormat`.

### SimpleDateFormat
- Trabalhar com datas de uma maneira um pouco mais flexivel do que a DateFormat.
```java
String pattern = "'Brasil' dd 'de' MMMM 'de' yyyy";  
SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
System.out.println(sdf.format(new Date()));

// Brasil 06 de março de 2025
```
- Há uma tabela de valores os quais representam datas, meses, anos 

### LocalDate
- Melhor classe para trabalhar com datas.
- A principal diferença entre ela, Date e Calendar, é que ele á uma classe mais nova, veio a partir do JAVA 8.
- É uma classe imutável, não pode criar instancias. Por isso seria necessário ao querer usar algum método associar a uma nova váriavel de referencia. 
```java
LocalDate agora = LocalDate.now();  
agora.plusWeeks(4); // Assim não muda

agora = agora.plusWeeks(4); // Assim muda


LocalDate date = LocalDate.of(2025, Month.FEBRUARY, 28); // Usar o .of para criar a apartir de uma data especifica
LocalDate agora = LocalDate.now(); // .now pega o de agora obviamente
agora = agora.plusWeeks(4);  
System.out.println(date.getYear());  
System.out.println(date.getMonth());  
System.out.println(date.getMonthValue());  
System.out.println(date.getDayOfWeek());  
System.out.println(date.getDayOfMonth());  
System.out.println(date.lengthOfMonth());  
System.out.println(date.isLeapYear());  
System.out.println(date.get(ChronoField.YEAR));  
System.out.println(date.get(ChronoField.DAY_OF_MONTH));  
System.out.println(date);  
System.out.println(agora);  
System.out.println(LocalDate.MAX);  
System.out.println(LocalDate.MIN);
```

- Com `ChronoField`, você pode acessar valores (`get()`) e modificá-los (`with()`).
- Quando usa `with()`, ele retorna um novo objeto sem alterar o original.
- É útil para manipular datas sem precisar chamar métodos específicos para cada campo.

### LocalTime
```java
LocalTime time = LocalTime.of(23,32,12);  
LocalTime timeNow = LocalTime.now();  
System.out.println(time);  
System.out.println(timeNow);  
System.out.println(time.getHour());  
System.out.println(time.getMinute());  
System.out.println(time.getSecond());  
System.out.println(time.get(ChronoField.CLOCK_HOUR_OF_AMPM));  
System.out.println(LocalTime.MIN);  
System.out.println(LocalTime.MAX);
```

### LocalDateTime
- Junção das outras duas.
- É possível fazer um parse desses dois formatos, transformando um LocalDate ou LocalTime em string.
- Também é possível associar elas e criar um LocalDateTime a partir das duas separadas
```java
LocalDateTime localDateTime = LocalDateTime.now();  
LocalDate date = LocalDate.parse("2022-08-06");  
LocalTime time = LocalTime.parse("09:45:00");  
System.out.println(localDateTime);  
System.out.println(date);  
System.out.println(time);  
LocalDateTime ltd1 = date.atTime(time); // Mesma coisa que o de baixo, mas aqui no caso lança primeiro o dia e dps a hora e ali é ao ocntrario  
LocalDateTime ltd2 = time.atDate(date)  
System.out.println(ltd1);  
System.out.println(ltd2);
```

### Instant 
- Parecida com a Date, mas instant trabalha com nanosegundos. Representando um ponto instantâneo dentro da linha do tempo. Bom para o computador
### Duration
- Trabalhar com a quantidade de tempo, geralmente quando queremos saber o intervalo entre duas datas.
- Baseada em segundos e nanosegundos.
- Duration não aceita LocalDate, pois ela não tem segundos.
- Bom para trabalhar com HORAS

```java
LocalDateTime now = LocalDateTime.now();  
LocalDateTime nowAfterTwoYears = LocalDateTime.now().plusYears(2).plusMinutes(8);  
LocalTime timeNow = LocalTime.now();  
LocalTime timeMinus7Hours = LocalTime.now().minusHours(7);  
Duration d1 = Duration.between(now, nowAfterTwoYears);  
Duration d2 = Duration.between(timeNow, timeMinus7Hours);  
Duration d3 = Duration.between(Instant.now(), Instant.now().plusSeconds(1000));  
Duration d4 = Duration.ofDays(20);
```
### Period
- Classe baseada na DATA.
- Trabalha com DIAS/MESES/ANOS.
```java
Period p1 = Period.between(now, nowAfterTwoYears);  
Period p2 = Period.ofDays(10);  
Period p3 = Period.ofWeeks(56);  
Period p4 = Period.ofMonths(5);  
Period p5 = Period.ofYears(5);
```

### ChronoUnit
- Bom para situações que, por exemplo, queremos saber a quantidade de meses baseadas em dias. Só com o Period não conseguimos fazer isso.
- Muito prática pra trabalhar com um intervalo de data
```java
LocalDateTime aniversario = LocalDateTime.of(2005, Month.APRIL, 18,13,0,0);  
LocalDateTime now = LocalDateTime.now();  
System.out.println(ChronoUnit.DAYS.between(aniversario,now));  
System.out.println(ChronoUnit.WEEKS.between(aniversario,now));  
System.out.println(ChronoUnit.MONTHS.between(aniversario,now));  
System.out.println(ChronoUnit.YEARS.between(aniversario,now));
```

### TemporalAdjusters
-  Simples e legível, sem necessidade de cálculos manuais.  
 - Reduz a chance de erros ao manipular datas.  
-  Pode ser combinado com `with()` para ajustes dinâmicos

 `with(ChronoField.DAY_OF_MONTH, 6)`: Altera apenas o dia do mês, mantendo o mesmo mês e ano.
`TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)`: Retorna a próxima quinta-feira ou o próprio dia, se já for quinta.
`TemporalAdjusters.next(DayOfWeek.THURSDAY)`: Retorna a próxima quinta-feira após a data atual.
`TemporalAdjusters.previous(DayOfWeek.THURSDAY)`: Retorna a última quinta-feira antes da data atual.
`TemporalAdjusters.firstDayOfMonth()`: Ajusta para o primeiro dia do mês.
`TemporalAdjusters.lastDayOfMonth()`: Ajusta para o último dia do mês.

### ZonedDateTime, ZoneId e OffsetDateTime
#### ZonedDateTime
- Representa uma data e hora **com um fuso horário específico**.
- Combina um `LocalDateTime` com um `ZoneId`.
- Permite converter entre fusos horários facilmente.
`ZonedDateTime zonedDateTime = LocalDateTime.now().atZone(ZoneId.of("Asia/Tokyo"));`
#### ZoneId
- Representa **um fuso horário**, como `America/Sao_Paulo` ou `Asia/Tokyo`.
- Pode ser usado para converter um `LocalDateTime` em um `ZonedDateTime`.
- Permite obter o fuso horário do sistema com `ZoneId.systemDefault()`.  
`ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");`

#### OffsetDateTime
- Representa uma data e hora **com um deslocamento fixo em relação ao UTC**.
- **Não muda com horário de verão**, ao contrário de `ZonedDateTime`.
- Baseado em um `ZoneOffset`, como `-03:00` ou `+05:30`.  
`OffsetDateTime offsetDateTime = LocalDateTime.now().atOffset(ZoneOffset.of("-04:00"));`

### DateTimeFormatter
- Format  -> Transformando objeto em string
- Parse -> Transformando string pro objeto
A classe `DateTimeFormatter` no Java serve para **formatar** e **analisar** (`parse`) datas e horas.

`DateTimeFormatter` - Formatação (`.format()`)
- Transforma um objeto de data (`LocalDate` ou `LocalDateTime`) em uma `String` formatada.
```java
DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
String formatBR = LocalDate.now().format(formatterBR);
System.out.println(formatBR);

// Saida: 07/03/2025
```

`parse()` - Convertendo `String` para Data
- O método `.parse()` faz o **contrário** de `.format()`, ou seja, converte uma `String` formatada de volta para um objeto `LocalDate` ou `LocalDateTime`.
```java
LocalDate parseBR = LocalDate.parse("07/03/2025", formatterBR);
System.out.println(parseBR);

// Saída: 2025-03-07
```

O `LocalDate` sempre imprime no formato **ISO** (`yyyy-MM-dd`), independente do formato de entrada.

`DateTimeFormatter` com Localização (`Locale`)
- Permite formatar datas de acordo com diferentes idiomas e culturas.
- Exemplo no **formato chinês**:
```java
DateTimeFormatter formatterCH = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.CHINA);
String formatCH = LocalDate.now().format(formatterCH);
System.out.println(formatCH);

// Saída: 07.三月.2025
```

`.format(formatter)` → Converte um objeto de data (`LocalDate`, `LocalDateTime`) para uma `String` formatada.
`.parse(string, formatter)` → Converte uma `String` formatada para um objeto `LocalDate` ou `LocalDateTime`.
`DateTimeFormatter.ofPattern("dd/MM/yyyy")` → Permite criar formatos personalizados.

## ResourceBundle
- O `ResourceBundle` no Java é uma classe usada para **gerenciar mensagens e textos em diferentes idiomas**, facilitando a **internacionalização (i18n)** de aplicações.
- Ele permite que você armazene strings e configurações em arquivos `.properties`, separando o código-fonte dos textos exibidos ao usuário.
#### Como funciona?

- Você cria arquivos `.properties` para cada idioma.
- O Java escolhe automaticamente o arquivo correto com base no `Locale` do usuário.
- Caso o arquivo exato não exista, ele segue uma **hierarquia de fallback**.

`messages.properties` (fallback, idioma padrão)
```
greeting=Hello!
farewell=Goodbye!
```
`messages_pt_BR.properties` (Português - Brasil)
```
greeting=Olá! 
farewell=Adeus!
```
`messages_es_ES.properties` (Espanhol - Espanha)
```
greeting=¡Hola! 
farewell=¡Adiós!
```

```java
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {
    public static void main(String[] args) {
        Locale locale = new Locale("pt", "BR"); // Define o idioma para Português - Brasil
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        System.out.println(bundle.getString("greeting")); // Saída: Olá!
        System.out.println(bundle.getString("farewell")); // Saída: Adeus!
    }
}
```
 O Java procura automaticamente o arquivo `messages_pt_BR.properties` porque o `Locale` está definido como `"pt", "BR"`.  
 Se não encontrar esse arquivo, ele tenta `messages_pt.properties` e depois `messages.properties`.

Se o **locale do usuário for** `new Locale("fr", "CA")` e o **locale padrão do sistema for `pt-BR`**, o Java buscará:
1. `messages_fr_CA.properties`  
2. `messages_fr.properties`  
3. `messages_pt_BR.properties` (**porque o sistema é `pt-BR`**)  
4. `messages_pt.properties`  
5. `messages.properties` (**fallback final**)

- Os textos são armazenados em arquivos `.properties`, um para cada idioma.
- O Java escolhe automaticamente o arquivo correto com base no `Locale`.
- Se o arquivo específico não existir, ele segue uma **hierarquia de fallback**.
- Pensando em palavras que sejam iguais nos dois idiomas, talvez seja interessante ter um messages.properties

## Regex
- Conhecido também como Regular Expression, ou Expressão Regular.
- Linguagem desenvolvida que utiliza caracteres especiais que vão encontrar padrões em textos. Também é usado para validações (ex: email) 

`String regex = "aba";  
`String texto2 = "abababa";

- A **expressão regular** (`regex`) definida é `"aba"`, ou seja, queremos encontrar essa sequência dentro da string `texto2 = "abababa"`.

O método `Pattern.compile(regex)` **compila** a expressão regular para ser usada no processo de busca.
O `matcher` será responsável por encontrar todas as ocorrências do padrão `"aba"` dentro da string `"abababa"`.

```java
Pattern pattern = Pattern.compile(regex); // Vai compilar e procurar  
Matcher matcher = pattern.matcher(texto2); // Vai retornar se deu match  
  
System.out.println("texto:  "+texto2);  
System.out.println("indice: 0123456789");  
System.out.println("regex "+regex);  
System.out.println("Posições encontradas: ");  
while (matcher.find()){  
    System.out.print(matcher.start()+ " ");  
}

// Texto 2: 0 4

```

Ou seja, a Regex encontrou **apenas dois grupos** `"aba"` em `"abababa"`:

- Um começando no índice **0**
- Outro começando no índice **4**

O `"aba"` que estaria em `2` não é considerado porque o Java **não permite sobreposição automática de padrões** ao usar `matcher.find()`.
- `matcher.group()` **pega o valor inteiro que deu match**.
- `matcher.group(n)` **pega apenas uma parte específica**, se houver **grupos definidos** na regex.

### Meta caracteres

| Metacaractere | Significado                              | Exemplo | Casa com                  | Não casa com     |
| ------------- | ---------------------------------------- | ------- | ------------------------- | ---------------- |
| `.`           | Qualquer caractere (exceto nova linha)   | `a.b`   | `"a_b"`, `"acb"`, `"a1b"` | `"ab"`, `"a\nb"` |
| `\d`          | Dígitos (`0-9`)                          | `\d+`   | `"123"`, `"9"`            | `"abc"`          |
| `\D`          | Não dígito (`^0-9`)                      | `\D+`   | `"abc"`, `"#@"`           | `"123"`          |
| `\s`          | Espaço em branco (` `, `\t`, `\n`, etc.) | `a\sb`  | `"a b"`                   | `"ab"`, `"a_b"`  |
| `\S`          | Qualquer caractere, exceto espaços       | `\S+`   | `"abc"`, `"123"`          | `" "`            |
| `\w`          | Caracteres alfanuméricos (`a-zA-Z0-9_`)  | `\w+`   | `"abc123"`, `"var_name"`  | `"@#%"`          |
| `\W`          | Qualquer coisa que não seja `\w`         | `\W+`   | `"@#%"`                   | `"abc"`, `"123"` |

### Range
- O **range** no regex é usado dentro de colchetes `[]` para definir um conjunto de caracteres que podem aparecer em determinada posição.  
#### Como funciona?
1. **Definição de um intervalo**
    - `[a-z]` → qualquer letra minúscula de **a a z**
    - `[A-Z]` → qualquer letra maiúscula de **A a Z**
    - `[0-9]` → qualquer número de **0 a 9**
    - `[a-zA-Z]` → qualquer letra, maiúscula ou minúscula
    - `[0-9a-f]` → qualquer número ou letra de **a a f** (exemplo: hexadecimal)
2. **Combinação de caracteres e intervalos**
    - `[a-z0-9]` → qualquer letra minúscula ou número
    - `[^a-z]` → **negação**: qualquer caractere **exceto** letras minúsculas

### Quantificadores
Os **quantificadores** definem **quantas vezes** um caractere ou grupo de caracteres pode aparecer.

| Quantificador | Significado        | Exemplo   | Casa com               | Não casa com      |
| ------------- | ------------------ | --------- | ---------------------- | ----------------- |
| `?`           | Zero ou uma vez    | `a?`      | "", "a"                | "aa", "aaa"       |
| `*`           | Zero ou mais vezes | `a*`      | "", "a", "aaa"         | -                 |
| `+`           | Uma ou mais vezes  | `a+`      | "a", "aaa"             | ""                |
| `{n}`         | Exatamente n vezes | `a{3}`    | "aaa"                  | "a", "aa", "aaaa" |
| `{n,}`        | No mínimo n vezes  | `a{2,}`   | "aa", "aaa", "aaaa..." | "a"               |
| `{n,m}`       | Entre n e m vezes  | `a{2,4}`  | "aa", "aaa", "aaaa"    | "a", "aaaaa"      |
| `()`          | Agrupamento        | `(abc)+`  | "abc", "abcabc"        | "ab", "ac"        |
| \|            | OU (alternância)   | `o(v\|c)o | "ovo", "oco"           | oo", "ovooco"`    |
| `$`           | Fim da linha       | `abc$`    | "finalabc"             | "abcfinal"        |

#### Explicação do Regex usado no código

```java
String regex = "0[xX]([0-9a-fA-F])+(\\s|$)";
String texto = "12 0x 0X 0xFFABC 0x10G 0x1";
```

#### Quebrando o regex parte por parte:

| Padrão           | Explicação                                                      |
| ---------------- | --------------------------------------------------------------- |
| `0[xX]`          | Casa com "0x" ou "0X" (hexadecimal em Java).                    |
| `([0-9a-fA-F])+` | Um ou mais caracteres hexadecimais válidos (0-9, a-f, A-F).     |
| (\\s\|$)         | Deve terminar com um espaço (`\s`) ou ser o fim da linha (`$`). |

#### Exemplos de como ele se comporta no texto:

| Trecho | Casa? | Motivo |
|--------|-------|--------|
| `"0x"` | ❌ Não | Não tem dígitos hexadecimais após "0x". |
| `"0X"` | ❌ Não | Mesmo motivo: falta um número depois. |
| `"0xFFABC "` | ✅ Sim | "0xFFABC" tem apenas caracteres hexadecimais válidos e termina com espaço. |
| `"0x10G"` | ❌ Não | "G" não é um número hexadecimal válido. |
| `"0x1"` | ✅ Sim | "0x1" contém um número hexadecimal válido e termina no fim da linha (`$`). |

#### Explicação sobre o método `matches()` em Java

O método `matches()` em Java é usado para verificar se uma string corresponde a um padrão (expressão regular) fornecido. Vamos detalhar como ele funciona com base no seu exemplo.

```java
String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
String texto = "narutuuzumaki@yahoo.com, 7minutoz@gmail.com, #%$zoro@mail.br, hinata@hotmail.com, sakura@mail";
System.out.println("Email valido");
System.out.println("#%$zoro@mail.br".matches(regex));
```

- O método `matches()` compara a string fornecida (no caso, `#%$zoro@mail.br`) com o padrão definido pela expressão regular `regex`.
- Ele retorna `true` se a string corresponde completamente ao padrão, e `false` se não corresponder.
- O que acontece com `#%$zoro@mail.br`:
    - A string `#%$zoro@mail.br` não é válida porque ela contém caracteres especiais (`#`, `%`, `$`) no nome de usuário, que não são permitidos de acordo com a regex fornecida.
    - Assim, a chamada `"#%$zoro@mail.br".matches(regex)` vai retornar `false`.

* Resultado Esperado:
	- `System.out.println("#%$zoro@mail.br".matches(regex));`
	    - Retorna `false`, porque o e-mail contém caracteres inválidos.
	- Se você usar um e-mail válido, como `"zoro@mail.br"`, a chamada `matches()` retornaria `true`


## Scanner
### Tokens e Delimitadores

Um **token** é uma unidade de dados extraída de uma entrada. Os tokens são partes da entrada separadas por **delimitadores** (como espaços, vírgulas ou outros caracteres).

```java
String texto = "Levi, Eren, Mikasa";  
String[] nomes = texto.split(","); 
// .split vai retornar um array separando os elementos, nesse caso a ","
for (String nome : nomes) {  
    System.out.println(nome.trim());
    // o .trim é usado para remover os espaços em branco
}
```

Porém, há valores como `Boolean` ou que precisamos extrair como `inteiros` que em String não será possível declarar, mas há outra maneira.
A scanner já possui nela um delimitador padrão, que é um " " (Espaço em branco). Para definir outro limitador, usamos `scanner.useDelimiter();`
Scanner funciona como se tivesse dois ponteiros, em que um verifica se existe um próximo valor e, se caso existir, um segundo ponteiro vai realmente pegar o valor.
```java
String texto = "Levi,Eren,Mikasa,true,200";
Scanner scanner = new Scanner(texto);
scanner.useDelimiter(",");
while (scanner.hasNext()){ 
    if(scanner.hasNextInt()) { // Enquanto existir um proximo inteiro
        int i = scanner.nextInt(); // Lê e consome o inteiro
        System.out.println("Int: "+i);
    } else if (scanner.hasNextBoolean()) { // Enquanto existir um proximo boolean
        boolean b = scanner.nextBoolean(); // Lê e consome o boolean
        System.out.println("Boolean: "+b);
    } else {
        System.out.println(scanner.next()); // Lê e consome como string
    }
}
```

1. O `Scanner` lê a string `"Levi,Eren,Mikasa,true,200"`, separando os tokens pelo delimitador `","`. 
2. O `while (scanner.hasNext())` verifica se ainda há tokens disponíveis.
3. Se o próximo token for um **inteiro**, `scanner.hasNextInt()` retorna `true`, e `nextInt()` pega o valor.
4. Se for um **boolean**, `scanner.hasNextBoolean()` retorna `true`, e `nextBoolean()` pega o valor.
5. Se não for um inteiro nem um boolean, `scanner.next()` apenas lê e imprime como string.

## IO
### File
- Quando criamos um objeto new file, nós precisamos passar um pathname, que é o diretório dele. Caso seja o caso de passar o caminho absoluto, precisa dar um copy  absolute path.
- Para criar um arquivo, é necessário usar um `file.createNewFile();`, e ele vai lançar uma exceção do tipo checked. Por padrão ele retorna um valor booleano.

 O método `createNewFile()` da classe `File` pode lançar uma exceção `IOException` caso haja um erro ao criar o arquivo.
```java
import java.io.File;
import java.io.IOException;

public class CriarArquivo {
    public static void main(String[] args) {
        File file = new File("meuarquivo.txt"); // Define o arquivo

        try {
            if (file.createNewFile()) { // Tenta criar o arquivo
                System.out.println("Arquivo criado: " + file.getAbsolutePath());
            } else {
                System.out.println("O arquivo já existe.");
            }
        } catch (IOException e) { // Captura erro caso ocorra
            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
        }
    }
}
```
**`try-catch`**
    - Se ocorrer uma `IOException`, o `catch` captura o erro e exibe a mensagem.
    - Isso evita que o programa quebre inesperadamente.

Possíveis Erros Tratados:
- **Permissão negada** (o diretório não permite criar arquivos).
- **Caminho inválido** (nome de arquivo incorreto).
- **Espaço insuficiente no disco**.

Esse é o uso do `try-catch` para evitar falhas ao criar arquivos em Java.

Para deletar usamos o `file.delete();`, no entanto, é uma boa prática usar verificar se um arquivo existe antes de deletar, segundo tal padrão:
```java
boolean exists = file.exists();  
if (exists) {  
    System.out.println("Deleted: "+file.delete());  
}
```

`file.getPath()` -> Retorna o caminho relativo ou absoluto do arquivo/pasta, dependendo de como o objeto `File` foi criado.

`file.getAbsolutePath()` -> Retorna o caminho absoluto do arquivo/pasta no sistema.

`file.isDirectory()` -> Retorna `true` se o caminho representa um diretório, caso contrário, retorna `false`.

`file.isFile()` -> Retorna `true` se o caminho representa um arquivo, caso contrário, retorna `false`.

`file.isHidden()` -> Retorna `true` se o arquivo/pasta estiver oculto no sistema.

`file.lastModified()` ->Retorna a data/hora da última modificação do arquivo em milissegundos desde 01/01/1970.  Convertido para `Date` para exibir de forma legível.


### FileWriter

```java
File file = new File("file.txt");
try (FileWriter fw = new FileWriter(file, true)) { // Modo append ativado
    fw.write("O DevDojo é o melhor curso do Brasil!");
    fw.flush();
} catch (IOException e) {
    throw new RuntimeException(e);
}
```

```java
try (FileWriter fw = new FileWriter(file, true))
```
- `FileWriter` escreve no arquivo.
- O **`true`** ativa o **modo append**, ou seja, adiciona ao final do arquivo sem apagar o conteúdo anterior.
- Se fosse `false` ou não passasse nada, ele sobrescreveria o arquivo.

```java
fw.write("O DevDojo é o melhor curso do Brasil!");
```
- O método `write()` escreve o texto no arquivo.
- Ele não adiciona uma quebra de linha automaticamente. Se precisar, use `\n`:

`fw.flush();`
- **Força a escrita imediata dos dados no arquivo**.
- Sem isso, o Java pode armazenar os dados temporariamente antes de gravá-los no disco.
- Útil para garantir que os dados sejam escritos antes de fechar o `FileWriter`.

```java
try (FileWriter fw = new FileWriter(file, true)) { }
```
- Esse `try` com parênteses é chamado de **try-with-resources**.
- Ele **fecha automaticamente** o `FileWriter`, evitando vazamento de recursos.
- **Equivalente a chamar `fw.close()` manualmente.**

### FileReader

```java
File file = new File("file.txt");  
try(FileReader fr = new FileReader(file)){  
    int i;  
    while ((i=fr.read()) != -1) {  
        System.out.print((char)i);  
    }} catch (IOException e){  
    throw new RuntimeException(e);  
}
```

O `FileReader` é usado para ler arquivos de texto caractere por caractere. Quando chamamos `read()`, ele retorna um número inteiro correspondente ao código ASCII do caractere lido.

O loop `while ((i = fr.read()) != -1)` funciona porque o `read()` retorna `-1` quando chega ao final do arquivo, indicando que não há mais nada para ler.

A conversão `(char) i` transforma o número lido em um caractere para exibição. Isso é necessário porque `read()` trabalha com valores numéricos, mas queremos exibir texto.

- `FileReader` lê o arquivo caractere por caractere.
- `read()` retorna um número correspondente ao caractere lido.
- Quando `read()` retorna `-1`, significa que o arquivo acabou.
- O `(char) i` converte o número lido para um caractere legível.

### BufferedWriter
O `BufferedWriter` é usado para escrever em arquivos de forma mais eficiente do que o `FileWriter`, pois armazena os dados em um buffer antes de gravá-los, reduzindo o número de acessos diretos ao arquivo.

#### Diferença entre FileWriter e BufferedWriter:

- O `FileWriter` escreve diretamente no arquivo, o que pode ser ineficiente quando há muitas operações de escrita.
- O `BufferedWriter` usa um buffer interno para agrupar os dados antes de gravar, melhorando o desempenho.

```java
File file = new File("file.txt");  
try (FileWriter fw = new FileWriter(file, true);  
     BufferedWriter br = new BufferedWriter(fw)){  
    br.write("O DevDojo é o melhor curso do Brasil!");  
    br.newLine();  
    br.flush();  
} catch (IOException e) {  
    throw new RuntimeException(e);  
}
```

- O `BufferedWriter` recebe um `FileWriter` como argumento.
- `write()` escreve a string no buffer (não grava no arquivo imediatamente).
- `newLine()` adiciona uma quebra de linha (equivalente a `\n`, mas compatível com diferentes sistemas operacionais).
- `flush()` força a escrita do buffer no arquivo.

Usar `BufferedWriter` é útil quando há várias operações de escrita, pois reduz o número de acessos diretos ao disco, tornando o processo mais rápido.

### BufferedReader
O **`BufferedReader`** é uma classe que melhora a leitura de arquivos ao armazenar os dados em um **buffer** (memória temporária). Ele **lê os dados de forma mais eficiente** e permite a leitura de **linhas inteiras** com o método `readLine()`.

#### Diferença entre `BufferedReader` e `FileReader`

- **`FileReader`** → Lê o arquivo **caractere por caractere**. Se usar apenas `FileReader`, precisaria fazer a leitura de cada caractere individualmente (como no primeiro exemplo que você enviou, onde usa `fr.read()` e verifica `!= -1`).
- **`BufferedReader`** → Usa um **buffer** para armazenar os dados e permite ler **uma linha inteira de uma vez** com `readLine()`, sem precisar processar caractere por caractere.

```java
File file = new File("file.txt");  
try(FileReader fr = new FileReader(file);  
    BufferedReader br = new BufferedReader(fr)){  
    String linha;  
    while((linha = br.readLine()) != null) {  
        System.out.println(linha);  
    }} catch (IOException e){  
    throw new RuntimeException(e);  
}
```

1. **Cria o arquivo** `file.txt`.
2. **Abre o `FileReader`**, que lê os dados do arquivo.
3. **Envolve o `FileReader` no `BufferedReader`**, que permite ler linhas inteiras.
4. **Usa `readLine()` para ler cada linha do arquivo** até encontrar `null` (fim do arquivo).
5. **Imprime cada linha na tela** (`System.out.println(linha)`).
6. **O bloco `try-with-resources` fecha automaticamente os recursos** (`FileReader` e `BufferedReader`).

### File para diretórios



  ```java
public class FileTest02 {  
    public static void main(String[] args) throws IOException {  
        File fileDiretorio = new File("pasta");  
        boolean isDiretorioCreated = fileDiretorio.mkdir();  
        System.out.println("Pasta criada ?" +isDiretorioCreated);  
        File fileArquivoDiretorio = new File(fileDiretorio, "arquivo.txt");  
        boolean isFileCreated = fileArquivoDiretorio.createNewFile();  
        System.out.println("arquivo.txt criado ?" +isFileCreated);  
  
        File fileRenamed = new File(fileDiretorio, "arquivo_renomeado.txt");  
        boolean isRenamed = fileArquivoDiretorio.renameTo(fileRenamed);  
        System.out.println("arquivo.txt renomeado ?" +isRenamed);  
  
        File diretorioRenamed = new File("pasta2");  
        boolean isDiretorioRenamed = fileDiretorio.renameTo(diretorioRenamed);  
        System.out.println("Diretório Pasta renomeado ?" +isDiretorioRenamed);  
    }}
```

A classe `File` não serve apenas para manipular arquivos, mas também para **criar, renomear e deletar diretórios**.

#### Principais funções para diretórios:

- **`mkdir()`** → Cria um **diretório (pasta)**. Retorna `true` se o diretório foi criado com sucesso.
- **`mkdirs()`** → Cria um diretório **e todos os diretórios pais necessários** (caso ainda não existam).
- **`renameTo(File destino)`** → Renomeia ou move um **arquivo ou diretório** para um novo local/nome.
- **`delete()`** → Remove um **arquivo ou diretório vazio**.

1. Cria a pasta `"pasta"` (`mkdir()`).
2. Dentro dessa pasta, cria o arquivo `"arquivo.txt"` (`createNewFile()`).
3. Renomeia `"arquivo.txt"` para `"arquivo_renomeado.txt"` (`renameTo()`).
4. Renomeia a pasta `"pasta"` para `"pasta2"` (`renameTo()`).

O `renameTo()` pode falhar se o diretório ou arquivo estiver sendo usado por outro programa ou se houver permissões restritas.


## NIO

### Path, Paths, Files

## Serialization

- **Serialização** é o processo de **transformar um objeto em uma sequência de bytes**, permitindo que ele seja **salvo em um arquivo**, **enviado pela rede** ou **armazenado de forma persistente**.
- Essa conversão é útil para preservar o **estado do objeto**, ou seja, os valores dos seus atributos naquele momento.
- O processo inverso, chamado de **desserialização**, reconstrói o objeto original a partir da sequência de bytes.
- Para que uma classe seja serializável, ela precisa **implementar a interface `Serializable`**.
- Durante a **desserialização**, o **construtor da classe não é chamado**, pois o Java recria o objeto diretamente a partir dos dados serializados.
- Não é legal para dados sensiveis, como senhas.

  ```java
public class Aluno implements Serializable {  
    private Long id;  
    private String nome;  
    private String password;
}

private static void serializar(Aluno aluno){  
    Path path = Paths.get("pasta2/aluno.ser");  
    try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))){  
        oos.writeObject(aluno);  
    } catch (IOException e) {  
        e.printStackTrace();  
    }}  
  
private static void deserializar(){  
    Path path = Paths.get("pasta2/aluno.ser");  
    try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))){  
        Aluno aluno = (Aluno) ois.readObject();  
        System.out.println(aluno);  
    } catch (IOException | ClassNotFoundException e) {  
        e.printStackTrace();  
    }}

```

- A classe `Aluno` implementa `Serializable`, permitindo que seus objetos sejam convertidos em bytes.
 
- O método `serializar()`:
    - Cria um caminho para o arquivo `aluno.ser`.
    - Usa `ObjectOutputStream` junto com `Files.newOutputStream()` para **gravar o objeto `aluno` em formato binário** no arquivo.
        
- O método `deserializar()`:
    - Lê o arquivo `aluno.ser` com `ObjectInputStream` e `Files.newInputStream()`.
    - Converte os bytes de volta para um objeto `Aluno` com `readObject()`.
    - Imprime o objeto no console.


#### transient

- Usamos quando **não queremos que um campo seja serializado**, como uma senha ou algo temporário.
- Ao marcar com `transient`, aquele campo será ignorado na hora de salvar e recuperar o objeto.
#### serialVersionUID

- Identificador de versão da classe serializável.
- Evita erros se a classe mudar entre salvar e ler o objeto.
- Pode ser gerado automaticamente pela IDE (geralmente mostra um aviso).
#### Como salvar um objeto que não é serializável

- Se você tem um campo que é um objeto **não serializável** (ex: `Turma`), precisa **escrever manualmente os dados dele**.
- Isso é feito com dois métodos especiais:
    - `writeObject` → escreve os dados manualmente.
    - `readObject` → lê os dados na **mesma ordem** e recria o objeto.
        
- Ex: se `Turma` tiver 15 atributos, você vai precisar escrever e ler todos eles, um por um, na ordem certa.

```java
private void writeObject(ObjectOutputStream oos){  
    try {  
        oos.defaultWriteObject();  
        oos.writeUTF(turma.getNome());  
    }catch (IOException e) {  
        e.printStackTrace();  
    }}  
private void readObject(ObjectInputStream ois){  
    try {  
        ois.defaultReadObject();  
        String nomeTurma = ois.readUTF();  
        turma = new Turma(nomeTurma);  
    }catch (IOException | ClassNotFoundException e) {  
        e.printStackTrace();  
    }}
```


## Coleções

### Equals

**Comparação com `equals()` e `==` em Java*

```java
String a = new String("oi");
String b = new String("oi");

System.out.println(a.equals(b)); // true
```

A classe `String` já sobrescreve o método `equals()` para comparar o conteúdo (os caracteres da string).  
Mesmo sendo objetos diferentes (`new String("oi")` cria dois objetos), como os valores são iguais, o `equals()` retorna `true`.


**Comparando objetos comuns (`Smartphone`, `Pessoa`, etc)**

```java
Smartphone s1 = new Smartphone("1ABC", "iPhone");
Smartphone s2 = new Smartphone("1ABC", "iPhone");

System.out.println(s1.equals(s2)); // false, se não sobrescrever
```
**
Por padrão, objetos usam o `equals()` da classe `Object`, que compara referências de memória, não os valores dos atributos.

| Tipo de comparação                     | Resultado         | Motivo                                       |
| -------------------------------------- | ----------------- | -------------------------------------------- |
| `String.equals()`                      | `true`            | Compara o conteúdo (valor dos caracteres)    |
| `==` com `String`                      | `false`           | Compara se são o mesmo objeto na memória     |
| `obj1.equals(obj2)` (sem sobrescrever) | `false`           | Compara referências de memória               |
| `obj1.equals(obj2)` (com sobrescrita)  | `true` ou `false` | Depende da lógica implementada em `equals()` |

#### Sobrescrita de `equals()` com regras do contrato

##### Contrato do método `equals()` (segundo a documentação do Java)

- **Reflexivo**: `x.equals(x)` deve retornar `true` se `x` for diferente de `null`.
- **Simétrico**: se `x.equals(y)` for `true`, então `y.equals(x)` também deve ser `true`.
- **Transitivo**: se `x.equals(y)` e `y.equals(z)` forem `true`, então `x.equals(z)` também deve ser.
- **Consistente**: várias chamadas de `x.equals(y)` devem sempre retornar o mesmo valor, desde que `x` e `y` não mudem.
- **`null`**: qualquer objeto diferente de `null` deve retornar `false` ao ser comparado com `null`. Ou seja, `x.equals(null)` deve ser `false`.

```java
@Override
public boolean equals(Object obj) {
    if (obj == null) return false; // null-check
    if (this == obj) return true; // mesmo objeto na memória
    if (this.getClass() != obj.getClass()) return false; // objetos de classes diferentes
    Smartphone smartphone = (Smartphone) obj;
    return serialNumber != null && serialNumber.equals(smartphone.serialNumber);
}
```

No método `equals()`, o objeto que vem como argumento (`obj`) é o que será comparado, e o `this` é o objeto atual usado como referência para a comparação. A lógica define se `this` é "igual" ao `obj`.

**O que essa implementação faz:**
- Verifica se `obj` é `null`.
- Verifica se `this` e `obj` são o mesmo objeto na memória.
- Verifica se são da mesma classe.
- Compara o atributo `serialNumber` dos dois objetos, desde que ele não seja `null`.

```java
Smartphone s1 = new Smartphone("1ABC", "iPhone");
Smartphone s2 = new Smartphone("1ABC", "iPhone");

System.out.println(s1.equals(s2)); // true
```

Mesmo sendo dois objetos diferentes na memória, como têm o mesmo `serialNumber` e o método `equals()` foi sobrescrito para comparar isso, o resultado é `true`.

### Hashcode

- O método `hashCode()` gera um valor numérico (int) que o Java usa para indexar objetos em coleções baseadas em hash, como `HashMap`, `HashSet` e `Hashtable`.
- Esse valor funciona como um "endereço" para armazenar e buscar objetos mais rapidamente.
- Esse número **não precisa ser único**, mas quanto mais distribuído, melhor a performance.
- Quando ocorre uma **colisão** (dois objetos com o mesmo hash), o Java usa o `equals()` para verificar se são realmente iguais.
#### Regra de ouro com `equals()`:
- Se dois objetos são iguais segundo `equals()`, eles **devem** ter o mesmo `hashCode()`.
- Mas dois objetos com o mesmo `hashCode()` **podem não ser iguais** se `equals()` retornar `false`.
#### Contrato entre `equals()` e `hashCode()`
- Se `x.equals(y) == true`, então `x.hashCode() == y.hashCode()` → obrigatório
- Se `x.hashCode() == y.hashCode()`, isso **não garante** que `x.equals(y)` será `true` → pode haver colisão
- Se `x.equals(y) == false`, o ideal é que `x.hashCode() != y.hashCode()` → melhora a performance, mas não é obrigatório

```java
String a = "FB";
String b = "Ea";

System.out.println(a.hashCode()); // 2236
System.out.println(b.hashCode()); // 2236
System.out.println(a.equals(b));  // false
```
Mesmo `hashCode`, mas conteúdos diferentes → `equals()` retorna `false`.

### Complexidade Big-O

![[Pasted image 20250415111521.png]]
### Ordered vs Sorted

- **Ordered**: os elementos mantêm a ordem em que foram adicionados.  
    Ex: `List` (como `ArrayList`) → se você adiciona A, B, C, eles ficam nessa ordem.
    
- **Sorted**: os elementos são organizados automaticamente por algum critério (natural ou definido por `Comparator`).  
    Ex: `TreeSet` → organiza os elementos em ordem crescente por padrão (por exemplo, 1, 2, 3 ao invés de 3, 1, 2).

### Big-O (Complexidade)

- Representa o **custo de desempenho** de uma operação (tempo ou memória).
- Mostra **como o algoritmo escala** com o número de elementos (`n`).
- Exemplo:
    - `O(1)`: tempo constante → super rápido
    - `O(n)`: cresce linearmente
    - `O(log n)`: divide e conquista → eficiente
    - `O(n²)`: cresce rápido → ruim para listas grandes

### List

- É uma coleção ordenada, possui sequencia. Coleção ordenada de elementos que pode conter duplicatas
- Não é possível criar coleções com tipos primitivos, somente se forem objetos.

```java
List<String> nomes = new ArrayList<>();
```

`List<String>`: Define uma lista de objetos do tipo String. É uma interface que pode ser implementada por diferentes classes, como o ArrayList.
`new ArrayList<>():` Cria uma nova instância de ArrayList, que é uma implementação da interface List.

- **`nomes.get(i)`**: Acessa o elemento da lista na posição `i`.
- **`nomes.size()`**: Retorna o tamanho da lista, usado para controlar o loop.
- `nomes.remove(0);` : remove o elemento no índice 0 da lista (ou um objeto, se passado diretamente).
- `nomes.addAll(nomes2);` : adiciona todos os elementos da lista `nomes2` à lista `nomes`
- `nomes.contains("Alberto");` → verifica se o elemento `"Alberto"` está presente na lista, retornando `true` ou `false`.
- `nomes.indexOf("Alberto");` → retorna o índice do primeiro elemento `"Alberto"` na lista (ou `-1` se não encontrar).
- `nomes.add(1, "Carlos");` → insere o elemento `"Carlos"` na posição de índice 1, deslocando os demais para a direita.

### Sorting lists

#### Comparable
O método `compareTo` da interface `Comparable` serve justamente para **definir como os objetos de uma classe serão comparados entre si**. Ele determina a **ordem natural** da sua classe.
A **função do `compareTo`** é dizer **qual critério será usado** para comparar dois objetos (por exemplo, por `id`, `nome`, `preço` etc.).

```java
@Override
public int compareTo(Manga outroManga) {
    return this.id.compareTo(outroManga.getId());
}
```
Está dizendo: "Quero que os objetos `Manga` sejam comparados pela ordem crescente do `id`."
Se quiser mudar isso para comparar por `nome`, basta alterar o `compareTo`:

```java
return this.nome.compareTo(outroManga.getNome());
```

#### Comparator
- Interface usada para criar **ordens alternativas**.
- **Não precisa** ser implementada na própria classe.
- Usa o método `compare`.
- Útil quando você quer ordenar os objetos por diferentes critérios, sem mudar a classe.
```java
class MangaByIdComparator implements Comparator<Manga> {
    @Override
    public int compare(Manga manga1, Manga manga2) {
        return manga1.getId().compareTo(manga2.getId());
    }
}

//Collections.sort(mangas, new MangaByIdComparator());
mangas.sort(new MangaByIdComparator());
```


- **Comparable**: define **uma única forma padrão** de comparar objetos, implementada na própria classe.
- **Comparator**: permite **múltiplas formas de comparação** sem alterar a classe original.

### Binary Search
- A **lista precisa estar ordenada** previamente, com base no mesmo critério que será usado na busca.
- A busca é feita de forma **binária**, o que garante desempenho mais rápido que uma busca linear (O(log n) em vez de O(n)).
- Se o elemento **for encontrado**, retorna o **índice** do item na lista.
- Se **não for encontrado**, retorna o valor **`-(ponto de inserção) - 1`**, que indica onde o elemento _poderia_ ser inserido para manter a ordem.

```java
Collections.binarySearch(mangas, mangaToSearch, mangaByIdComparator);
```

1. **`mangas`**  
    → A lista onde será feita a busca.  
    **Importante:** essa lista **precisa estar ordenada** com base no comparador fornecido.
2. **`mangaToSearch`**  
    → O objeto que você está tentando encontrar.  
    Precisa ser um objeto válido, com os mesmos atributos usados na comparação.
3. **`mangaByIdComparator`**  
    → O comparador que define o critério de ordenação e comparação (nesse caso, por `id`).  
    Esse comparador deve ser o **mesmo usado na ordenação** da lista.


### Conversão de Lista para Arrays e vice versa

#### 1. Lista → Array
```java
List<Integer> numeros = new ArrayList<>(); 
numeros.add(1); 
numeros.add(2); 
numeros.add(3); 
Integer[] listToArray = numeros.toArray(new Integer[0]);`
```
- `toArray(new Integer[0])` converte a lista para um array do mesmo tipo.
- O array gerado **não tem ligação com a lista**.
- Alterações em um **não afetam** o outro.


#### 2. Array → Lista (usando `Arrays.asList`)

```java
Integer[] numerosArray = {1, 2, 3}; 
List<Integer> arrayToList = Arrays.asList(numerosArray); 
arrayToList.set(0, 12);
```
- Cria uma **lista com tamanho fixo**, baseada no array.
- Tomar cuidado pois são linkados.
- A lista e o array compartilham os mesmos dados:
    - `arrayToList.set(0, 12);` também altera `numerosArray[0]`.

- **Não é possível adicionar nem remover elementos** dessa lista:

```java
arrayToList.add(99); // lança UnsupportedOperationException
```

#### 3. Array → Lista flexível (independente)

```java
List<Integer> numerosList = new ArrayList<>(Arrays.asList(numerosArray));
numerosList.add(15);
```

- Cria uma nova lista baseada no array, mas agora do tipo `ArrayList`.
- Totalmente independente do array original.
- Permite adicionar e remover elementos normalmente.

### Iterator
```java
Iterator<Manga> mangaIterator = mangas.iterator();
while (mangaIterator.hasNext()) {
    if (mangaIterator.next().getQuantidade() == 0) {
        mangaIterator.remove();
    }
}
```

- Um `Iterator` é criado para percorrer a lista.
- A cada elemento, `hasNext()` verifica se há mais um item.
- `next()` acessa o próximo `Manga`.
- Se a condição for verdadeira (`quantidade == 0`), `remove()` **remove com segurança** o item atual da lista.
    
✅ **Vantagens**:
- Seguro para remoção durante a iteração.
- Funciona em qualquer versão do Java.
⚠️ **Desvantagem**:
- Mais verboso e exige mais linhas de código.

Usando `removeIf()` (forma moderna)
```java
mangas.removeIf(manga -> manga.getQuantidade() == 0);
```

- `removeIf()` percorre a lista internamente.
- Para cada item, avalia a condição (`quantidade == 0`).
- Remove automaticamente os que satisfazem a condição.

✅ **Vantagens**:
- Mais limpo e direto.
- Internamente é seguro, não lança exceção de modificação.
- Leitura e manutenção mais fáceis.

⚠️ **Desvantagem**:
- Requer Java 8 ou superior.

### Set, HashSet

- `Set<Manga>` é uma **interface** — você está dizendo: “vou guardar mangás, e **não quero duplicados**”.
- `HashSet<>` é a implementação: **não mantém ordem**, e **não aceita duplicatas** (com base no `equals()` e `hashCode()` da classe `Manga`).
- Se você quiser **garantir que não haja mangás repetidos**, `Set` é o caminho certo.
- Se quiser **manter a ordem de inserção**, troque `HashSet` por `LinkedHashSet`.
- E lembre-se: o comportamento de "não adicionar duplicado" só funciona se a classe `Manga` **sobrescrever corretamente os métodos `equals()` e `hashCode()`**.

|Item|Função|
|---|---|
|`Set`|Interface que **não permite elementos duplicados**|
|`HashSet`|Implementação que **não mantém ordem de inserção**|
|`add()`|Adiciona elementos, mas ignora os duplicados com base em `equals()` e `hashCode()`|
|`for-each`|Usado para **percorrer e exibir** todos os elementos do Set|

### NavigableSet, TreeSet

- A interface `Navigable` adiciona métodos que permitem acessar elementos com base em posições relativas a outros elementos já existentes.
- As classes com nome iniciado em `Tree` (como `TreeSet` e `TreeMap`) armazenam os elementos em ordem (sorted).
- Para que os elementos possam ser ordenados, eles devem implementar a interface `Comparable` **ou** você deve fornecer um `Comparator` ao criar a estrutura.
- Quando um elemento é inserido em uma estrutura como `TreeSet`, ela automaticamente reorganiza os elementos com base na ordem definida pelo `compareTo` (via `Comparable`) ou pelo `Comparator` fornecido.
- Estruturas como `TreeSet` **não permitem elementos duplicados**.
- O `TreeSet` **não utiliza o método `equals()` para verificar duplicatas**, diferentemente de outras implementações de `Set`. Por isso, se dois objetos tiverem o mesmo valor de comparação (ex: mesmo preço), mesmo que tenham outros atributos diferentes (como nome ou ID), o `TreeSet` os considerará duplicados e **não os adicionará**.
- `descendingSet()` → retorna uma visão do conjunto em ordem decrescente
- `lower(e)` → retorna o elemento **imediatamente menor** que `e`
- `floor(e)` → retorna o **maior elemento menor ou igual** a `e`
- `higher(e)` → retorna o elemento **imediatamente maior** que `e`
- `ceiling(e)` → retorna o **menor elemento maior ou igual** a `e`
- `pollFirst()` → retorna e **remove o primeiro elemento** do conjunto (menor)
- `pollLast()` → retorna e **remove o último elemento** do conjunto (maior)

### Map, HashMap, LinkedHashMap
- `Map` trabalha com **pares de chave e valor**.
- Diferente do `Set`, o `Map` **permite chaves duplicadas**, mas:
    - Ao inserir uma chave já existente com `put()`, o valor anterior é **sobrescrito**.
- O método `putIfAbsent(chave, valor)`:
    - Só adiciona o par se a **chave ainda não estiver presente** no mapa.
    - Evita sobrescrita de valores já existentes.
- `keySet()` → retorna um `Set` com todas as **chaves** do mapa
- `values()` → retorna uma `Collection` com todos os **valores** do mapa
- `entrySet()` → retorna um `Set` com todos os pares **chave-valor** do mapa (como `Map.Entry`)

```java
for (String key : map.keySet()){  
    System.out.println(key + " = "+ map.get(key));  
}  
System.out.println("-----");  
  
for (String value : map.values()){  
    System.out.println(value);  
}  
  
System.out.println("-----");  
for (Map.Entry<String, String> entry : map.entrySet()){  
    System.out.println(entry.getKey() + " - " +entry.getValue());  
}
```

Associação entre dois objetos

```java
Consumidor consumidor1 = new Consumidor("Alberto");
Consumidor consumidor2 = new Consumidor("DevMagro");
Manga manga1 = new Manga(5L, "Naruto", 19.9);
Manga manga3 = new Manga(4L,"Attack on titan", 3.2);
```
- Aqui são criados dois objetos do tipo `Consumidor`.
- Cada um recebe um nome através do construtor.
- Esses objetos serão usados como **chave** no `Map`.
- Dois objetos do tipo `Manga` são criados.
- Cada um tem um id, um nome e um preço.
- Esses objetos serão usados como **valor** no `Map`.

```java
Map<Consumidor, Manga> consumidorManga = new HashMap<>();
consumidorManga.put(consumidor1, manga1);
consumidorManga.put(consumidor2, manga3);
```

- Um `HashMap` é criado com a chave do tipo `Consumidor` e o valor do tipo `Manga`.
- O método `put` associa:
    - `consumidor1` → `manga1`
    - `consumidor2` → `manga3`

```java
for (Map.Entry<Consumidor, Manga> entry : consumidorManga.entrySet()) {
    System.out.println(entry.getKey().getNome() + " - " + entry.getValue().getNome());
}
```

- `entrySet()` retorna todos os pares chave-valor do mapa.
- Cada `entry` representa um par `Consumidor → Manga`.
- `entry.getKey().getNome()` acessa o nome do consumidor.
- `entry.getValue().getNome()` acessa o nome do mangá.
- O `System.out.println` imprime a associação, exemplo:  
    `Alberto - Naruto`

E oque fazer quando por exemplo, um consumidor, compra vários mangas? 
```java
List<Manga> mangaConsuimidor1List = List.of(manga1, manga2, manga3);
List<Manga> mangaConsuimidor2List = List.of(manga3, manga4, manga5);
```
- Aqui são criadas duas listas de mangás usando `List.of(...)`.
- Cada lista representa os mangás associados a um consumidor.
- `mangaConsuimidor1List` contém: `manga1`, `manga2`, `manga3`
- `mangaConsuimidor2List` contém: `manga3`, `manga4`, `manga5`
```java
Map<Consumidor, List<Manga>> consumidorMangaMap = new HashMap<>();
consumidorMangaMap.put(consumidor1, mangaConsuimidor1List);
consumidorMangaMap.put(consumidor2, mangaConsuimidor2List);
```
- Um `Map` é criado onde:
    - A **chave** é um `Consumidor`
    - O **valor** é uma `List<Manga>`
- Ou seja, cada consumidor está associado a **vários mangás**.
- `put(consumidor1, lista)` adiciona a lista de mangás do consumidor 1 ao mapa.
- `put(consumidor2, lista)` faz o mesmo para o consumidor 2.

```java
for (Map.Entry<Consumidor, List<Manga>> entry : consumidorMangaMap.entrySet()) {
    System.out.println("---" + entry.getKey().getNome());
    for (Manga manga : entry.getValue()) {
        System.out.println("-----" + manga.getNome());
    }
}
```

- `entrySet()` percorre todos os pares `Consumidor → List<Manga>`.
- `entry.getKey().getNome()` pega o nome do consumidor.
- `entry.getValue()` retorna a lista de mangás daquele consumidor.
- Um segundo `for` percorre essa lista.
- `manga.getNome()` imprime o nome de cada mangá da lista.


### NavigableMap, TreeMap
- `TreeMap` implementa `NavigableMap`, por isso possui métodos adicionais para **navegar entre as chaves** de forma ordenada.
- A ordenação é feita com base na **chave**, não no valor.
- Para funcionar corretamente:
    - A **chave precisa ser comparável** (`Comparable`)
    - Ou deve ser fornecido um `Comparator` no construtor do `TreeMap`
- **A ordenação é automática** sempre que um novo par chave-valor é inserido.
- `lower(e)` → retorna a **maior chave estritamente menor** que `e`
- `floor(e)` → retorna a **maior chave menor ou igual** a `e`
- `higher(e)` → retorna a **menor chave estritamente maior** que `e`
- `ceiling(e)` → retorna a **menor chave maior ou igual** a `e`
- `pollFirst()` → retorna e **remove o primeiro par (menor chave)** do mapa
- `pollLast()` → retorna e **remove o último par (maior chave)** do mapa
- `headMap(e)` → retorna uma **visão do mapa com todas as chaves menores que `e`**
    - `headMap(e, true)` → inclui `e` na visão
- `tailMap(e)` → retorna uma **visão com todas as chaves maiores ou iguais a `e`**
    - `tailMap(e, false)` → exclui `e` da visão
- `subMap(e1, e2)` → retorna um **submapa com as chaves entre `e1` (inclusivo) e `e2` (exclusivo)**
    - Também pode usar as versões com controle de inclusão/exclusão nas extremidades

### Queue, PriorityQueue
- `Queue` é uma **fila**, ou seja, segue a lógica **FIFO** (First In, First Out) — o primeiro a entrar é o primeiro a sair.
    - Exemplo: fila de banco, fila de impressão.
- `PriorityQueue` é uma implementação de `Queue` onde os elementos são **priorizados por ordem natural** ou por um `Comparator` personalizado.
    - Ou seja, **não segue obrigatoriamente a ordem de inserção**, e sim uma **ordem definida por prioridade**.
- Os elementos precisam ser **comparáveis** (`Comparable`)
    - Ou você deve passar um `Comparator` no construtor.
- Se não houver ordenação definida e os elementos não forem comparáveis, ocorre `ClassCastException`.

- `add(e)` → adiciona o elemento à fila. Lança exceção se não for possível.
- `offer(e)` → adiciona o elemento à fila. Retorna `false` se não for possível (mais seguro).
- `peek()` → retorna o primeiro elemento da fila, **sem remover**. Retorna `null` se estiver vazia.
- `element()` → semelhante ao `peek()`, mas lança exceção se estiver vazia.
- `poll()` → retorna e **remove** o primeiro elemento da fila. Retorna `null` se estiver vazia.
- `remove()` → retorna e **remove** o primeiro elemento da fila. Lança exceção se estiver vazia.


## Generics
- **Generics** permitem que você **escreva classes, interfaces e métodos que funcionam com tipos diferentes**, mantendo **segurança de tipo** em tempo de compilação.
- Eles ajudam a **evitar casts explícitos** e **erros de tipo** em tempo de execução.

```java
// Sem generics
List lista = new ArrayList();
lista.add("Texto");
String s = (String) lista.get(0); // cast obrigatório

// Com Generics:

List<String> lista = new ArrayList<>();
lista.add("Texto");
String s = lista.get(0); // sem cast
```

### Wildcard
- **Mais segurança em tempo de compilação:**
    - Se tentar adicionar algo que não seja `String` na lista acima, o compilador já acusa erro.
- **Código mais reutilizável e legível**
- **Type Erasure** (ou "remoção de tipo") é o processo pelo qual o **compilador Java remove as informações genéricas** em tempo de **compilação**.
	 * Em outras palavras: **o tipo genérico existe só em tempo de compilação**, mas **não em tempo de execução**.

```java
// Exemplo simples
List<String> lista = new ArrayList<>();
lista.add("Olá");

// Na hora de compilar, o Java transforma isso em algo como:

List lista = new ArrayList();
lista.add("Olá");

// Ou seja, **o tipo `String` foi apagado**. Isso é o _type erasure_.
```

- **Type Erasure** permite que o Java use Generics **sem mudar a JVM**.
- Garante **compatibilidade com versões antigas**.
- Mas **impõe limitações** como:
    - Não poder criar arrays genéricos
    - Não poder acessar tipo genérico em tempo de execução
    - Restrições em sobrecarga de métodos


```java
private static void printConsulta(List<? extends Animal> animals)
// Pode receber animal ou qualquer um que seja filho
```
- `?` é o **WildCard** (curinga).
- Com `? extends Animal`, estamos dizendo que ele aceita **qualquer tipo que estenda Animal** (como `Cachorro`, `Gato`, etc.).
- Ao fazer isso, você **assina um contrato de somente leitura** — ou seja, **não pode adicionar elementos** à lista (nem mesmo `Animal`).
- Isso acontece porque o compilador **não consegue garantir o tipo exato** da lista.
- A única palavra relacionada à herança que pode ser usada com WildCard é `extends`.

```java
private static void printConsultaAnimal(List<? super Cachorro> animals)
// Pode receber animal ou qualquer um que seja pai

animals.add(new Cachorro());  
animals.add(new Gato());
```
- Com `? super Cachorro`, estamos dizendo que a lista aceita **Cachorro ou qualquer supertipo dele** (por exemplo, `Animal` ou `Object`).
- Aqui, é possível **adicionar objetos do tipo Cachorro (ou subclasses)** com segurança.
- Isso é permitido porque o compilador **sabe que a lista é genérica o suficiente para aceitar qualquer Cachorro**.
- A leitura, por outro lado, é mais limitada — o tipo retornado será tratado como `Object`, já que o compilador **não sabe o tipo exato da lista**.


###  Classes Genéricas

#### 1. Criando listas de objetos
```java
List<Carro> carrosDisponiveis = new ArrayList<>(List.of(...));
List<Barco> barcosDisponiveis = new ArrayList<>(List.of(...));
```

- Duas listas são criadas: uma com objetos `Carro`, outra com `Barco`.
- Ambas vão servir como **estoques de objetos para alugar**.

#### 2. Criando o serviço genérico de aluguel
```java
RentalService<Carro> rentalService = new RentalService<>(carrosDisponiveis);
```

- Aqui é onde entra o **poder dos generics**.
- `RentalService<T>` é uma **classe genérica**, que nesse caso está sendo usada como `RentalService<Carro>`.
- Isso significa que a instância só aceitará e trabalhará com objetos do tipo `Carro`.

#### 3. Alugando e devolvendo um carro
```java
Carro carro = rentalService.buscarObjetoDisponivel();
System.out.println("Usando carro por um mês...");
rentalService.retornarObjetoAlugado(carro);
```

- O método `buscarObjetoDisponivel()` **remove o primeiro item da lista** e retorna.
- `retornarObjetoAlugado()` **adiciona o objeto devolvido** de volta à lista.

#### 4. Repetindo o processo com outro tipo (`Barco`)
```java
RentalService<Barco> rentalService2 = new RentalService<>(barcosDisponiveis);
Barco barco = rentalService2.buscarObjetoDisponivel();
System.out.println("Usando barco por um mês...");
rentalService2.retornarObjetoAlugado(barco);
```

- A **mesma lógica é reaproveitada**, mas com outro tipo (`Barco`) sem precisar escrever a lógica de novo.
- Isso mostra a **reutilização de código com segurança de tipo** graças aos **generics**.

#### A classe `RentalService<T>` (explicação do funcionamento)
```java
public class RentalService<T> {  
    private List<T> objetosDisponiveis;  
  
    public RentalService(List<T> objetosDisponiveis) {  
        this.objetosDisponiveis = objetosDisponiveis;  
    }  
    public T buscarObjetoDisponivel(){  
        System.out.println("Buscando objeto disponível...");  
        T t = objetosDisponiveis.remove(0);  
        System.out.println("Alugando objeto: "+t);  
        System.out.println("Objetos disponiveis para alugar: ");  
        System.out.println(objetosDisponiveis);  
        return t;  
    }  
    public void retornarObjetoAlugado(T t){  
        System.out.println("Devolvendo objeto" +t);  
        objetosDisponiveis.add(t);  
        System.out.println("Objetos disponiveis para alugar: ");  
        System.out.println(objetosDisponiveis);  
    }}
```


A classe `RentalService<T>` usa o tipo genérico `T`, permitindo gerenciar o aluguel de qualquer tipo de objeto (como `Carro`, `Barco`, etc.).
- **`objetosDisponiveis`**: uma lista de objetos disponíveis para aluguel.
- **Construtor**: recebe a lista de objetos e a armazena.
- **`buscarObjetoDisponivel()`**: aluga um objeto, removendo-o da lista.
- **`retornarObjetoAlugado(T t)`**: devolve o objeto, adicionando-o de volta à lista.

Exemplo:
- Com `RentalService<Carro>`, você pode alugar e devolver carros, sem precisar duplicar o código para outros tipos de objetos.

###  Métodos Genéricos

```java
private static <T> List<T> criarArrayComObjeto(T t){
    return List.of(t);
}
```

- **`<T>` antes do retorno (`List<T>`)**: indica que o método é genérico e pode trabalhar com qualquer tipo `T`.
- **`T t`**: parâmetro do tipo genérico.
- **`List.of(t)`**: retorna uma lista imutável contendo apenas o objeto `t`.

```java
List<Barco> barcoList = criarArrayComObjeto(new Barco("Canoa marota"));
```

Você passa um `Barco`, e o método retorna uma `List<Barco>` automaticamente, sem precisar informar o tipo — o compilador infere.

Esse método genérico serve para **criar uma lista com qualquer tipo de objeto**, mantendo o tipo da lista. É reutilizável e seguro, sem precisar repetir código para cada tipo (Barco, Carro, etc.).

## Classes Internas
Uma **classe interna** (ou _inner class_) é uma classe definida **dentro de outra classe**. Elas são úteis quando a classe interna **está diretamente relacionada** à externa — por exemplo, quando ela depende de informações da classe externa, como o atributo `name` no código.

```java
private String name = "Naruto Uzumaki";

class Inner {
    public void printOuterClassAttribute(){
        System.out.println(name);
    }
}

public static void main(String[] args) {
    OuterClassesTest01 outerClass = new OuterClassesTest01(); // 1
    Inner inner = outerClass.new Inner();                     // 2
    inner.printOuterClassAttribute();                         // 3
}
```

- `outerClass.new Inner()` cria **uma instância da classe interna** associada a **uma instância da classe externa** (`outerClass`).
- Isso é necessário porque a classe `Inner` **não é estática**, então ela precisa de um "contexto" da instância externa para existir.
- A classe interna tem acesso direto aos membros da classe externa, mesmo os `private`, como o `name`.

### Classes Locais
Uma **classe local** é uma classe **declarada dentro de um método**, e não diretamente dentro da classe externa. Ela só existe dentro daquele **bloco de código** e **não pode ser usada fora dele**.
```java
void print(){
    final String lastName = "Izuku";

    class LocalClass {
        public void printLocal(){
            System.out.println(name + " " + lastName);
        }
    }

    new LocalClass().printLocal();
}
```

- `LocalClass` é uma **classe local**, definida dentro do método `print()`.
- Ela **acessa dois dados externos**:
    - `name`: atributo da classe externa (`OuterClassesTest02`).
    - `lastName`: variável **local do método**, que precisa ser **final ou efetivamente final** (ou seja, que não muda após ser definida).
- Cria e usa a classe com:  
    `new LocalClass().printLocal();`

- **Só são visíveis dentro do método onde foram declaradas.**
- **Podem acessar membros da classe externa.**
- **Podem acessar variáveis locais apenas se forem `final` ou efetivamente finais.**
- São **muito usadas quando você quer encapsular lógica específica** que não precisa estar visível fora daquele método (ex: validações, formatadores, classes auxiliares).

### Classes Anônimas
Uma **classe anônima** é uma classe **sem nome** que você **cria e instancia ao mesmo tempo**.
- Ela geralmente é usada **para sobrescrever métodos rapidamente**, **sem precisar criar uma classe nova separada** no seu arquivo.
- A gente usa muito classe anônima para **customizar comportamento de uma forma leve e rápida**, especialmente em:
    - Sobrescrita de métodos
    - Listeners de eventos (ex: botões, menus)
    - Comparadores, filtros, tarefas assíncronas

```java
class Animal {  
    public void walk(){  
        System.out.println("Animal walking");  
    }}  
  
public class AnonymousClassesTest01 {  
    public static void main(String[] args) {  
        Animal animal = new Animal(){  
            @Override  
            public void walk() { 
                System.out.println("Walking in the shadows");  
            }        
            };        
            animal.walk();  
    }
```

O que está acontecendo:
- Você criou **uma subclasse de `Animal` na hora** (mas sem dar nome pra ela).
- E **sobrescreveu** o método `walk()`.
- Quando você chama `animal.walk()`, **ele executa a versão da classe anônima** e não a versão original da classe `Animal`.
    
**Você muda o comportamento do objeto na hora**, de forma leve e prática, sem precisar criar uma classe nova lá em cima.

```java
barcoList.sort(new Comparator<Barco>() {
    @Override
    public int compare(Barco o1, Barco o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
});
```

- Você precisava de um jeito de comparar barcos (`Barco`) para ordenar a lista.
- Criou **um novo `Comparator<Barco>` anônimo**, ali na hora dentro do `sort()`.
- O método `compare` foi sobrescrito pra dizer como dois barcos devem ser comparados (baseado no nome deles).
    
 **Você cria o comparador e já usa ele**, sem criar uma classe separada (`BarcoNameComparator`) como no primeiro trecho.
### Classes aninhadas estáticas

Uma **classe aninhada estática** (`static class`) é **uma classe dentro de outra classe**, **mas que é independente da instância da classe externa**.
- **Não precisa criar um objeto da classe de fora** para usar a classe de dentro.
- **Só pode acessar membros `static` diretamente** da classe externa.
- Pode ser vista quase como uma "classe normal", **mas organizada dentro da outra** por questões de estrutura.

```java
public class OuterClassesTest03 {
    private String name = "Pedro";

    static class Nested {
        private String lastName = "Brabo";
        void print() {
            System.out.println(new OuterClassesTest03().name + " "+lastName);
        }
    }

    public static void main(String[] args) {
        Nested nested = new Nested();
        nested.print();
    }
}
```

- `Nested` é uma **classe aninhada estática** (porque tem `static` antes do `class`).
- No método `print()` da `Nested`, você vê que **para acessar `name` (não estático)**, foi necessário fazer `new OuterClassesTest03().name`.
- Ou seja, a `Nested` **não tem acesso direto a atributos não estáticos** da `OuterClassesTest03`.

- **Classe interna normal**: é tipo uma criança que **só existe porque tem a mãe do lado**.
- **Classe aninhada estática**: é tipo um sobrinho que **pode visitar quando quiser, mas vive independente**.

### Parametrizando comportamentos

Parametrizar comportamento significa tornar métodos mais flexíveis, permitindo que **a lógica (comportamento)** que será executada dentro deles seja passada como **parâmetro**.

Em vez de escrever métodos com comportamentos fixos (como "filtrar apenas carros verdes" ou "filtrar apenas por ano"), podemos **passar o comportamento desejado como argumento**, permitindo reuso e eliminação de código duplicado.

Sem parametrização, acabamos escrevendo vários métodos semelhantes, que mudam apenas na condição de filtragem. Isso gera:
- Código repetitivo.
- Pouca flexibilidade.
- Dificuldade de manutenção e expansão.
    
Com parametrização de comportamento:
- Escrevemos menos código.
- Tornamos os métodos genéricos e reutilizáveis.
- Aplicamos o princípio **Open/Closed**: o código está aberto para extensão, mas fechado para modificação.

Java permite parametrizar comportamento usando **interfaces funcionais**, como a `Predicate<T>`, e **expressões lambda**.

#### Interface funcional: `Predicate<T>`
```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```

Um `Predicate` representa um teste booleano que recebe um valor do tipo `T` e retorna `true` ou `false`.


Exemplo: método genérico com comportamento parametrizado
```java
private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
    List<T> filteredList = new ArrayList<>();
    for (T element : list) {
        if (predicate.test(element)) {
            filteredList.add(element);
        }
    }
    return filteredList;
}
```
Este método recebe uma lista de qualquer tipo `T` e uma lógica (`predicate`) que define **quais elementos devem ser mantidos**.


#### Formas de passar o comportamento

```java
// 1. Classe concreta



public class CarColorGreenPredicate implements Predicate<Car> {     
public boolean test(Car car) {         
	return car.getColor().equals("green");     
	} 
} 
List<Car> greenCars = filter(cars, new CarColorGreenPredicate());`

// 2. Classe anônima


List<Car> greenCars = filter(cars, new Predicate<Car>() {     
	public boolean test(Car car) {         
		return car.getColor().equals("green");     
} 
});`

// 3. Expressão lambda (forma mais moderna)

List<Car> greenCars = filter(cars, car -> car.getColor().equals("green")); List<Car> redCars = filter(cars, car -> car.getColor().equals("red")); List<Car> oldCars = filter(cars, car -> car.getYear() < 2015); List<Integer> pares = filter(nums, n -> n % 2 == 0);
```

- O mesmo método `filter()` serve para qualquer tipo de lista (`List<T>`) e qualquer lógica.
- Isso evita criação de métodos como `filterGreenCar()`, `filterRedCar()`, `filterByYear()`, etc.
- Deixa o código muito mais limpo, genérico e reutilizável.


## Lambdas

Quando usamos **lambdas** em Java, precisamos de uma **interface funcional**, ou seja, uma interface que possua **apenas um método abstrato**. Um exemplo comum é a `Predicate<T>`.

Lambdas são **funções anônimas** que permitem escrever comportamentos de forma mais concisa, sem precisar criar classes anônimas ou concretas.

`(parâmetro) -> expressão`
`(Car car) -> car.getColor().equals("green")`

Esse lambda implementa o método da interface `Predicate<Car>`, retornando `true` ou `false` com base na condição.

Qualquer interface funcional pode ser usada com lambdas, e o **tipo de retorno** depende do que a interface espera. O compilador infere os tipos com base no contexto.


A interface `Predicate<T>` representa uma **função que recebe um objeto do tipo `T` e retorna um `boolean`**.

Ou seja, ela serve para **testar uma condição** sobre um objeto. Muito usada para filtros, validações e decisões lógicas.

```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}

Predicate<Car> isGreen = car -> car.getColor().equals("green");
```

### O que é `Consumer<T>`?

Esse código mostra o uso da interface funcional `Consumer<T>` com **expressões lambda** para executar uma ação sobre cada elemento de uma lista.

#### Objetivo do método:

```java
private static <T> void forEach(List<T> list, Consumer<T> consumer)
```

Esse método genérico percorre qualquer lista (`List<T>`) e aplica uma ação em cada elemento, usando o `Consumer<T>` passado como parâmetro.


É uma interface funcional que recebe um valor do tipo `T` e **executa alguma ação**, sem retornar nada. Seu único método é:

`void accept(T t);`

 Como o comportamento é passado?

`forEach(strings, s -> System.out.println(s));`

A expressão lambda `s -> System.out.println(s)` implementa o método `accept` da interface `Consumer<String>`. Ou seja, está dizendo: "para cada string, imprima ela no console".

A mesma lógica se aplica para a lista de inteiros:

`forEach(integers, i -> System.out.println(i));`

#### ✅ O que esse código mostra?

- **Parametrização de comportamento**: o método `forEach` não está fixo para uma única ação — ele recebe a ação como parâmetro.
- **Uso de `Consumer` com lambda**: comportamento passado de forma concisa.
- **Código genérico e reutilizável**: funciona com qualquer tipo de lista (`String`, `Integer`, `Car`, etc).

### O que faz a interface `Function<T, R>`

A interface `Function<T, R>` representa uma função que **recebe um valor do tipo `T` e retorna um resultado do tipo `R`**. Ela é usada quando queremos **transformar dados**.

#### Assinatura:

```java
@FunctionalInterface 
public interface Function<T, R> {     
	R apply(T t); 
}
```
- `T` = tipo de entrada
- `R` = tipo de retorno
-
```java
private static <T, R> List<R> map(List<T> list, Function<T, R> function)
```
Esse método genérico percorre uma lista de elementos do tipo `T`, aplica uma transformação definida pela `Function<T, R>` em cada elemento, e retorna uma nova lista com os resultados do tipo `R`.


```java
List<String> map = map(strings, s -> s.toUpperCase());
List<Integer> integers = map(strings, (String s) -> s.length());
List<String> strings = List.of("Naruto", "Sasuke");
```

### ✅ O que esse exemplo mostra?

- **Transformações genéricas**: o método `map` é reutilizável para qualquer tipo de conversão entre listas.
- **Uso da interface `Function<T, R>`** para encapsular a lógica de transformação.
- **Expressões lambda** deixam o código conciso e direto.

| Interface       | Propósito                          | Exemplo de uso                          |
|------------------|-------------------------------------|-------------------------------------------|
| `Predicate<T>`   | Testa uma condição e retorna `boolean` | `car -> car.getYear() < 2015`             |
| `Consumer<T>`    | Executa uma ação, não retorna nada     | `s -> System.out.println(s)`              |
| `Function<T, R>` | Transforma um valor `T` em `R`         | `s -> s.length()` ou `s -> s.toUpperCase()` |

## Method Reference

### Referência a métodos estáticos

Você está ordenando uma lista de objetos `Anime` usando **referências a métodos** (`method reference`) em vez de expressões lambda.

```java
animeList.sort((a1, a2) -> a1.getTitle().compareTo(a2.getTitle()));
```
⬇️ pode ser substituído por:
```java
animeList.sort(AnimeComparators::compareByTitle);
```
#### Por que isso funciona?

O método `List.sort(Comparator<? super T>)` espera um `Comparator`, que é uma **interface funcional** com o método:
```java
int compare(T o1, T o2);
```

Como os métodos `compareByTitle` e `compareByEp` da classe `AnimeComparators` possuem **essa mesma assinatura**, você pode referenciá-los diretamente com:
```java
animeList.sort(AnimeComparators::compareByTitle);
animeList.sort(AnimeComparators::compareByEp);
```

```java
public class AnimeComparators {
    public static int compareByTitle(Anime a1, Anime a2) {
        return a1.getTitle().compareTo(a2.getTitle());
    }

    public static int compareByEp(Anime a1, Anime a2) {
        return Integer.compare(a1.getEpisodes(), a2.getEpisodes());
    }
}
```

Esses dois métodos são usados como referência na hora de ordenar a lista de animes.

### Referência a métodos não estáticos

Além de referenciar métodos **estáticos**, também é possível referenciar **métodos de instância**, ou seja, métodos que precisam de um objeto para serem chamados.

```java
objeto::metodo
```
Esse formato **usa um objeto já existente** e chama seu método. Funciona quando a **interface funcional** esperada recebe os mesmos argumentos que o método referenciado.

```java
public class Impressora {
    public void imprimir(String msg) {
        System.out.println("Imprimindo: " + msg);
    }
}

public class Main {
    public static void main(String[] args) {
        Impressora impressora = new Impressora();
        List<String> mensagens = List.of("Naruto", "Luffy", "Goku");

        // Lambda:
        mensagens.forEach(msg -> impressora.imprimir(msg));

        // Method reference:
        mensagens.forEach(impressora::imprimir);
    }
}
```


### Referência a Construtor

Você também pode usar **referência a métodos de instância**, ou seja, métodos que pertencem a um objeto específico, já instanciado.

```java
objeto::metodo
```

Esse formato funciona quando:
- A interface funcional esperada tem uma assinatura compatível com o método;
- E você **já criou a instância do objeto** que possui o método.

```java
AnimeComparators animeComparators = new AnimeComparators();
List<Anime> animeList = new ArrayList<>(List.of(
    new Anime("Berserk", 43),
    new Anime("One piece", 100),
    new Anime("Naruto", 500)
));

// Lambda:
animeList.sort((a1, a2) -> animeComparators.compareByTitle(a1, a2));

// Method reference (método de instância):
animeList.sort(animeComparators::compareByTitle);
animeList.sort(animeComparators::compareByEp);
```

O método `sort` espera um `Comparator<Anime>`, ou seja, algo com a assinatura:
```java
int compare(Anime a1, Anime a2);
```

Os métodos da sua classe `AnimeComparators` têm exatamente essa assinatura:
```java
public int compareByTitle(Anime a1, Anime a2) { ... }
public int compareByEp(Anime a1, Anime a2) { ... }
```

Como você criou uma instância de `AnimeComparators`, pode usá-la diretamente com:
```java
animeComparators::compareByTitle
```

#### 🔗 Tabela comparativa: Method Reference vs Lambda

| Tipo                     | Lambda (forma completa)                       | Method Reference            | Interface funcional comum     |
|--------------------------|-----------------------------------------------|-----------------------------|-------------------------------|
| 🧊 Método estático       | `(a, b) -> Classe.metodoEstatico(a, b)`       | `Classe::metodoEstatico`    | `Comparator<T>` ou `BiFunction` |
| 🔧 Método de instância   | `(a, b) -> objeto.metodo(a, b)`               | `objeto::metodo`            | `Comparator<T>` ou `BiFunction` |
| 🧠 Método de instância (da própria classe do objeto) | `s -> s.metodo()`                  | `Classe::metodo`            | `Function<T, R>`, `Consumer<T>` |
| 🏗️ Construtor            | `() -> new Classe()`                         | `Classe::new`               | `Supplier<T>`                 |
| 🏗️ Construtor com args   | `(a, b) -> new Classe(a, b)`                 | `Classe::new`               | `Function` ou `BiFunction`    |

```java
// Método estático
list.sort((a, b) -> AnimeComparators.compareByTitle(a, b));
list.sort(AnimeComparators::compareByTitle);

// Método de instância (objeto criado)
AnimeComparators comp = new AnimeComparators();
list.sort((a, b) -> comp.compareByEp(a, b));
list.sort(comp::compareByEp);

// Método de instância da própria classe
List<String> nomes = List.of("naruto", "luffy");
nomes.forEach(s -> s.toUpperCase());
nomes.forEach(String::toUpperCase);

// Construtor sem parâmetro
Supplier<Anime> s = () -> new Anime();
Supplier<Anime> s2 = Anime::new;

// Construtor com parâmetros
Function<String, Produto> f = nome -> new Produto(nome);
Function<String, Produto> f2 = Produto::new;
```

## Optional

O `Optional` é uma classe container do Java introduzida no Java 8, que representa **um valor que pode ou não estar presente**. Ele é uma alternativa elegante ao uso tradicional de `null` e ajuda a evitar erros como `NullPointerException`.

```java
Optional<String> nameOptional = Optional.ofNullable(findName("Beto"));
```
- `Optional.ofNullable(value)`: Cria um `Optional` que pode conter um valor **ou estar vazio** (`Optional.empty()`), dependendo se o valor é `null` ou não.


#### 1. `orElse(T other)`

Retorna o valor contido no `Optional` se estiver presente. Caso contrário, retorna o valor passado como argumento.

```java
String empty = nameOptional.orElse("EMPTY"); System.out.println(empty);
```
- Se `findName("Beto")` retornar `null`, será impresso `"EMPTY"`.
- Caso contrário, imprime o nome retornado.
#### 2. `ifPresent(Consumer<? super T> action)`

Executa uma ação (lambda ou referência de método) **apenas se o valor estiver presente** no `Optional`.

```java
nameOptional.ifPresent(s -> System.out.println(s.toUpperCase()));
```
- Se houver um nome, ele será impresso em **caixa alta**.
- Se o `Optional` estiver vazio, **nada acontece**.

```java
public static void main(String[] args) {
    Optional<String> nameOptional = Optional.ofNullable(findName("Beto"));

    // Se estiver vazio, retorna "EMPTY"
    String nomeFinal = nameOptional.orElse("EMPTY");
    System.out.println(nomeFinal);

    // Se estiver presente, imprime o nome em caixa alta
    nameOptional.ifPresent(nome -> System.out.println(nome.toUpperCase()));
}

public static String findName(String input) {
    return input.equals("Beto") ? null : "Luffy";
}
```



