import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        boolean sair = false;
        Conta conta = new Conta();
        while(!sair) {
            switch (menu()) {
                case 1:
                    conta = criarConta();
                    break;
                case 2:
                    sacar(conta);
                    break;
                case 3:
                    depositar(conta);
                    break;
                case 4:
                    consultar(conta);
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Entrata inválida");
            }
        }
    }

    private static void consultar(Conta conta) {
        JOptionPane.showMessageDialog(null, "Saldo da conta: " + conta.getSaldo());
    }

    private static void sacar(Conta conta) {
        long saldo = conta.getSaldo();
        long valor = Long.parseLong(JOptionPane.showInputDialog("Escreva o valor a ser sacado:"));
        saldo -= valor;
        conta.setSaldo(saldo);
    }

    public static int menu(){
        int opcao;
        String mensagem = "Escolha a operaçao:\n" +
                "1 - Criar conta\n" +
                "2 - Depositar\n" +
                "3 - Sacar\n" +
                "4 - Consultar\n" +
                "5 - Sair";
        return Integer.parseInt(JOptionPane.showInputDialog(mensagem));
    }

    public static Conta criarConta() {
        Conta conta = new Conta();
        leTitular(conta);
        leNumConta(conta);
        leSaldo(conta);
        return conta;
    }

    public static void leSaldo(Conta conta) {
        conta.setSaldo(Long.parseLong(JOptionPane.showInputDialog(s)));
        while(conta.getSaldo()<=0){
            conta.setSaldo(Long.parseLong(JOptionPane.showInputDialog("O saldo da conta deve ser inicializado com um valor maior que zero:")));
        }
    }

    public static void leNumConta(Conta conta) {
        conta.setNumConta(JOptionPane.showInputDialog("Escreva o número da conta:"));
        while(conta.getNumConta().equals("")){
            conta.setNumConta(JOptionPane.showInputDialog("Número da conta inválido, escreva novamente:"));
        }
    }

    public static void leTitular(Conta conta) {
        conta.setTitular(JOptionPane.showInputDialog("Escreva o nome do cliente:"));
        while(conta.getTitular().length() > 0 ){
            conta.setTitular(JOptionPane.showInputDialog("Nome inválido, escreva novamente:"));
        }
    }

    public static void depositar(Conta conta) {
        long saldo = conta.getSaldo();
        long valor = Long.parseLong(JOptionPane.showInputDialog("Escreva o valor a ser sacado:"));
        saldo += valor;
        conta.setSaldo(saldo);
    }
}


