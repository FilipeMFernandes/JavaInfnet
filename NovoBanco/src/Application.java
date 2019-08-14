import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        boolean sair = false;
        ArrayList<Cliente> clientes = new ArrayList<>();
        while(!sair){
            switch (menu()){
                case 1:
                    criarCliente(clientes);
                    break;
                case 2:
                    depositar(clientes);
                    break;
                case 3:
                    sacar(clientes);
                    break;
                case 4:
                    Cliente cliente = consultar(clientes);
                    if (cliente == null) return;
                    JOptionPane.showMessageDialog(null, cliente.toString());
                    break;
                case 5:
                    consultarTodos(clientes);
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao Invalida! Tente novamente.");
            }
        }
    }

    private static int menu() {
        String msg = "Opcoes:\n" +
                "1 - Criar Conta\n" +
                "2 - Depositar\n" +
                "3 - Sacar\n" +
                "4 - Consultar Conta\n" +
                "5 - Consultar Todas as Contas\n" +
                "6 - sair";
        return Integer.parseInt(JOptionPane.showInputDialog(msg));
    }

    private static void criarCliente(ArrayList<Cliente> clientes) {
        Cliente cliente = new Cliente();
        leNomeCpf(cliente);
        leSaldo(cliente);
        clientes.add(cliente);
    }

    private static void leSaldo(Cliente cliente) {
        cliente.setSaldo(Integer.parseInt(JOptionPane.showInputDialog("Insira o saldo do cliente:")));
        while(cliente.getSaldo()<=0){
            cliente.setSaldo(Integer.parseInt(JOptionPane.showInputDialog("O saldo deve ser maior que 0! Insira novamente:")));
        }
    }

    private static void leNomeCpf(Cliente cliente) {
        cliente.setNome(JOptionPane.showInputDialog("Insira o nome do cliente:"));
        while (cliente.getNome().length() == 0){
            cliente.setNome(JOptionPane.showInputDialog("Nome vazio! Insira novamente:"));
        }
        cliente.setCpf(JOptionPane.showInputDialog("Insira o cpf do cliente:"));
        while (cliente.getNome().length() == 0){
            cliente.setNome(JOptionPane.showInputDialog("CPF vazio! Insira novamente:"));
        }
    }

    private static void depositar(ArrayList<Cliente> clientes) {
        Cliente cliente = consultar(clientes);
        double saldo = cliente.getSaldo();
        saldo += Double.parseDouble(JOptionPane.showInputDialog("Insira o valor a ser depositado:"));
        cliente.setSaldo(saldo);
    }

    private static void sacar(ArrayList<Cliente> clientes) {
        Cliente cliente = consultar(clientes);
        double saldo = cliente.getSaldo();
        saldo -= Double.parseDouble(JOptionPane.showInputDialog("Insira o valor a ser sacado:"));
        cliente.setSaldo(saldo);
    }

    private static Cliente consultar(ArrayList<Cliente> clientes) {
        String cpf = JOptionPane.showInputDialog("Insira o cpf do cliente:");
        Cliente consultado = null;
        for (Cliente cliente : clientes){
            if(cliente.getCpf().equals(cpf)){
                consultado = cliente;
                break;
            }
        }
        if(consultado == null) {
            JOptionPane.showMessageDialog(null, "Cliente nao encontrado");
        }
        return consultado;
    }

    private static void consultarTodos(ArrayList<Cliente> clientes) {
        StringBuilder msg = new StringBuilder();
        msg.append("Contas:\n");
        for (Cliente cliente : clientes) {
            msg.append(cliente.toString())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, msg);
    }
}
