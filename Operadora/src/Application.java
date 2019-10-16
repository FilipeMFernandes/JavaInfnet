import domain.PessoaFisica;
import domain.PessoaJuridica;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;


public class Application {
    public static void main(String[] args) {
        try {
            //pegando clientes do arquivo

            File file = new File(".resources/clientes");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String iterating;
            ArrayList<String> clientesStrings = new ArrayList<>();
            ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<>();
            ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<>();
            while ((iterating = reader.readLine()) != null){
                String[] stringSplit = iterating.split(";");
                clientesStrings.add(iterating);
            }
            buildClients(clientesStrings, pessoasFisicas, pessoasJuridicas);
            boolean sair = false;
            while(!sair) {
                switch (menu()) {
                    case 1:
                        criar(writer, pessoasFisicas, pessoasJuridicas);
                        break;
                    case 2:
//                        alterar(clientesFile, pessoasFisicas, pessoasJuridicas);
                        break;
                    case 3:
//                        excluir(clientesFile, pessoasFisicas, pessoasJuridicas);
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

    private static void criar(BufferedWriter writer, ArrayList<PessoaFisica> pessoasFisicas, ArrayList<PessoaJuridica> pessoasJuridicas) {
        switch(JOptionPane.showInputDialog("Insira 1 para criar uma pessoa Fisica ou insira 2 para criar uma pessoa Juridica:")){
            case"1":
                String numero = leiaNumero();
                String nome = leiaNome(1);
        }


    }

    private static String leiaNome(int tipoPessoa) {
        if(tipoPessoa == 1){
            return JOptionPane.showInputDialog("Insira o nome do cliente:");
        }else if(tipoPessoa == 2){
            return JOptionPane.showInputDialog("Insira a razáo social do cliente:");
        }
//        throw new Exception("Something unexpected happened, call the developers");
        return "";
    }

    private static String leiaNumero() {
        String numero = JOptionPane.showInputDialog("Insira o numero do cliente:");
        while(numero.length() != 8){
            numero = JOptionPane.showInputDialog("O numero deve ter 8 digitos! Insira novamente:");
        }
        return numero;
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
//                consultarTodos(pessoasFisicas, pessoasJuridicas);
                break;
            case 2:
//                consultarSaldoZero(pessoasFisicas, pessoasJuridicas);
                break;
            case 3:
//                consultarPorSaldoX(pessoasFisicas, pessoasJuridicas);
                break;
            case 4:
//                consultarMaiorSaldo(pessoasFisicas, pessoasJuridicas);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcao Invalida! Tente novamente.");
        }
    }
}