package Main.src;

import java.time.LocalTime;
import java.util.Arrays;

class Problem {
    public Problem(Depot[] depots, Client[] clients) {
        this.depots = depots;
        this.clients = clients;
    }

    public void setDepots(Depot[] depots) {
        this.depots = depots;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    private Depot[] depots;

    @Override
    public String toString() {
        return "Problem{" +
                "depots=" + Arrays.toString(depots) +
                ", clients=" + Arrays.toString(clients) +
                '}';
    }

    public Depot[] getDepots() {
        return depots;
    }

    public Client[] getClients() {
        return clients;
    }

    private Client[] clients;
}

public class Main {
    public static void main(String[] args) {

        Vehicle vehicle1 = new Vehicle(null, "V12");
        Vehicle vehicle2 = new Vehicle(null, "V32");
        Vehicle[] vehicles = {vehicle1, vehicle2};
        Depot depot1 = new Depot("Garaj1", vehicles);

        Client client1 = new Client("George", LocalTime.of(8, 0), LocalTime.of(12, 30));
        Client client2 = new Client("Vasile");
        Client client3 = new Client("Alexandru", LocalTime.NOON, LocalTime.MIDNIGHT);
        Client[] clients = {client1, client2, client3};

        Depot[] depots = {depot1};
        Problem pb = new Problem(depots, clients);
        System.out.println("Depots:");
        for (Depot depot : pb.getDepots()) {
            System.out.println(depot);
        }
        System.out.println("Clients:");
        for (Client client : pb.getClients()) {
            System.out.println(client);
        }

        System.out.println("\n" + pb);
    }
}
