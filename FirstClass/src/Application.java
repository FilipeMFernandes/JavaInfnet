public class Application {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Filipe","123543",1000);
        System.out.println(cliente.getSaldo());
        cliente.Creditar(500);
        System.out.println(cliente.getSaldo());
        cliente.Debitar(700);
        System.out.println(cliente.getSaldo());
    }


}
