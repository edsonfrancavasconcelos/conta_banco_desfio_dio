public abstract class Conta {
    protected Cliente titular;
    protected double saldo;

    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Cliente getTitular() {
        return titular;
    }

    public abstract void depositar(double valor);
    public abstract void sacar(double valor);
    public abstract void transferir(Conta destino, double valor);

    public double getSaldo() {
        return saldo;
    }
}
