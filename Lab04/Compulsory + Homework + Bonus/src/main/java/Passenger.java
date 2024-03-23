public class Passenger implements Person {
    private final String name;
    private final int age;
    private final Destination destination;
    public Passenger(String name, Destination destination, int age) {
        this.name = name;
        this.destination = destination;
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public Destination getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return name;
    }
}
