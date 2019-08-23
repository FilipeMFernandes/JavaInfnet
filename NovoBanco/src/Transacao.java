import java.util.Date;

public class Transacao {
    private Date data;
    private String transacao;
    private double valor;

    public Transacao(Date data, String transacao, double valor) {
        this.data = data;
        this.transacao = transacao;
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTransacao() {
        return transacao;
    }

    public void setTransacao(String transacao) {
        this.transacao = transacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return data + " " + transacao + " " + valor;
    }
}
