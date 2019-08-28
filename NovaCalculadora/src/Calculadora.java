import java.util.ArrayList;
import java.util.Date;

public class Calculadora {
    private double op1, op2;
    private ArrayList<Log> logs;

    public Calculadora() {
        this.logs = new ArrayList<>();
    }

    public Calculadora(double op1, double op2) {
        this.op1 = op1;
        this.op2 = op2;
        this.logs = new ArrayList<>();
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

    public ArrayList<Log> getLogs() {
        return logs;
    }

    public void setLogs(ArrayList<Log> logs) {
        this.logs = logs;
    }

    public double soma(){
        return op1+op2;
    }

    public double subtracao(){
        return op1-op2;
    }

    public double multiplicacao(){
        return op1*op2;
    }

    public double divisao(){
        return op1/op2;
    }

    public void addLog(String op, double resultado) {
        Date data = new Date();
        Log log = new Log(data, op, op1, op2, resultado);
        logs.add(log);
    }
    public String concatLogs(){
        StringBuilder logs = new StringBuilder();
        for(Log log : this.logs){
            logs.append(log.toString()).append("\n");
        }
        return logs.toString();
    }
}
