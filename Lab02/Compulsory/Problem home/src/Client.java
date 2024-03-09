import java.time.LocalTime;

public class Client {
    private String name;
    private ClientType clientType;
    private LocalTime minTime;
    private LocalTime maxTime;
    public Client() { }
    public Client(String name) {
        this.name = name;
        this.minTime = null;
        this.maxTime = null;
    }
    public Client(String name,ClientType clientType) {
        this.name = name;
        this.clientType = clientType;
    }
    public Client(String name,LocalTime minTime, LocalTime maxTime) {
        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
    }
    public Client(String name,ClientType clientType, LocalTime minTime, LocalTime maxTime) {
        this.name = name;
        this.clientType = clientType;
        this.minTime = minTime;
        this.maxTime = maxTime;
    }
    public ClientType getClientType() {
        return clientType;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }
    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }
    public String getName() {
        return name;
    }
    public LocalTime getMinTime() {
        return minTime;
    }
    public LocalTime getMaxTime() {
        return maxTime;
    }
    public String toString() {
        return name;
    }
}

