import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

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
                    menuConsultar(leOpcaoConsulta(), clientes);
                    break;
                case 5:
                    excluir(clientes);
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
        try {
            String msg = "Opcoes:\n" +
                    "1 - Criar Conta\n" +
                    "2 - Depositar\n" +
                    "3 - Sacar\n" +
                    "4 - Consultar\n" +
                    "5 - Excluir\n" +
                    "6 - sair";
            return Integer.parseInt(JOptionPane.showInputDialog(msg));
        }
        catch (NumberFormatException e){
            return 0;
        }
    }

    private static void criarCliente(ArrayList<Cliente> clientes) {
        Cliente cliente = new Cliente();
        leConta(cliente);
        if(contaExiste(clientes, cliente)){
            JOptionPane.showMessageDialog(null, "Numero de conta ja existe!");
            return;
        }
        leNome(cliente);
        leSaldo(cliente);
        if(cliente.getSaldo() == 0) return;
        cliente.setTransacoes(new ArrayList<Transacao>());
        clientes.add(cliente);
    }

    private static void leSaldo(Cliente cliente) {
        try {
            cliente.setSaldo(Integer.parseInt(JOptionPane.showInputDialog("Insira o saldo do cliente:")));
            while (cliente.getSaldo() <= 0) {
                cliente.setSaldo(Integer.parseInt(JOptionPane.showInputDialog("O saldo deve ser maior que 0! Insira novamente:")));
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Opcao Invalida! Tente novamente.");
        }
    }

    private static void leNome(Cliente cliente) {
        cliente.setNome(JOptionPane.showInputDialog("Insira o nome do cliente:"));
        while (cliente.getNome().length() == 0){
            cliente.setNome(JOptionPane.showInputDialog("Nome vazio! Insira novamente:"));
        }

    }

    private static void leConta(Cliente cliente) {
        cliente.setNumConta(JOptionPane.showInputDialog("Insira o numero de conta do cliente:"));
        while (cliente.getNumConta().length() == 0){
            cliente.setNumConta(JOptionPane.showInputDialog("Numero de Conta vazio! Insira novamente:"));
        }
    }

    private static boolean contaExiste(ArrayList<Cliente> clientes, Cliente cliente) {
        return ( procurar(clientes, cliente.getNumConta())!= null );
    }

    private static void depositar(ArrayList<Cliente> clientes) {
        Cliente cliente = procurar(clientes);
        double saldo = cliente.getSaldo();
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor a ser depositado:"));
        saldo += valor;
        Date data = new Date();
        cliente.adicionarExtrato(data, "deposito", valor);
        cliente.setSaldo(saldo);
    }

    private static void sacar(ArrayList<Cliente> clientes) {
        Cliente cliente = procurar(clientes);
        double saldo = cliente.getSaldo();
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor a ser sacado:"));
        saldo -= valor;
        Date data = new Date();
        cliente.adicionarExtrato(data, "saque", valor);
        cliente.setSaldo(saldo);
    }



    private static Cliente procurar(ArrayList<Cliente> clientes) {
        String num = JOptionPane.showInputDialog("Insira o numero de conta do cliente:");
        Cliente consultado = null;
        for (Cliente cliente : clientes){
            if(cliente.getNumConta().equals(num)){
                consultado = cliente;
                break;
            }
        }
        if(consultado == null) {
            JOptionPane.showMessageDialog(null, "Cliente nao encontrado");
        }
        return consultado;
    }
    private static Cliente procurar(ArrayList<Cliente> clientes, String numConta) {
        Cliente consultado = null;
        for (Cliente cliente : clientes){
            if(cliente.getNumConta().equals(numConta)){
                consultado = cliente;
                break;
            }
        }
        return consultado;
    }

    private static void menuConsultar(int opcao, ArrayList<Cliente> clientes) {
        switch(opcao){
            case 1:
                consultar(clientes);
                break;
            case 2:
                consultarTodos(clientes);
                break;
            case 3:
                consultarNegativos(clientes);
                break;
            case 4:
                consultarMaiorSaldo(clientes);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcao Invalida! Tente novamente.");
        }
    }

    private static int leOpcaoConsulta() {
        try {
            String msg = "Opcoes:\n" +
                    "1 - Consultar uma conta\n" +
                    "2 - Consultar todas as contas\n" +
                    "3 - Conltar contas negativas\n" +
                    "4 - Consultar conta com maior saldo\n" +
                    "5 - sair";
            return Integer.parseInt(JOptionPane.showInputDialog(msg));
        }
        catch (NumberFormatException e){
            return 0;
        }
    }

    private static void consultar(ArrayList<Cliente> clientes) {
        if (isClientesEmpty(clientes)) return;
        Cliente cliente = procurar(clientes);
        if (cliente == null){
            JOptionPane.showMessageDialog(null, "Erro! Cliente nao encontrado!");
            return;
        }
        JOptionPane.showMessageDialog(null, getExtratoECliente(cliente));
    }

    private static String getExtratoECliente(Cliente cliente) {
        return cliente.toString() + "\n"
                + "\n"
                + cliente.mostrarTransacoes();
    }

    private static void consultarTodos(ArrayList<Cliente> clientes) {
        if (isClientesEmpty(clientes)) return;
        StringBuilder msg = new StringBuilder();
        msg.append("Contas:\n");
        for (Cliente cliente : clientes) {
            msg.append(cliente.toString())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, msg);
    }

    private static void consultarNegativos(ArrayList<Cliente> clientes) {
        if (isClientesEmpty(clientes)) return;
        StringBuilder msg = new StringBuilder();
        msg.append("Contas Negativas:\n");
        for (Cliente cliente : clientes) {
            if(cliente.getSaldo() < 0) {
                msg.append(cliente.toString())
                        .append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, msg);
    }

    private static void consultarMaiorSaldo(ArrayList<Cliente> clientes) {
        if (isClientesEmpty(clientes)) return;
        int i = 0, maior = 0;
        for (Cliente cliente : clientes) {
            if(cliente.getSaldo() >= clientes.get(maior).getSaldo()){
                maior = i;
            }
            i++;
        }
        JOptionPane.showMessageDialog(null, clientes.get(maior).toString());
    }

    private static boolean isClientesEmpty(ArrayList<Cliente> clientes) {
        if(clientes.isEmpty()){
            JOptionPane.showMessageDialog(null, "Erro! Lista de clientes vazia.");
            return true;
        }
        return false;
    }

    private static void excluir(ArrayList<Cliente> clientes) {
        String numConta = JOptionPane.showInputDialog("Insira o numero da conta a ser excluida:");
        Cliente cliente = procurar(clientes, numConta);
        boolean removeu = clientes.remove(cliente);
        if(!removeu){
            JOptionPane.showMessageDialog(null, "Conta nao encontrada!");
        }
    }
}
