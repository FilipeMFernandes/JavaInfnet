package domain;

public class PessoaJuridica extends Pessoa{

    private String razaoSocial;

    public PessoaJuridica(String numero, int saldo, String razaoSocial, String endereco) {
        super(numero, endereco, saldo);
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
