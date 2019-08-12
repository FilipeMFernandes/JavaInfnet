public class Conta {
    private String titular, numConta;
    private long saldo;

    public Conta() {
    }

    public Conta(String titular, String numConta, long saldo) {
        this.titular = titular;
        this.numConta = numConta;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }
}
