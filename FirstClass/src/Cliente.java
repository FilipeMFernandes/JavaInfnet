public class Cliente {
    private String nome;
    private String conta;
    private double saldo;

    public Cliente() {
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", conta='" + conta + '\'' +
                ", saldo=" + saldo +
                '}';
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
