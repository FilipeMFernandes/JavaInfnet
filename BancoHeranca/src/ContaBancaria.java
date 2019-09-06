public abstract class ContaBancaria extends Conta {
    public ContaBancaria(String numero, double saldo) {
        super(numero, saldo);
    }

    private void creditar(int valor){
        setSaldo(getSaldo()+valor);
    }

    private void debitar(int valor){
        setSaldo(getSaldo()-valor);
    }

    abstract void aplicarRendmentos();
}
