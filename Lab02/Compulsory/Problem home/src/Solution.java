import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
/**
 * Represents a solution to the Vehicle Routing Problem (VRP) using a greedy algorithm.
 * This class provides methods for allocating clients to vehicles and generating tours
 */
public class Solution {
    private final Problem problem;
    public Solution(Problem problem) {
        this.problem = problem;
    }

    public void homeworkGreedyAllocation() {    // GREEDY APPROACH - from HOMEWORK
        // Greedy approach is used when I chose between the travelling times,
        // and the implemented algorithm chose the shortest time to travel between 2 places !!!
        Random random = new Random(); // used to generate a random number
        int dimension = problem.getClients().length;

        int[][] travelTimeClients = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (i == j) {
                    travelTimeClients[i][j] = 999999; // because you can't go from a place A to the same place A, and this value is huge to prevent this situation in code
                } else {
                    travelTimeClients[i][j] = random.nextInt(200) + 1; // used to generate a number between 1 and 200 (inclusive)
                }
            }
        }

        int numberOfDepots = problem.getDepots().length;
        int[][] travelTimeFromDepots = new int[numberOfDepots][dimension];
        for (int i = 0; i < numberOfDepots; i++) {
            for (int j = 0; j < dimension; j++) {
                travelTimeFromDepots[i][j] = random.nextInt(200) + 1; // Here, I generated the travelling time from every depot to all the clients
            }
        }

        ArrayList<Tour> tourVehicles = new ArrayList<>(); // I need class Tour to create object which describe the path of a vehicle
        int indexDepot = 0; // I will iterate with all the vehicles from a depot, referenced with index.
        for (Depot depot : problem.getDepots()) {
            for (Vehicle vehicle : depot.getVehicles()) {  // I will start the allocation for each vehicle
                LocalTime localTime = LocalTime.of(0, 1); // starting the day
                Tour tour = new Tour(vehicle); // a new tour for a vehicle, starting for its depot
                ArrayList<Client> listOfVisitedClients = new ArrayList<>(); // very important to know which clients will be visited to avoid the ways
                // of visiting twice a client
                int indexClient;

                // In this while I will calculate the shortest travelling time from a specific depot(given by index) to a client.
                while (true) {
                    indexClient = shortestTime(travelTimeFromDepots[indexDepot], problem, localTime,listOfVisitedClients);

                    if (indexClient == -1) {
                        localTime = localTime.plusMinutes(10);
                    } else {
                        listOfVisitedClients.add(problem.getClients()[indexClient]); // Here I added the first visited client by the current vehicle
                        localTime = localTime.plusMinutes(travelTimeFromDepots[indexDepot][indexClient]);
                        break; // next while will be for more clients, here is for one, and this separate case is because the vehicle has the starting
                               // point from a depot and afterward it will go to clients.
                    }
                }

                int indexForClientToClient; // an index to refer a next client, meanwhile indexClient - is for the current client
                while (true) {
                    indexForClientToClient = shortestTime(travelTimeClients[indexClient], problem, localTime,listOfVisitedClients);
                    if(localTime.getHour() > 22) // I added this to specify an interval time for driving the vehicles, and to stop the activity of travelling.
                        break;
                    if (indexForClientToClient == -1) {
                        break; // if there is no another possible client to visit, according to interval time
                    } else {
                        if (!listOfVisitedClients.contains(problem.getClients()[indexForClientToClient]))  // if the client is not already visited
                        {
                            localTime = localTime.plusMinutes(travelTimeClients[indexClient][indexForClientToClient]); // changing the current time for vehicle
                            listOfVisitedClients.add(problem.getClients()[indexForClientToClient]); //adding a new client in the list of visited clients
                            indexClient = indexForClientToClient; // I changed the index because the vehicle moved to another client
                        }
                    }
                }

                Client[] arrayClients = listOfVisitedClients.toArray(new Client[0]);
                tour.setClients(arrayClients);
                tourVehicles.add(tour);
            }
            indexDepot++; // The program moves to the next depot - which could include one or more vehicles, or no one. But a vehicle must belong to a depot
        }

        System.out.println("\nSolution for Homework - greedy allocation:");
        for (Tour tour : tourVehicles) { //printing the tours for every vehicle
            System.out.print("Tour for " + tour.getVehicle().getName() + " is: depot, ");
            for (Client client : tour.getClients()) {
                System.out.print(client + ", ");
            }
            System.out.print("depot\n");
        }
    }
    /**
     * This function, shortestTime, is responsible for calculating the shortest time from a depot to clients
     * or from a client to another client, based on the time required to travel between the locations.
     * @param arrayTimes is a vector with all the times required to travel from a specific place (depot or a client)
     * to another client. For example, index 2 in arrayTimes corresponds to the 3rd client from problem.getClients(),
     * and something like that I access any vector or matrix.
     * @param listOfVisitedClients - is to avoid the scenarios when a vehicle visits twice a client.
     * @param problem describe the elements of the VRP
     * @return The returning value is indexMinTime, which corresponds to the index of the client from arrayTimes.
     * arrayTimes is in minutes !!!
     */
    private static int shortestTime(int[] arrayTimes, Problem problem, LocalTime localTime, ArrayList<Client> listOfVisitedClients) {

        int minTimeTraveling = 99999;
        int indexMinTime = -1;

        for (int i = 0; i < arrayTimes.length; i++) {
            int hours = arrayTimes[i] / 60;  // parsing minutes in hours
            int minutes = arrayTimes[i] % 60;

            LocalTime calculatedTime = localTime.plusHours(hours).plusMinutes(minutes);
            Client currentClient = problem.getClients()[i];
            // a vehicle could visit a client if arrival time is in visiting time interval !!!
            if ((arrayTimes[i] < minTimeTraveling) && currentClient.getMinTime().isBefore(calculatedTime) &&
                    currentClient.getMaxTime().isAfter(calculatedTime) && !listOfVisitedClients.contains(currentClient)) {

                minTimeTraveling = arrayTimes[i];
                indexMinTime = i;
            }
        }
        return indexMinTime;
    }
}
