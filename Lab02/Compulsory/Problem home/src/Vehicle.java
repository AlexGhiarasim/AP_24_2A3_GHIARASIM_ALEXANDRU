
public abstract class Vehicle {
    private Depot depot;  //field
    protected String name; //field
    public Vehicle(String name) { //constructor
        this.name = name;
    }
    public Vehicle() {} //constructor
    public Depot getDepot() { //getter
        return depot;
    }
    public String getName() { //getter
        return name;
    }
    public void setName(String name) { //setter
        this.name = name;
    }
    public void setDepot(Depot depot) { //setter
        this.depot = depot;
    }

    @Override
    public boolean equals(Object obj) {  //generated method equals for not to have 2 Vehicle with the same name
        if (!(obj instanceof Vehicle other)) {
            return false;
        }
        return name.equals(other.name);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "depot=" + depot +
                ", name='" + name + '\'' +
                '}';
    }
}

