import javax.swing.JOptionPane;

public class Application {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        menu(calculadora);
    }

    public static void menu(Calculadora calculadora){
        String operacao;
        do {
            operacao = escolherOperacao();
            if (operacao.equals("sair")) return;
            escolherOperadores(calculadora);
            double resultado = realizarOperacao(operacao, calculadora);
            JOptionPane.showMessageDialog(null, resultado);
        }while(!operacao.equals("sair"));
    }

    private static double realizarOperacao(String operacao, Calculadora calculadora) {
        double resultado;
        switch (operacao){
            case "soma":
                resultado = calculadora.soma();
                break;
            case "subtracao":
                resultado = calculadora.subtracao();
                break;
            case "multiplicacao":
                resultado = calculadora.multiplicacao();
                break;
            case "divisao":
                resultado = calculadora.divisao();
                break;
            default:
                resultado = 0.0;
        }
        return resultado;
    }

    private static void escolherOperadores(Calculadora calculadora) {
        calculadora.setOp1(Double.parseDouble(JOptionPane.showInputDialog("Escolha o operador 1")));
        calculadora.setOp2(Double.parseDouble(JOptionPane.showInputDialog("Escolha o operador 2")));
    }

    private static String escolherOperacao() {
        String operacao;
        do{
            operacao = JOptionPane.showInputDialog(
                    "Escolha a operacao:\n" +
                            "soma\n" +
                            "subtracao\n" +
                            "multiplicacao\n" +
                            "divisao\n" +
                            "sair"
            );
        }while(!operacao.equals("soma")&&!operacao.equals("subtracao")&&!operacao.equals("multiplicacao")&&!operacao.equals("divisao")&&!operacao.equals("sair"));

        return operacao;
    }

}