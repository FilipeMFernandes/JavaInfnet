package domain;

public class PessoaJuridica extends Pessoa{

    private String razaoSocial;

    public PessoaJuridica(String numero, String endereco, int saldo, String razaoSocial) {
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
