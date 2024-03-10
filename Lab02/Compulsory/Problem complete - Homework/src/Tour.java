public class Tour {
    public Tour(Vehicle vehicle, Client[] clients) {
        this.vehicle = vehicle;
        this.clients = clients;
    }

    public Tour(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Client[] getClients() {
        return clients;
    }

    private Vehicle vehicle;
    private Client[] clients;
}
