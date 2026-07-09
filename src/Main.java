import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Digite o nome do titular da conta: ");
        var name = scanner.nextLine();

        System.out.println("Quando deseja depositar inicilmente ?");
        var saldoInicial = scanner.nextDouble();

        ContaBancaria  conta = new ContaBancaria(name, saldoInicial);

        System.out.println("Escolha uma opção: ");
        var opcao = 0;

        while (opcao != 6) {
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Pagamentos");
            System.out.println("4 - Saldo");
            System.out.println("5 - Extrato");
            System.out.println("6 - Sair");

            try {
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1: {
                        System.out.println("Quanto deseja depositar ?");
                        var valor = scanner.nextDouble();
                        conta.depositar(valor);
                        break;
                    }
                    case 2: {
                        System.out.println("Quanto deseja sacar ?");
                        var valor = scanner.nextDouble();
                        conta.sacar(valor);
                        break;
                    }
                    case 3: {
                        System.out.println("Qual valor do boleto ?");
                        var valor = scanner.nextDouble();
                        conta.pagarBoleto(valor);
                        break;
                    }
                    case 4: {
                        conta.getSaldo();
                    }
                    case 5: {
                        conta.verExtato();
                    }
                    case 6: {
                        break;
                    }
                    default: {
                        System.out.println("Opção invalida! Escolha uma opção valida.");
                    }
                }
            } catch (Exception e) {
                System.out.println("Opção inválida! Digite apenas números.");
                scanner.nextLine(); // limpa o buffer
            };
        }

    }
}
