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
        System.out.println("4 - Caixa Eletrônico");
        System.out.print("Digite a opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

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

        scanner.close();
    }

    static void numeroPerfeito(Scanner scanner) {
        // NumeroPerfeito -> é o número no qual somando todos seus divisores dá ele
        // mesmo, ex.: 6 -> 1 + 2 + 3.

        // Pede a entrada do usuário
        System.out.println("\nEscolha um número e irei fazer a verificação se é um número perfeito ou não:");
        int n = scanner.nextInt();

        // Cria um ArrayList que armazena todos os divisores e inicializa a variavel
        // soma
        ArrayList<Integer> divisores = new ArrayList<>();
        int soma = 0;

        // Se a divisao for com resto 0 faz a soma e armazena no ArrayList
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                divisores.add(i);
                soma += i;
            }
        }

        // Caso a soma for igual ao N, exibe o resultado de número perfeito e informa ao
        // usuário
        System.out.println("\n------------------------\n");
        System.out.println("Divisores próprios de " + n + ": " + divisores);
        if (soma == n) {
            System.out.println("Portanto, " + n + " é um número perfeito!");
            System.out.println("------------------------");
        } else {
            System.out.println("Portanto, " + n + " não é um número perfeito!");
            System.out.println("\n------------------------");
        }
    }

    static void fibonacci(Scanner scanner) {
        // Escala de Fibonacci -> sequencia numerica onde o número é a soma dos outros
        // dois anteriores

        // Pede a entrada do número do usuário
        System.out.println("\nEscolha um número e irei exibir os 'N' primeiros termos da Sequência de Fibonacci: ");
        int n = scanner.nextInt();

        // ArrayList para armazenar todos os números da escala
        ArrayList<Integer> fibonacci = new ArrayList<>();

        // Para os primeiros termos existe um padrão, 0 e 1
        fibonacci.add(0);
        if (n > 1) {
            fibonacci.add(1);
        }

        // Gerar a sequencia com os calculos, (i - 2) = antepenúltimo, (i - 1) =
        // penúltimo
        System.out.println("------------------------\n");

        for (int i = 2; i < n; i++) {
            int a = fibonacci.get(i - 2);
            int b = fibonacci.get(i - 1);
            int proximo = a + b;
            System.out.println(a + " + " + b + " -> " + proximo);
            fibonacci.add(proximo);
        }

        System.out.println("\n------------------------");
    }

    static void primosNoIntervalo(Scanner scanner) {
        // Descobrir os números primos entre os números que foram digitados pelo usuário

        System.out.println("Digite o um número: ");
        int n1 = scanner.nextInt();
        while (n1 < 0) {
            System.out.println("Digite o um número: ");
            n1 = scanner.nextInt();
        }

        System.out.println("Digite agora o outro número: ");
        int n2 = scanner.nextInt();
        while (n2 < 0) {
            System.out.println("Digite agora o outro número: ");
            n2 = scanner.nextInt();
        }

        ArrayList<Integer> primos = new ArrayList<>();

        int maior = Math.max(n1, n2);
        int menor = Math.min(n1, n2);

        for (int i = menor; i <= maior; i++) {
            if (primo(i)) {
                primos.add(i);
            }
        }
        System.out.println("------------------------\n");
        System.out.println("Números primos entre " + menor + " e " + maior + ": " + primos);
        System.out.println("\n------------------------");

    }

    static boolean primo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    static void caixaEletronico(Scanner scanner) {
        // Implemente aqui o exercício 5
    }
}