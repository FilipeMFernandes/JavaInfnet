import java.util.Date;

public class Cliente {
    private String nome, numConta, extrato;
    private double saldo;

    public String getExtrato() {
        return extrato;
    }

    public void setExtrato(String extrato) {
        this.extrato = extrato;
    }

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

    public void adicionarExtrato(Date data, String operacao, double valor){
        if(extrato != null){
            extrato += data + " " + operacao + " " + valor + "\n";
        }else {
            setExtrato(data + " " + operacao + " " + valor + "\n");
        }
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + "\n" +
                "Numero de Conta: " + numConta + "\n" +
                "saldo: " + saldo ;
    }

}
