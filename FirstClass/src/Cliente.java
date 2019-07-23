public class Cliente {
    private String nome;
    private String conta;
    private int saldo;

    public Cliente() {
    }

    public Cliente(String nome, String conta, int saldo) {
        this.nome = nome;
        this.conta = conta;
        this.saldo = saldo;
    }

    public void Creditar(int valor){
        this.saldo += valor;
    }

    public void Debitar(int valor){
        this.saldo -= valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
