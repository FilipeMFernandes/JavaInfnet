public class ContaCartaoCredito extends Conta {

    public ContaCartaoCredito(String numero, double saldo) {
        super(numero, saldo);
    }

    private void pagar(int valor){
        setSaldo(getSaldo()-valor);
    }

    private void cobrarJuros(double taxa){
        setSaldo(getSaldo()*(1+taxa));
    }
}
