public class contaBancaria {

    private final String titular;
    private final int numeroConta;
    private double saldo;

    public contaBancaria(String titular, int numeroConta) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = 0;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void depositar(double valor) {

        if (valor > 0) {
            saldo += valor;
            IO.println("Depósito realizado com sucesso!");
        } else {
            IO.println("Valor inválido.");
        }
    }

    public void sacar(double valor) {

        if (valor <= 0) {
            IO.println("Valor inválido.");
        } else if (valor > saldo) {
            IO.println("Saldo insuficiente.");
        } else {
            saldo -= valor;
            IO.println("Saque realizado com sucesso!");
        }
    }

    public void consultarSaldo() {
        IO.println("Saldo atual: R$ " + saldo);
    }

    public void exibirDados() {
        IO.println("------------------------");
        IO.println("Titular: " + titular);
        IO.println("Conta: " + numeroConta);
        IO.println("Saldo: R$ " + saldo);
    }
}