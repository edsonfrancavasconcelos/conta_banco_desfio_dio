import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ContaCorrente contaCorrente1 = new ContaCorrente(1000);
        ContaPoupanca contaPoupanca1 = new ContaPoupanca(500);
        Cliente cliente1 = new Cliente("Alice", contaCorrente1, contaPoupanca1);

        ContaCorrente contaCorrente2 = new ContaCorrente(1000);
        ContaPoupanca contaPoupanca2 = new ContaPoupanca(500);
        Cliente cliente2 = new Cliente("Bob", contaCorrente2, contaPoupanca2);

        while (true) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Transferir");
            System.out.println("4. Sair");
            int operacao = scanner.nextInt();

            if (operacao == 4) {
                break;
            }

            System.out.println("Escolha o cliente:");
            System.out.println("1. Alice");
            System.out.println("2. Bob");
            int clienteEscolhido = scanner.nextInt();
            Cliente cliente = (clienteEscolhido == 1) ? cliente1 : cliente2;

            switch (operacao) {
                case 1:
                    System.out.println("Escolha a conta para depositar:");
                    System.out.println("1. Conta Corrente");
                    System.out.println("2. Conta Poupança");
                    int contaDeposito = scanner.nextInt();
                    Conta contaParaDeposito = (contaDeposito == 1) ? cliente.getContaCorrente() : cliente.getContaPoupanca();

                    System.out.println("Digite o valor para depositar:");
                    double valorDeposito = scanner.nextDouble();
                    cliente.depositar(contaParaDeposito, valorDeposito);
                    break;
                case 2:
                    System.out.println("Escolha a conta para sacar:");
                    System.out.println("1. Conta Corrente");
                    System.out.println("2. Conta Poupança");
                    int contaSaque = scanner.nextInt();
                    Conta contaParaSaque = (contaSaque == 1) ? cliente.getContaCorrente() : cliente.getContaPoupanca();

                    System.out.println("Digite o valor para sacar:");
                    double valorSaque = scanner.nextDouble();
                    cliente.sacar(contaParaSaque, valorSaque);
                    break;
                case 3:
                    System.out.println("Escolha a conta de origem:");
                    System.out.println("1. Conta Corrente");
                    System.out.println("2. Conta Poupança");
                    int contaOrigem = scanner.nextInt();
                    Conta contaParaTransferirOrigem = (contaOrigem == 1) ? cliente.getContaCorrente() : cliente.getContaPoupanca();

                    System.out.println("Escolha o cliente de destino:");
                    System.out.println("1. Alice");
                    System.out.println("2. Bob");
                    int clienteDestinoEscolhido = scanner.nextInt();
                    Cliente clienteDestino = (clienteDestinoEscolhido == 1) ? cliente1 : cliente2;

                    System.out.println("Escolha a conta de destino:");
                    System.out.println("1. Conta Corrente");
                    System.out.println("2. Conta Poupança");
                    int contaDestino = scanner.nextInt();
                    Conta contaParaTransferirDestino = (contaDestino == 1) ? clienteDestino.getContaCorrente() : clienteDestino.getContaPoupanca();

                    System.out.println("Digite o valor para transferir:");
                    double valorTransferencia = scanner.nextDouble();
                    cliente.transferir(contaParaTransferirOrigem, contaParaTransferirDestino, valorTransferencia);
                    break;
                default:
                    System.out.println("Operação inválida. Tente novamente.");
            }

            System.out.println("Saldo final da Conta Corrente de " + cliente1.getNome() + ": R$ " + cliente1.getContaCorrente().getSaldo());
            System.out.println("Saldo final da Conta Poupança de " + cliente1.getNome() + ": R$ " + cliente1.getContaPoupanca().getSaldo());
            System.out.println("Saldo final da Conta Corrente de " + cliente2.getNome() + ": R$ " + cliente2.getContaCorrente().getSaldo());
            System.out.println("Saldo final da Conta Poupança de " + cliente2.getNome() + ": R$ " + cliente2.getContaPoupanca().getSaldo());
        }

        scanner.close();
    }
}
