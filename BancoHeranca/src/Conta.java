import java.util.Date;

public class Conta {
    private String numero;
    private double saldo;
    private Date dataAbertura;

    public Conta(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
        this.dataAbertura = new Date();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero='" + numero + '\'' +
                ", saldo=" + saldo +
                ", dataAbertura" + dataAbertura +
                '}';
    }
}
