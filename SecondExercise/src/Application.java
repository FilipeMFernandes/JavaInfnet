import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        String numero = leNumero();
        String nome = leNome();
        int plano = lePlano();
        double saldo = leSaldo(plano);
        cliente.setNome(nome);
        cliente.setCelular(numero);
        cliente.setTipoPlano(plano);
        cliente.setSaldo(saldo);

        System.out.println(cliente.toString());

    }
    public static String leNumero(){
        Scanner entrada = new Scanner(System.in);
        String numero;
        System.out.print("Escreva o numero do cliente: ");
        numero = entrada.nextLine();
        return numero;
    }

    public static String leNome(){
        Scanner entrada = new Scanner(System.in);
        String nome;
        System.out.print("Escreva o nome do cliente: ");
        nome = entrada.nextLine();
        return nome;
    }
    public static int lePlano(){
        Scanner entrada = new Scanner(System.in);
        int plano;

        do {
            System.out.print("Escreva o plano do cliente: ");
            plano = entrada.nextInt();
        }while((plano!= 1) && (plano!= 2));
        return plano;
    }

    public static double leSaldo(int plano){
        Scanner entrada = new Scanner(System.in);
        double saldo;
        if(plano == 1){
            do {
                System.out.print("Escreva o saldo do cliente: ");
                saldo = entrada.nextDouble();
            }while(saldo<=0);
        }else{
            do {
                System.out.print("Escreva o saldo do cliente: ");
                saldo = entrada.nextDouble();
            }while(saldo!=0);
        }

        return saldo;
    }



}
