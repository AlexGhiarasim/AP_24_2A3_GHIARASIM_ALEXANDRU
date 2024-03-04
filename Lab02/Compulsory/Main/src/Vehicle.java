package Main.src;

import java.util.Objects;

public class Vehicle {
    private Depot depot;
    private String vehicleNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(depot, vehicle.depot) && Objects.equals(vehicleNumber, vehicle.vehicleNumber);
    }
    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "depot=" + depot +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                '}';
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Vehicle(Depot depot, String vehicleNumber) {
        this.depot = depot;
        this.vehicleNumber = vehicleNumber;
    }

    public Depot getDepot() {
        return depot;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

}