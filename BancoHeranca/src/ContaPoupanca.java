import java.util.Date;

public class ContaPoupanca extends ContaBancaria {
    private Date dataAniversario;
    private double taxaRendimento;

    public ContaPoupanca(String numero, double saldo, Date dataAniversario, double taxaRendimento) {
        super(numero, saldo);
        this.dataAniversario = dataAniversario;
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    void aplicarRendmentos() {
        setSaldo(getSaldo() * (1+taxaRendimento));
    }
}
