

abstract class Attraction implements Comparable<Attraction> {
    protected String name;
    protected String description;
    public Attraction(String name, String description) {
        this.name = name;
        this.description = description;
    }
    @Override
    public int compareTo(Attraction other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
