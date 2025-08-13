# Como JAVA funciona?

Aula 2: https://www.youtube.com/watch?v=JasmdiTyduI&list=PL62G310vn6nFIsOCC0H-C2infYgwm8SWW&index=3
- Principal ideia da JVM (Java Virtual Machine) é que rode essa maquina virtual em cima do Sistema Operacional, independente se for Windows, Linux ou MacOS. **Tudo isso para que uma versão do aplicativo funcione para todas**, conforme a imagem:

![[Pasted image 20250124133748.png]]

- Depois que o arquivo foi compilado (arquivo ".java" desenvolvido pelo programador), ele vira um arquivo ".class", que será executado na JVM. Comando "javac" faz isso.
- Desenvolver aplicações em Java -> Usar um JDK (Java Delopment Kit)

# Organizando o código em pacotes

* Pacotes seriam as pastas dentro do SRC
* Nome do pacote será a URL do site invertida, e em seguida o nome do projeto, depois, o ideal seria ir colocando as divisões, como no exemplo
Ex: academy.devdojo.maratonajava.introducao
* Todas as classes precisam começar com package, para indicar onde está localizada, dentro do pacote

```java
package academy.devdojo.maratonajava.introducao
```

# Comentários

```java
// Isso é um comentário de uma linha

/* 

Isso é um comentário 
com várias linhas 

*/

/**
	Isso é um comentário javadoc, que da pra colocar HTML, por exemolo//

*/
```

* Tomar cuidados com os comentários dentro das empresas, estar de acordo com o que a empresa pede

# Tipos Primitivos 

* As diferenças dos tipos primitivos serão os valores numéricos que cabem dentro de cada um.
* Da pra forçar um numero que é inteiro a ser double, por exemplo, colocando o tipo primitivo entre parênteses na frente.

```java 
int age = 10;  
long bigNumber = 10000;  
double salaryDouble = 2000;  
float salaryFloat = 2500.0F; // O F no final é para indicar que ele é do tipo float, pq embora ele caiba dentro do float, o java identifica como double.
byte ageByte = 10;  
short ageShort = 10;  
boolean verdadeiro = true;  
boolean falso = false;  
char caracter = 'M';  
```


### String NÃO É UM TIPO PRIMITIVO 

* String é uma classe.

```java 
//String NÃO é um tipo primivito. 
String name = "É O THIS VIDAAAAAA!";
System.out.println("Minha idade é "+ name + " anos");
```

# Operadores

```java 

// + - / *
// % = resto . Bom para saber se o resultado é par ou impar. Se da = 0 o num é par 

int resto = 20 % 2;  
System.out.println("Resto " + resto);  
  
// < > <= >= == !=  
boolean isDezMaiorQueVinte = 10 > 20;  
boolean isDezMenorQueVinte = 10 < 20;  
boolean isDezIgualQueVinte = 10 == 20;  
boolean isDezIgualQueDez = 10 == 10;  
boolean isDezDiferenteQueDez = 10 != 10;

// && (AND) || (OR) ! (NOT)  
int idade = 29;  
float salario = 3500F;  
boolean isDentroDaLeiMaiorQueTrinta = idade >= 30 && salario >= 4612;  
boolean isDentroDaLeiMenorQueTrinda = idade < 30 && salario > 3381;  

double valorTotalContaCorrente = 200;  
double valorTotalContaPoupanca = 10000;  
float valorPlaystation = 5000F;  

// Fazendo a comparação duas vezes, para isso está usando o "ou" 

boolean isPlaystationCincoCompravel = valorTotalContaCorrente > valorPlaystation || valorTotalContaPoupanca > valorPlaystation;

// = += -= *= /= %=  
double bonus = 1900;  
// bonus = bonus + 1000;  
bonus += 1000; // 2900  
bonus -= 1000; // 1900  
bonus *= 2;  
bonus /= 2;  
bonus %= 2;  
System.out.println(bonus);

// Bom para situações com CONTADOR
// contador = contador +1;
// ++ --
int contador = 0;
contador +=1; 
contador++;
contador--;
++contador
```

Cuidar com o "++" antes e depois, pq ele sempre vai ler o que ta em ordem primeiro, como no exemplo

```java 
contador = 0; 
System.out.println(contador++); // Isso será igual a 0
System.out.println(contador); // Isso será igual a 1

// Então se quiser realizar alguma operação, precisa colocar antes da variavel, como no exemplo

contador = 0; 
System.out.println(++contador); // Isso sera igual a 1
```

Tudo isso é uma relação de implementação, porque com a operação depois, ele pensa em primeiro ler e DEPOIS adicionar/subtrair.

# Estruturas Condicionais 

