package utill;

public class Vehicle {
    private String vehicle_number;
    private String vehicle_type;
    private String weight;
    private int passengers;

    public Vehicle() {
    }

    public Vehicle(String vehicle_number, String vehicle_type, String weight, int passengers) {
        this.setVehicle_number(vehicle_number);
        this.setVehicle_type(vehicle_type);
        this.setWeight(weight);
        this.setPassengers(passengers);
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicle_number='" + vehicle_number + '\'' +
                ", vehicle_type='" + vehicle_type + '\'' +
                ", weight=" + weight +
                ", passengers=" + passengers +
                '}';
    }
}
