public class Cliente {
    private String celular;
    private String nome;
    private int tipoPlano;
    private double saldo;

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(int tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente() {
    }

    public Cliente(String celular, String nome, int tipoPlano, double saldo) {
        this.celular = celular;
        this.nome = nome;
        this.tipoPlano = tipoPlano;
        this.saldo = saldo;
    }

    public String tipoPlano(){
        if(tipoPlano == 1){
            return "pre-pago";
        }else{
            return "pos-pago";
        }
    }

    public void alterarSaldo(double valor){
        if(tipoPlano==1){
            saldo -= valor;
        }else{
            saldo += valor;
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "celular='" + celular + '\'' +
                ", nome='" + nome + '\'' +
                ", tipoPlano='" + tipoPlano() + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    public void incrementar(double valor){
        saldo += valor;
    }

    public void decrementar(double valor){
        saldo += valor;
    }
}
