package domain;

public abstract class Pessoa {
    private String numero, endereco;
    private int saldo;

    public Pessoa(String numero, String endereco, int saldo) {
        this.numero = numero;
        this.endereco = endereco;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
