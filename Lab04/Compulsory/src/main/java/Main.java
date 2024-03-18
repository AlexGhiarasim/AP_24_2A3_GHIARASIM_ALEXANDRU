import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)
    {
        //for Compulsory, I created a list with destinations and assigned randomly to a Person
        //also I generated a random age for every person and 0 or 1 to specify if a Person is
        //Driver of Passenger. All of these 3 help the program to generate a new Passenger or
        // a new Driver to be stored in listOfPersons and then to apply filters.

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
    }

     static void generateGroupOfPersons(List<Person> listOfPersons, List<Destination> destinations)
    {
        Random random = new Random();
        for(int i = 1; i <= 10; i++)
        {
            String name = "Person" + i;
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
    }
}