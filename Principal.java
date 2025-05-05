import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Aqui você pode escolher qual exercício quer testar
        System.out.println("Escolha o exercício:");
        System.out.println("1 - Número Perfeito");
        System.out.println("2 - Fibonacci");
        System.out.println("3 - Primos no Intervalo");
        System.out.print("Digite a opção: ");
        int opcao = scanner.nextInt(); // Lê a escolha do usuário
        scanner.nextLine(); // Limpar buffer do scanner

        // De acordo com a opção do usuário, chama o respectivo método
        switch (opcao) {
            case 1:
                numeroPerfeito(scanner);
                break;
            case 2:
                fibonacci(scanner);
                break;
            case 3:
                primosNoIntervalo(scanner);
                break;
            case 4:
                caixaEletronico(scanner);
                break;
            default:
                System.out.println("Opção inválida.");
        }

        scanner.close(); // Fecha o scanner para evitar problemas de memória
    }

    // Método para verificar se um número é perfeito
    static void numeroPerfeito(Scanner scanner) {
        // Número Perfeito -> é o número no qual a soma de seus divisores é igual ao
        // número.
        // Exemplo: 6 -> divisores 1, 2, 3; soma 1 + 2 + 3 = 6.

        System.out.println("\nEscolha um número e irei fazer a verificação se é um número perfeito ou não:");
        int n = scanner.nextInt(); // Lê o número do usuário

        // Cria um ArrayList para armazenar os divisores e inicializa a variável soma
        ArrayList<Integer> divisores = new ArrayList<>();
        int soma = 0;

        // Percorre os números de 1 até n-1 para verificar se são divisores de n
        for (int i = 1; i < n; i++) {
            if (n % i == 0) { // Verifica se 'i' é divisor de 'n'
                divisores.add(i); // Adiciona o divisor ao ArrayList
                soma += i; // Soma os divisores
            }
        }

        // Exibe os divisores e verifica se a soma é igual ao número
        System.out.println("\n------------------------\n");
        System.out.println("Divisores próprios de " + n + ": " + divisores);
        if (soma == n) {
            System.out.println("Portanto, " + n + " é um número perfeito!");
        } else {
            System.out.println("Portanto, " + n + " não é um número perfeito!");
        }
        System.out.println("------------------------");
    }

    // Método para gerar a sequência de Fibonacci
    static void fibonacci(Scanner scanner) {
        // Escala de Fibonacci -> sequência numérica onde o número é a soma dos dois
        // anteriores.

        System.out.println("\nEscolha um número e irei exibir os 'N' primeiros termos da Sequência de Fibonacci: ");
        int n = scanner.nextInt(); // Lê o número 'n' que determina quantos termos serão gerados

        // ArrayList para armazenar os números da sequência de Fibonacci
        ArrayList<Integer> fibonacci = new ArrayList<>();

        // Os primeiros termos da sequência são 0 e 1
        fibonacci.add(0);
        if (n > 1) {
            fibonacci.add(1);
        }

        // Gera os próximos termos da sequência
        System.out.println("------------------------\n");
        for (int i = 2; i < n; i++) {
            // Calcula o próximo termo como a soma dos dois anteriores
            int a = fibonacci.get(i - 2);
            int b = fibonacci.get(i - 1);
            int proximo = a + b;
            System.out.println(a + " + " + b + " -> " + proximo);
            fibonacci.add(proximo); // Adiciona o novo número à sequência
        }

        System.out.println("\n------------------------");
    }

    // Método para encontrar os números primos no intervalo entre dois números
    static void primosNoIntervalo(Scanner scanner) {
        // Pede dois números ao usuário e encontra os primos no intervalo entre eles
        System.out.println("Digite o um número: ");
        int n1 = scanner.nextInt();
        while (n1 < 0) { // Verifica se o número é válido
            System.out.println("Digite o um número válido (positivo): ");
            n1 = scanner.nextInt();
        }

        System.out.println("Digite agora o outro número: ");
        int n2 = scanner.nextInt();
        while (n2 < 0) { // Verifica se o número é válido
            System.out.println("Digite agora o outro número válido (positivo): ");
            n2 = scanner.nextInt();
        }

        // Cria um ArrayList para armazenar os números primos
        ArrayList<Integer> primos = new ArrayList<>();

        // Determina o maior e o menor número entre n1 e n2
        int maior = Math.max(n1, n2);
        int menor = Math.min(n1, n2);

        // Encontra os números primos no intervalo
        for (int i = menor; i <= maior; i++) {
            if (primo(i)) { // Chama o método primo() para verificar se 'i' é primo
                primos.add(i); // Adiciona o número primo à lista
            }
        }

        // Exibe os números primos encontrados
        System.out.println("------------------------\n");
        System.out.println("Números primos entre " + menor + " e " + maior + ": " + primos);
        System.out.println("\n------------------------");
    }

    // Método para verificar se um número é primo
    static boolean primo(int num) {
        if (num <= 1) { // Números menores ou iguais a 1 não são primos
            return false;
        }
        // Verifica se o número tem algum divisor além de 1 e ele mesmo
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false; // Se encontrar um divisor, o número não é primo
        }
        return true; // Caso contrário, é primo
    }

    // Método para simular um caixa eletrônico
    static void caixaEletronico(Scanner scanner) {
        // Simula um caixa eletrônico que solicita o valor a ser sacado e exibe quantas
        // notas de R$100, R$50, R$20 e R$10 serão entregues

        System.out.println("Um excelente dia, quanto deseja sacar em R$? ");
        int valor = scanner.nextInt(); // Lê o valor a ser sacado

        if (valor <= 0) { // Verifica se o valor é válido
            System.out.println("Valor inválido. Por favor, digite um valor positivo.");
            return;
        }

        // Calcula a quantidade de notas de cada valor
        int cem, cinq, vinte, dez, cinco, dois, um;
        int resto;

        // Realiza a divisão e obtém a quantidade de notas para cada valor
        cem = valor / 100;
        resto = valor % 100;

        cinq = resto / 50;
        resto = resto % 50;

        vinte = resto / 20;
        resto = resto % 20;

        dez = resto / 10;
        resto = resto % 10;

        cinco = resto / 5;
        resto = resto % 5;

        dois = resto / 2;
        resto = resto % 2;

        um = resto / 1;
        resto = resto % 1;

        // Exibe a quantidade de notas a ser entregue
        System.out.println("Notas a serem entregues: ");
        if (cem > 0)
            System.out.println("R$100: " + cem + " nota(s)");
        if (cinq > 0)
            System.out.println("R$50: " + cinq + " nota(s)");
        if (vinte > 0)
            System.out.println("R$20: " + vinte + " nota(s)");
        if (dez > 0)
            System.out.println("R$10: " + dez + " nota(s)");
        if (cinco > 0)
            System.out.println("R$5: " + cinco + " nota(s)");
        if (dois > 0)
            System.out.println("R$2: " + dois + " nota(s)");
        if (um > 0)
            System.out.println("R$1: " + um + " nota(s)");

        // Se restar algum valor, ele será mostrado
        if (resto > 0) {
            System.out.println("Resto: " + resto + " centavos.");
        }
    }
}