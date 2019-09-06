public class ContaCorrente extends ContaBancaria {
    private double taxaJuros, limiteSaque, taxaServico;

    public ContaCorrente(String numero, double saldo, double taxaJuros, double limiteSaque, double taxaServico) {
        super(numero, saldo);
        this.taxaJuros = taxaJuros;
        this.limiteSaque = limiteSaque;
        this.taxaServico = taxaServico;
    }

    @Override
    void aplicarRendmentos() {
        setSaldo(getSaldo()-taxaServico);
        if(getSaldo()>0){
            setSaldo(getSaldo()*(1+taxaJuros));
        }
    }
}
