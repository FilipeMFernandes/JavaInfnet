package domain;

public class PessoaFisica extends Pessoa {

    private String nome;

    public PessoaFisica(String numero, int saldo, String nome, String endereco) {
        super(numero, endereco, saldo);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
