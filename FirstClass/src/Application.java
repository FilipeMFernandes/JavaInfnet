import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Filipe","123543",1000);
        Cliente cliente2 = new Cliente();
        System.out.println("escreva o nome do cliente: ");
        Scanner entrada = new Scanner(System.in);
        cliente.setNome(entrada.nextLine());
        System.out.println(cliente.getSaldo());
        cliente.Creditar(500);
        System.out.println(cliente.getSaldo());
        cliente.Debitar(700);
        System.out.println(cliente.getSaldo());
        System.out.println(cliente.toString());


    }


}
