import java.util.Scanner;
import javax.swing.JOptionPane;

public class Application {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.setNome(JOptionPane.showInputDialog("Insira o nome do aluno."));
        aluno.setMatricula(JOptionPane.showInputDialog("Insira a matricula."));
        aluno.setNota1(Double.parseDouble(JOptionPane.showInputDialog("Insira a nota 1 do aluno.")));
        aluno.setNota2(Double.parseDouble(JOptionPane.showInputDialog("Insira a nota 2 do aluno.")));
        JOptionPane.showMessageDialog(null,aluno.avaliar());


//        aluno.setMatricula(leMatricula());
//        aluno.setNota1(leNota());
//        aluno.setNota2(leNota());
//        System.out.println(aluno.avaliar());
    }

    private static String leNome() {
        Scanner entrada = new Scanner(System.in);
        String nome;
        System.out.print("Escreva o nome do aluno: ");
        nome = entrada.nextLine();
        return nome;
    }

    private static String leMatricula() {
        Scanner entrada = new Scanner(System.in);
        String matricula;
        System.out.print("Escreva o matricula do aluno: ");
        matricula = entrada.nextLine();
        return matricula;
    }

    private static double leNota() {
        Scanner entrada = new Scanner(System.in);
        double nota;
        do {
            System.out.print("Escreva o nota do aluno: ");
            nota = entrada.nextDouble();
        }while(nota <0 || nota >10);
        return nota;
    }

}
