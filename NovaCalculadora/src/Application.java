import jdk.internal.util.xml.impl.Input;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

public class Application {
    public static void main(String[] args) {
        boolean sair = false;
        Calculadora calculadora = new Calculadora();
        while(!sair){
            switch(menu()){
                case 1:
                    soma(calculadora);
                    break;
                case 2:
                    subtracao(calculadora);
                    break;
                case 3:
                    multiplicacao(calculadora);
                    break;
                case 4:
                    divisao(calculadora);
                    break;
                case 5:
                    exibirHistorico(calculadora);
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Comando invalido, tente novamente!");
            }
        }
    }

    private static void exibirHistorico(Calculadora calculadora) {
        if(calculadora.getLogs() == null || calculadora.getLogs().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhuma operacao foi realizada");
            return;
        }
        JOptionPane.showMessageDialog(null, calculadora.concatLogs());
    }

    private static void divisao(Calculadora calculadora) {
        try {
            leOps(calculadora, "divisao");
            double resultado = calculadora.divisao();
            if (Double.isInfinite(resultado)){
                JOptionPane.showMessageDialog(null, "Impossivel realizar divisao por zero.");
                return;
            }
            calculadora.addLog("divisao", resultado);
            printResultado("divisao", resultado);
        }
        catch (Exception ignore){
        }
    }

    private static void multiplicacao(Calculadora calculadora) {
        try {
            leOps(calculadora, "multiplicacao");
            double resultado = calculadora.multiplicacao();
            calculadora.addLog("multiplicacao", resultado);
            printResultado("multiplicacao", resultado);
        }
        catch (Exception ignore){

        }
    }

    private static void subtracao(Calculadora calculadora) {
        try {
            leOps(calculadora, "subtracao");
            double resultado = calculadora.subtracao();
            calculadora.addLog("subtracao", resultado);
            printResultado("subtracao", resultado);
        }
        catch (Exception ignore){

        }
    }

    private static void soma(Calculadora calculadora) {
        try {
            leOps(calculadora, "soma");
            double resultado = calculadora.soma();
            calculadora.addLog("soma", resultado);
            printResultado("soma", resultado);
        }
        catch (Exception ignore){

        }
    }

    private static void printResultado(String op, double resultado) {
        switch (op) {
            case "soma":
                JOptionPane.showMessageDialog(null, "A soma da adicao foi " + resultado);
                break;
            case "subtracao":
                JOptionPane.showMessageDialog(null, "O subtraendo da subtracao foi " + resultado);
                break;
            case "multiplicacao":
                JOptionPane.showMessageDialog(null, "O produto da multiplicacao foi " + resultado);
                break;
            case "divisao":
                JOptionPane.showMessageDialog(null, "O quociente da divisao foi " + resultado);
                break;
        }
    }

    private static void leOps(Calculadora calculadora, String op) {
        try {
            switch (op) {
                case "soma":
                    calculadora.setOp1(leOp("do primeira parcela"));
                    calculadora.setOp2(leOp("da segunda parcela"));
                    break;
                case "subtracao":
                    calculadora.setOp1(leOp("do minuendo"));
                    calculadora.setOp2(leOp("do subtraendo"));
                    break;
                case "multiplicacao":
                    calculadora.setOp1(leOp("do multiplicando"));
                    calculadora.setOp2(leOp("do multiplicador"));
                    break;
                case "divisao":
                    calculadora.setOp1(leOp("do dividendo"));
                    calculadora.setOp2(leOp("do divisor"));
                    break;
            }
        }
        catch (InputMismatchException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }

    }

    private static double leOp(String op) {
        try {
            return Double.parseDouble(JOptionPane.showInputDialog("Insira o valor " + op));
        }
        catch (Exception e){
            throw new InputMismatchException("Input Invalido");
        }
    }

    private static int menu() {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(
                    "Escolha uma operacao: \n" +
                            "1 - soma\n" +
                            "2 - subtracao\n" +
                            "3 - multiplicacao\n" +
                            "4 - divisao\n" +
                            "5 - historico\n" +
                            "6 - sair"
                    )
            );
        }
        catch (NumberFormatException e){
            return 0;
        }
    }
}
