import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        boolean sair = false;
        Empregado empregado = new Empregado();
        while(!sair){
            switch (menu()){
                case 1:
                    empregado = criarEmpregado();
                    break;
                case 2:
                    alterarSalario(empregado);
                    break;
                case 3:
                    consultarAnual(empregado);
                    break;
                case 4:
                    consultarInfo(empregado);
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opçao inválida!");
            }
        }
    }

    private static void consultarInfo(Empregado empregado) {
        JOptionPane.showMessageDialog(null, empregado.toString());
    }

    private static void consultarAnual(Empregado empregado) {
        JOptionPane.showMessageDialog(null, "O salario anual do funcionario " + empregado.getNome() + " " + empregado.getSobrenome() + ": " + empregado.getSalario()*12);
    }

    private static void alterarSalario(Empregado empregado) {
        long porcentagem = Long.parseLong(JOptionPane.showInputDialog("Entre com o valor a ser alterado do salario, em %:"));
        long salario = empregado.getSalario();
        salario += (salario*porcentagem)/100;
        empregado.setSalario(salario);
    }

    private static Empregado criarEmpregado() {
        Empregado empregado = new Empregado();
        leNomeSobrenome(empregado);
        leSalario(empregado);
        leMatricula(empregado);
        return empregado;
    }

    private static void leMatricula(Empregado empregado) {
        empregado.setMatricula(JOptionPane.showInputDialog("Escreva o matricula do empregado:"));
        while(empregado.getMatricula().equals("")){
            empregado.setMatricula(JOptionPane.showInputDialog("Matricula vazio, escreva novamente:"));
        }
    }

    private static void leSalario(Empregado empregado) {
        empregado.setSalario(Integer.parseInt(JOptionPane.showInputDialog("Escreva o salario do empregado:")));
        while(empregado.getSalario()<=0){
            empregado.setSalario(Integer.parseInt(JOptionPane.showInputDialog("Salario invalido, escreva novamente:")));
        }
    }

    private static void leNomeSobrenome(Empregado empregado) {
        empregado.setNome(JOptionPane.showInputDialog("Escreva o nome do empregado:"));
        while(empregado.getNome().equals("")){
            empregado.setNome(JOptionPane.showInputDialog("Nome vazio, escreva novamente:"));
        }
        empregado.setSobrenome(JOptionPane.showInputDialog("Escreva o sobrenome do empregado:"));
        while(empregado.getSobrenome().equals("")){
            empregado.setSobrenome(JOptionPane.showInputDialog("Sobrenome vazio, escreva novamente:"));
        }
    }

    public static int menu(){
        String msg = "Escolha um opçao: \n" +
                "1 - Criar Empregado\n" +
                "2 - Alterar Salário\n" +
                "3 - Consultar Salário anual\n" +
                "4 - Consultar informaçoes do Empregado\n" +
                "5 - Sair";
        return Integer.parseInt(JOptionPane.showInputDialog(msg));
    }
}
