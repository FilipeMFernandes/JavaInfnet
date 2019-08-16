public class Empregado {
    private String nome, sobrenome, matricula;
    private double salario;

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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empregado: " +
                nome + " " + sobrenome + ", \n" +
                "matricula: " + matricula + ", \n" +
                "salario: " + salario;
    }
    public void alterarSalario(double porcentagem) {

        salario += (salario*porcentagem)/100;
    }

    public double getSalarioAnual() {
        return salario*12;
    }
}
