package domain;

public abstract class Conta {
    private String endereco, numero;
    private double saldo;

    public Conta(String endereco, String numero, double saldo) {
        this.endereco = endereco;
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
