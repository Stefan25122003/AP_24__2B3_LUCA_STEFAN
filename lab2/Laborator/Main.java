
public class Main
{   public enum ClientType {REGULAR,PREMIUM }
    public static void main(String[] args)
    {
        Client regularClient = new Client("Client 1", 9, 17, ClientType.REGULAR);
        Client premiumClient = new Client("Client 2", 10, 16, ClientType.PREMIUM);
        Depot depot = new Depot("Depot Test");
        Vehicle vehicul = new Vehicle("Masina", depot);

        System.out.println(depot);
        System.out.println(vehicul);
        System.out.println(regularClient);
        System.out.println(premiumClient);
    }
}