public class Aluno {
    private String matricula, nome;
    private double nota1, nota2;

    public Aluno() {
    }

    public Aluno(String matricula, String nome, double nota1, double nota2) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double calcularMedia(){
        return (nota1+nota2)/2;
    }

    public String avaliar(){
        if (this.calcularMedia() >= 6){
            return "Aprovado";
        }else{
            return "Reprovado";
        }
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                '}';
    }
}
