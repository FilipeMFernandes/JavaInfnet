import java.util.ArrayList;
import java.util.Date;

public class Cliente {
    private String nome, numConta;
    private ArrayList<Transacao> transacoes;
    private double saldo;

    public ArrayList<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(ArrayList<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    public Cliente() {
    }

    public Cliente(String nome, String numConta, ArrayList<Transacao> transacaos, double saldo) {
        this.nome = nome;
        this.numConta = numConta;
        this.transacoes = new ArrayList<>();
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
        this.transacoes.add(new Transacao(data, operacao, valor));
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + "\n" +
                "Numero de Conta: " + numConta + "\n" +
                "saldo: " + saldo ;
    }

    public String mostrarTransacoes() {
        StringBuilder transacoes = new StringBuilder();
        for(Transacao transacao : this.transacoes){
            transacoes.append(transacao.toString()).append("\n");
        }
        return transacoes.toString();
    }
}
