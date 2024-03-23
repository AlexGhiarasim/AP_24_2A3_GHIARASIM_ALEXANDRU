import lombok.Getter;

@Getter
public class Destination {
    private final String name;

    public Destination(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                '}';
    }
}
