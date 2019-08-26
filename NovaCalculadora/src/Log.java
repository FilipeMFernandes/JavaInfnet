import java.util.Date;

public class Log {
    private Date data;
    private String operacao;
    private double op1, op2, resultado;

    public Log() {
    }

    public Log(Date data, String operacao, double op1, double op2, double resultado) {
        this.data = data;
        this.operacao = operacao;
        this.op1 = op1;
        this.op2 = op2;
        this.resultado = resultado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public double getOp1() {
        return op1;
    }

    public void setOp1(double op1) {
        this.op1 = op1;
    }

    public double getOp2() {
        return op2;
    }

    public void setOp2(double op2) {
        this.op2 = op2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public String opParaSimbolo(){
        switch (operacao){
            case("soma"):
                return "+";
            case("subtracao"):
                return "-";
            case("multiplicacao"):
                return "*";
            case("divisao"):
                return "/";
            default:
                return operacao;
        }
    }

    @Override
    public String toString() {
        return data + " " + operacao + " " + op1 + opParaSimbolo() + op2 + "=" + resultado;
    }
}
