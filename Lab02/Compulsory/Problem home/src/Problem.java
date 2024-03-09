import java.util.ArrayList;
import java.util.Arrays;

public class Problem {
    private Client[] clients;
    private Depot[] depots;
    public Problem() {}
    public Problem(Depot[] depots, Client[] clients) {
        this.depots = depots;
        this.clients = clients;
    }
    public void setDepots(Depot[] depots) {
        this.depots = depots;
    }
    public void setClients(Client... clients) {
        this.clients = clients;
    }
    public Depot[] getDepots() {
        return depots;
    }
    public Client[] getClients() {
        return clients;
    }
    public ArrayList<Vehicle> getVehicles() {
        ArrayList<Vehicle> allVehicles = new ArrayList<>();
        for (Depot depot : depots) {
            if (depot.getVehicles() != null) {
                allVehicles.addAll(Arrays.asList(depot.getVehicles()));
            }
        }
        return allVehicles;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "clients=" + Arrays.toString(clients) +
                ", depots=" + Arrays.toString(depots) +
                '}';
    }
}
