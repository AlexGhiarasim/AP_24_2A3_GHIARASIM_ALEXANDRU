
import java.time.LocalTime;
/**
 * The Main class contains the main method to demonstrate the problem and solution
 */
public class Main {
    public static void main(String[] args) {
        Problem problem = new Problem();
        Vehicle vehicle1 = new Truck("Dacia", 50);
        Vehicle vehicle2 = new Truck("Mercedes",65);
        Vehicle vehicle3 = new Drone("Tesla",200);

        Depot depot1 = new Depot("Garaj1");
        depot1.setVehicles(vehicle1, vehicle2);

        Depot depot2 = new Depot("Garaj2");
        depot2.setVehicles(vehicle3);

        Client client1 = new Client();
        client1.setName("Client 1");
        client1.setMinTime(LocalTime.of(8, 0));
        client1.setMaxTime(LocalTime.of(12, 30));

        Client client2 = new Client("Client 2");
        client2.setMinTime(LocalTime.of(8, 15));
        client2.setMaxTime(LocalTime.of(14, 30));

        Client client3 = new Client("Client 3", LocalTime.NOON, LocalTime.MIDNIGHT);
        Client client4 = new Client("Client 4", ClientType.PREMIUM);
        client4.setMinTime(LocalTime.of(11, 25));
        client4.setMaxTime(LocalTime.of(14, 35));

        Client client5 = new Client("Client 5", ClientType.REGULAR);
        client5.setMinTime(LocalTime.of(8, 45));
        client5.setMaxTime(LocalTime.of(12, 35));

        Depot[] depots = new Depot[2];
        depots[0] = depot1;
        depots[1] = depot2;

        problem.setClients(client1, client2, client3, client4, client5); //adding the clients
        problem.setDepots(depots); //adding the depots

         System.out.println(problem); //printing all the components of the problem
         Solution solution = new Solution(problem); // an instance for Homework-solution
         solution.homeworkGreedyAllocation(); //Greedy algorithm from Homework which allocates clients to vehicles
         // go to Solution Class to see the implementation of homeworkGreedyAllocation method
    }
}
