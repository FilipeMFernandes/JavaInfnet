public class Cliente {
    private String nome, numConta;
    private double saldo;

    public Cliente() {
    }

    public Cliente(String nome, String numConta, double saldo) {
        this.nome = nome;
        this.numConta = numConta;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + "\n" +
                "numConta: " + numConta + "\n" +
                "saldo: " + saldo ;
    }

}
