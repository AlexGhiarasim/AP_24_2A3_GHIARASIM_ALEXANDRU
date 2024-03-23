import com.github.javafaker.Faker;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)
    {
        //for Compulsory, I created a list with destinations and assigned randomly to a Person
        //also I generated a random age for every person and 0 or 1 to specify if a Person is
        //Driver of Passenger. All of these 3 help the program to generate a new Passenger or
        // a new Driver to be stored in listOfPersons and then to apply filters.
        // for Homework - I created Problem Class - with greedy algorithm and other required functionalities on the site
        // for Bonus - I have in Main Class - function bonus(), maximumCardinalitySet(), buildGraph(), generateDriverDestinations() -
        // with specific arguments for the functions. I hope it will be ok !!

        Faker faker = new Faker();
        List<Destination> listOfDestinations = new ArrayList<>();
        for(int i = 1; i <= 10; i++)
        {
            listOfDestinations.add(new Destination(faker.country().name()));
        }
        List<Person> listOfPersons = new ArrayList<>();
        List<Driver> listOfDrivers = new ArrayList<>();
        List<Passenger> listOfPassenger = new ArrayList<>();
        for(int i = 1; i <= 30; i ++)
        {
            Random random = new Random();
            String namePerson = faker.name().firstName() + " " + faker.name().lastName();
            int typeOfPerson = random.nextInt(2);
            int destination = random.nextInt(10);
            int age = random.nextInt(50) + 18;
            if(typeOfPerson == 0) //is a driver
            {
                Driver driver = new Driver(namePerson,listOfDestinations.get(destination), age);
                listOfPersons.add(driver);
                listOfDrivers.add(driver);
            }
            else // is a passenger
            {
                Passenger passenger = new Passenger(namePerson,listOfDestinations.get(destination), age);
                listOfPersons.add(passenger);
                listOfPassenger.add(passenger);
            }
        }

        Problem problem = new Problem(listOfDestinations, listOfPersons);
        System.out.println(problem + "\n");
        problem.greedyMatching(listOfPersons);
        bonus(listOfDrivers,listOfPassenger,listOfDestinations);
    }
    static void compulsory()
    {
        List<Destination> destinations = new ArrayList<>();
        destinations.add(new Destination("Paris"));
        destinations.add(new Destination("Iasi"));
        destinations.add(new Destination("Madrid"));
        destinations.add(new Destination("Praga"));
        destinations.add(new Destination("Viena"));
        destinations.add(new Destination("Suceava"));

        List<Person> listOfPersons = new ArrayList<>();
        generateGroupOfPersons(listOfPersons, destinations);

        LinkedList<Driver> drivers = listOfPersons.stream()
                .filter(person -> person instanceof Driver)
                .map(person -> (Driver) person)
                .sorted(Comparator.comparingInt(Driver::getAge))
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("Soferii sortati dupa varsta: ");
        drivers.forEach(System.out::println);

        TreeSet<Passenger> passengers = listOfPersons.stream()
                .filter(person -> person instanceof Passenger)
                .map(person -> (Passenger) person)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Passenger::getName))));

        System.out.println("\nPasagerii sortati dupa nume: ");
        passengers.forEach(System.out::println);
        System.out.println();

    }

    static void bonus(List<Driver> listOfDrivers, List<Passenger> listOfPassengers, List<Destination> listOfDestinations)
    {
        double probability = 0.1; //used to generate edges between Drivers and Passengers
        Graph<Person, DefaultEdge> graph = buildGraph(listOfDrivers, listOfPassengers, probability); // create the graph

        System.out.println("\nGraph:");
        for (DefaultEdge edge : graph.edgeSet()) {
            Person source = graph.getEdgeSource(edge);
            Person target = graph.getEdgeTarget(edge);
            System.out.println(STR."\{source.getName()} -> \{target.getName()}");
        }

        System.out.println(maximumCardinalitySet(graph,listOfDrivers, listOfDestinations)); //printing the maximum cardinality set
    }


    static Graph<Person, DefaultEdge> buildGraph(List<Driver> drivers, List<Passenger> passengers, double probability) {
        Graph<Person, DefaultEdge> graph = new DefaultUndirectedGraph<>(DefaultEdge.class);
        // firstly, the program creates the graph and add all the drivers and passengers as vertices
        // Then, with a probability of 0.1, edges will be added between Drivers and Passengers
        for (Driver driver : drivers) {
            graph.addVertex(driver);
        }
        for (Passenger passenger : passengers) {
            graph.addVertex(passenger);
        }

        for (Driver driver : drivers) {
            for (Passenger passenger : passengers) {
                if (Math.random() < probability) { // generates the edges with probability of 0.1 - specified on the problem from the site
                    graph.addEdge(driver, passenger);
                }
            }
        }
        return graph; //returning the graph
    }

    static int maximumCardinalitySet(Graph<Person, DefaultEdge> graph, List<Driver> drivers, List<Destination> listOfDestinations) {
        List<Person> maximumCardinalitySet = new ArrayList<>();
        // here the program creates for every driver a list of destinations where he may pass through, finishing the travel in his
        // destination -> driver.getDestination()
        Map<Driver, Set<Destination>> driverDestinations = generateDriverDestinations(drivers, listOfDestinations);

        // Iterates through all the vertices from the graph
        for (Person person : graph.vertexSet()) {
            boolean canAdd = true;
            //  Iterates through all the connected edges in node - person
            for (DefaultEdge edge : graph.edgesOf(person)) {
                Person neighbor = graph.getEdgeTarget(edge);
                // check if the current node is Passenger and the another part of edge (neighbor) - is a Driver (for safe)
                if (neighbor instanceof Driver && person instanceof Passenger) {

                    // if the passenger destination is in the list of Driver destinations where the driver may pass through
                    if (driverDestinations.get(neighbor).contains(person.getDestination())) {
                        canAdd = false;
                        break;
                    }
                }
                // check if the current node is Driver and the another part of edge (neighbor - is a Passenger (for safe)
                else if (neighbor instanceof Passenger && person instanceof Driver) {

                    if (driverDestinations.get(person).contains(neighbor.getDestination())) {
                        canAdd = false;
                        break;
                    }
                }
            }
            if (canAdd) { // this means that a person is not connected with any driver, and I could add in maximum set - which is a bipartite graph
                maximumCardinalitySet.add(person);
            }
        }
        System.out.println(maximumCardinalitySet);
        return maximumCardinalitySet.size();  // returns the size of bipartite graph (1st group is for drivers and 2nd is for passengers)
    }

    /**
     * generateDriverDestinations - is used to create the Map for each driver to specify in which destinations may pass through until arriving to his destination
     *
     * @param drivers --all drivers from the program
     * @param listOfDestinations -- all destinations from the map
     * @return - the map which represents the destinations for each driver where he may pass through
     */
    static Map<Driver, Set<Destination>> generateDriverDestinations(List<Driver> drivers, List<Destination> listOfDestinations) {
        Map<Driver, Set<Destination>> driverDestinations = new HashMap<>();
        Random random = new Random();
        for (Driver driver : drivers) {
            Set<Destination> destinations = new HashSet<>();
            destinations.add(driver.getDestination()); // first of all, I added the destination of driver, the remaining destinations from
            //this Set is in which destinations could go the drivers until arriving to finish the "journey"
            for (Destination destination : listOfDestinations) {
                // I will generate the list with probability of 0.25 for a destination to appear in this list for a specific driver.
                double probability = 0.25;
                if (Math.random() < probability) {
                    destinations.add(destination);
                }
            }
            driverDestinations.put(driver, destinations);
        }
        return driverDestinations;
    }
     static void generateGroupOfPersons(List<Person> listOfPersons, List<Destination> destinations) {
        // this function is used for Compulsory to generate names for Persons and create instances of Person class
        Random random = new Random();
        for(int i = 1; i <= 10; i++)
        {
            String name = STR."Person\{i}";
            int typeOfPerson = random.nextInt(2);
            int destination = random.nextInt(6);
            int age = random.nextInt(40) + 18;
            if(typeOfPerson == 0) //is a driver
            {
                Person driver = new Driver(name,destinations.get(destination), age);
                listOfPersons.add(driver);
            }
            else // is a passenger
            {
                Person passenger = new Passenger(name,destinations.get(destination), age);
                listOfPersons.add(passenger);
            }
        }
         System.out.println();
    }
}