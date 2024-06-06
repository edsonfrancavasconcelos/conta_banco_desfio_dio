public class ContaCorrente extends Conta {
    public ContaCorrente(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado na Conta Corrente de " + titular.getNome());
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado na Conta Corrente de " + titular.getNome());
        } else {
            System.out.println("Saldo insuficiente para saque na Conta Corrente de " + titular.getNome());
        }
    }

    @Override
    public void transferir(Conta destino, double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            destino.depositar(valor);
            System.out.println("Transferência de R$ " + valor + " realizada da Conta Corrente de " + titular.getNome() + " para " + destino.getTitular().getNome());
        } else {
            System.out.println("Saldo insuficiente para transferência na Conta Corrente de " + titular.getNome());
        }
    }
}