* Jeito um pouco diferente de usar o IF, mas a lógica segue a mesma, operadores e etc
* Esse if negando ali em baixo é tipo um else, basicamente.
* Um if SEMPRE precisa retornar um valor booleano, ou seja, um sim ou não.
```java 
int idade = 20;  
  
boolean isAutorizadoComprarBebida = idade >= 18;  
if (isAutorizadoComprarBebida) {  
    System.out.println("Pode beber");  
}  
if(isAutorizadoComprarBebida == false){ // isso seria a mesma coisa que colocar !isAutorizadoComprarBebida  
    System.out.println("Não pode beber");  
}
```

* Cuidar com as estruturas de comparação e de setar o valor, no caso:
```java
boolean c = false;
if(c == true) 
if (c = true)
```

* Lembra que isso são coisas diferentes, porque o que tem os operadores == vai comparar, e o que tem = vai setar

### Else 
- SEMPRE precisa ter um IF antes.
- Ele sempre vai ser executado caso não canha nas condições do IF, o que é diferente de um if negando.

### Operador Ternário 
- Usamos pra condições, sua base vai ser essa:
```java
// (condição) ? verdadeiro : falso;  

// Doar se salário for maior que 5k  
double salary = 6000;  
String mensagemDoar = "Eu vou doar 500 pro Carrilho";  
String mensagemNaoDoar = "Ainda não tenho condições";

String resultado = salary > 5000 ? mensagemDoar : mensagemNaoDoar;  
System.out.println(resultado);

// Resultado vai ser True, ou seja, vai ativar a mensagemDoar
```
- Por ser uma operação, é possível coloca-lo dentro do Sout

# Tabela Verdade 
Mesmos conceitos vistos em circuitos
&& = e (AND)
|| = ou (OR)

![[Pasted image 20250125155808.png]]

# Switch
- Dentro do switch, colocamos: char, int, byte, short, enum, String
- Se faz necessário colocar o break, se não fica ele chega até o número e continua mostrando.
- Default vai ser tipo um else, uma resposta padrão para quando não entra em nenhum dos casos.

```java
package com.thisbeto.maratonajava.introducao;  
  
public class Aula06_ExercicioSwitch {  
    public static void main(String[] args) {  
        // Utilizando Swtich e dado os valores de 1 a 7, imprima se é dia util ou fim de semana  
        // Considerando 1 como domingo  
        byte dia = 6;  
        switch (dia){  
            case 1:  
                System.out.println("Domingo: Fim de semana");  
                break;  
            case 2:  
                System.out.println("Segunda: Dia Util");  
                break;  
            case 3:  
                System.out.println("Ter: Dia Util");  
                break;  
            case 4:  
                System.out.println("Qua: Dia util");  
                break;  
            case 5:  
                System.out.println("Qui: Dia util");  
                break;  
            case 6:  
                System.out.println("Sex: Dia Util");  
                break;  
            case 7:  
                System.out.println("Sab: Fim de semana");  
                break;  
            default:  
                System.out.println("Dia inválido");  
        }       
// Opção mais SIMPLES, levando em conta que o case não para sem o break.  
        switch (dia) {  
            case 1:  
            case 7:  
                System.out.println("Fim de Semana");  
                break;  
            case 2:  
            case 3:  
            case 4:  
            case 5:  
            case 6:  
                System.out.println("Dia útil");  
                break;  
            default:  
                System.out.println("Dia inválido");  
        }    }  
  
}
```
#  Estruturas de Repetição

### While, do while, for, break

- A manha do while é de lembrar sempre de mudar a condição da variável dentro do código pra ele não ficar rodando pra sempre.
- O "do while" vai executar pelo menos uma vez, independente da condição ser true ou false. Seria basicamente: faça essa ação enquanto condição

### Diferença para o `while` comum:

- O `while` comum avalia a condição **antes** de executar o bloco, podendo nunca ser executado caso a condição inicial já seja falsa.
- O `do...while`, por outro lado, sempre executa o bloco **pelo menos uma vez**, pois só verifica a condição **depois da primeira execução**.

```java
 // while, do while, for  
    int contador = 0;  
    while(contador < 10) {  
        System.out.println(contador);  
        contador++;  
    }  
    contador = 0;  
    do {  
        System.out.println("Dentro do do-while"+ ++contador);  
    } while(contador < 10);  

	for(int i=0; i < 10; i++){  
	    System.out.println("For " +i);  
	}
```

