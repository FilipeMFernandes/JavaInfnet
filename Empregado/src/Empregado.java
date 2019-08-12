public class Empregado {
    private String nome, sobrenome, matricula;
    private long salario;

    public Empregado() {
    }

    public Empregado(String nome, String sobrenome, String matricula, long salario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public long getSalario() {
        return salario;
    }

    public void setSalario(long salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empregado: " +
                nome + " " + sobrenome + ", \n" +
                "matricula: " + matricula + ", \n" +
                "salario: " + salario;
    }
}
