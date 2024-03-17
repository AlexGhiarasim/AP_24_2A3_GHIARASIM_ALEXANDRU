
public abstract class Attraction implements Comparable<Attraction> {
    protected String name;
    protected String description;
    public Attraction(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public int compareTo(Attraction other) {
        if(name != null)
           return this.name.compareTo(other.name);
        else
            return -1;
    }

}
