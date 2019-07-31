import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        leNome(aluno);
        leMatricula(aluno);
        leNota1(aluno);
        leNota2(aluno);
        System.out.println(aluno.avaliar());
    }

    private static void leNome(Aluno aluno) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escreva o nome do aluno: ");
        aluno.setNome(entrada.nextLine());
    }

    private static void leMatricula(Aluno aluno) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escreva o matricula do aluno: ");
        aluno.setMatricula(entrada.nextLine());
    }

    private static void leNota1(Aluno aluno) {
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.print("Escreva o nota 1 do aluno: ");
            aluno.setNota1(entrada.nextDouble());
        }while(aluno.getNota1()<0 || aluno.getNota1()>10);
    }

    private static void leNota2(Aluno aluno) {
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.print("Escreva o nota 2 do aluno: ");
            aluno.setNota2(entrada.nextDouble());
        }while(aluno.getNota2()<0 || aluno.getNota2()>10);
    }


}