- Usar **`for`** para loops **controlados** com número fixo de iterações.
- Usar **`while`** para loops que dependem de condições **dinâmicas** e podem terminar em situações imprevisíveis.
- Break usado para sair do laço de repetição. 
```java
// Dado o valor de um carro, descubra em quantas vezes ele pode ser parcelado  
// Condição valorParcela >= 1000  
  
double valorCarro = 40000;  
for (int parcela = 1; parcela <= valorCarro; i++) {  
    double valorParcela = valorCarro / parcela;  
    if (valorParcela < 1000) {  
        break;  
    }    System.out.println("Parcela: " + parcela + " R$ " + valorParcela);  
}
```
- Lembrar de como o IF, ELSE IF são IMPORTANTES dentro de laços e dar uma revisada nesse exercício que deu uma confundida, embora seja simples.

Continue = contrário do BREAK:
- Vai ignorar tudo o que está em baixo dele e vai voltar pro "for" contando da próxima iteração.
```java
  
double valorCarro = 40000;  
for (int parcela = (int) valorCarro; parcela >= 1; parcela--) {  
    double valorParcela = valorCarro / parcela;  
    if (valorParcela < 1000) {  // PENSAR QUE QUANDO CHEGOU NO 1000, VAI SER FALSO, ENTÃO ELE VAI SER OBRIGADO A PRINTAR A PARCELA
        continue;  
    }    System.out.println("Parcela: " + parcela + " R$ " + valorParcela);  
}
```

- No mesmo caso do BREAK ali em cima, quando ele chegar na parcela 30, que é a ultima, ele vai continuar rodando o for mas não vai printar, porque ele ignora tudo o que está em baixo dele.

# Arrays
 * Referenciar espaço em memoria que pode ter mais de um valor 
 * NULL não pode ser usado em tipos primitivos, mas em Array e objetos pode. Quando está vazio o Array, vai variar o que ele vai printar dependendo do tipo da variável.
 
` byte, short, int, long, float e double = 0`  
` char = '/0000 ' ' espaço em branco`  
` boolean = false`  
` String = null`

- O tamanho do Array NÃO muda dinamicamente. Dito isso, da pra usar o .lenght para medir o tamanho e mudar só na declaração.

```java  
String[] nomes = new String[3];  
nomes[0] = "Beto";  
nomes[1] = "Carrilho";  
nomes[2] = "This";  
  
for (int i = 0; i < nomes.length; i++) {  
    System.out.println(nomes[i]);  
}
```  

* Se declarar o Array depois com um tamanho maior, por exemplo, ele vai substituir os valores
```java
String[] nomes = new String[3];  
nomes[0] = "Beto";  
nomes[1] = "Carrilho";  
nomes[2] = "This";  

nomes = new String[4]; // No caso, vai printar 4 nulls seguido porque substituiu
  
for (int i = 0; i < nomes.length; i++) {  
    System.out.println(nomes[i]);  
}
```

- Pode declarar o que quiser diretamente sem precisar colocar o tamanho do Array, conforme o numeros2 mostra. Depois ali em baixo tem outra opção mas a segunda acaba sendo melhor.
```java
int[] numeros = new int[3];  
int[] numeros2 = {1,2,3,4,5};
int[] numeros3 = new int[]{1,2,3,4,5};
```

## Foreach
- Esse for novo é mais simples, no entanto, não é possível acessar os valores igual for normal. Basicamente, ele vai pegando posição por posição e printando.
```java
for (int j:numeros3) {  
    System.out.println(j);  
}
```

# Arrays Multidimensionais 
- Linkar dois Arrays para funcionarem juntos.
- Quando ele é multidimensional, a primeira alocação de memoria vai funcionar como a principal. Vai percorrer todos com o valor 0, dps 1 e 2.

![[Pasted image 20250127230434.png]]

```java
for (int i = 0; i < dias.length; i++) {  
    for (int j = 0; j < dias[i].length ; j++) {  
        System.out.println(dias[i][j]);  
    }
```

Foreach: Ele vai criar uma variavel de referencia no inicio (um Array de inteiros pras linhas) e depois percorrê-los 
```java
for (int[] arrBase : dias) {  // Declara arrBase como um array de inteiros  
    for (int num : arrBase) {  // Declara num como um inteiro  
        System.out.println(num);  
    }
 }   
```

Ao inicializar um Array, ele pode fazer referencia a múltiplos Arrays. Basicamente, colocando um Array dentro de um Array

```java
arrayInt[0] = new int[2];  
arrayInt[1] = new int[3];  
arrayInt[2] = new int[6];  
  
    for (int [] arrayBase: arrayInt){  
        System.out.println("\n-------");  
        for (int num: arrayBase) {  
            System.out.print(num + " ");  
    }
}

RESULTADO:
-------
0 0 
-------
0 0 0 
-------
0 0 0 0 0 0 

```
