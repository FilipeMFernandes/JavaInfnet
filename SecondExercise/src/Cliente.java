public class Cliente {
    private String celular;
    private String nome;
    private String tipoPlano;
    private double saudo;

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

    public String getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(String tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public double getSaudo() {
        return saudo;
    }

    public void setSaudo(double saudo) {
        this.saudo = saudo;
    }

    public Cliente() {
    }

    public Cliente(String celular, String nome, String tipoPlano, double saudo) {
        this.celular = celular;
        this.nome = nome;
        this.tipoPlano = tipoPlano;
        this.saudo = saudo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "celular='" + celular + '\'' +
                ", nome='" + nome + '\'' +
                ", tipoPlano='" + tipoPlano + '\'' +
                ", saudo=" + saudo +
                '}';
    }
}
