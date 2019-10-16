import domain.PessoaFisica;
import domain.PessoaJuridica;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        try {
            //pegando clientes do arquivo

            File clientesFile = new File("/home/filipe/JavaInfnet/Operadora/src/resources/clientes");
            BufferedReader reader = new BufferedReader(new FileReader(clientesFile));
            String iterating;
            ArrayList<String> clientesStrings = new ArrayList<>();
            ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<>();
            ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<>();
            while ((iterating = reader.readLine()) != null){
                clientesStrings.add(iterating);
            }
            buildClients(clientesStrings, pessoasFisicas, pessoasJuridicas);
            boolean sair = false;
            while(!sair) {
                switch (menu()) {
                    case 1:
                        criar(pessoasFisicas, pessoasJuridicas);
                        break;
                    case 2:
                        alterar(pessoasFisicas, pessoasJuridicas);
                        break;
                    case 3:
                        excluir(pessoasFisicas, pessoasJuridicas);
                        break;
                    case 4:
                        relatorio(leOpcaoConsulta(), pessoasFisicas, pessoasJuridicas);
                        break;
                    case 5:
                        sair = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcao Invalida! Tente novamente.");
                }
            }
        }
        catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Arquivo de clientes não encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void buildClients(ArrayList<String> clientes, ArrayList<PessoaFisica> pessoasFisicas, ArrayList<PessoaJuridica> pessoasJuridicas) {
        String[] clienteSplited;
        for(String clienteString :
        clientes){
            clienteSplited = clienteString.split(";");
            if(Integer.parseInt(clienteSplited[2]) == 1){
                pessoasFisicas.add(new PessoaFisica(clienteSplited[0],0, clienteSplited[1], clienteSplited[3]));
            }
            else if(Integer.parseInt(clienteSplited[2]) == 2){
                pessoasJuridicas.add(new PessoaJuridica(clienteSplited[0],0, clienteSplited[1], clienteSplited[3]));
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

    private static int leOpcaoConsulta() {
        try {
            String msg = "Opcoes:\n" +
                    "1 - Consultar uma conta\n" +
                    "2 - Consultar todas as contas\n" +
                    "3 - Conltar contas negativas\n" +
                    "4 - Consultar conta com maior saldo\n" +
                    "5 - sair";
            return Integer.parseInt(JOptionPane.showInputDialog(msg));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static void relatorio(int opcao, ArrayList<PessoaFisica> pessoasFisicas, ArrayList<PessoaJuridica> pessoasJuridicas) {
        switch(opcao){
            case 1:
                consultarTodos(pessoasFisicas, pessoasJuridicas);
                break;
            case 2:
                consultarSaldoZero(pessoasFisicas, pessoasJuridicas);
                break;
            case 3:
                consultarPorSaldoX(pessoasFisicas, pessoasJuridicas);
                break;
            case 4:
                consultarMaiorSaldo(pessoasFisicas, pessoasJuridicas);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcao Invalida! Tente novamente.");
        }
    }
}