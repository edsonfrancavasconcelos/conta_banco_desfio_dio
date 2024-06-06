public class Cliente {
    private String nome;
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;

    public Cliente(String nome, ContaCorrente contaCorrente, ContaPoupanca contaPoupanca) {
        this.nome = nome;
        this.contaCorrente = contaCorrente;
        this.contaPoupanca = contaPoupanca;
        contaCorrente.setTitular(this);
        contaPoupanca.setTitular(this);
    }

    public String getNome() {
        return nome;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public ContaPoupanca getContaPoupanca() {
        return contaPoupanca;
    }

    public void depositar(Conta conta, double valor) {
        conta.depositar(valor);
    }

    public void sacar(Conta conta, double valor) {
        conta.sacar(valor);
    }

    public void transferir(Conta origem, Conta destino, double valor) {
        origem.transferir(destino, valor);
    }
}
