package utill;

public class ParkVehicle {
    private String vehicleNumber;
    private String vehicleType;
    private int parkingSlot;
    private String parkedTime;

    public ParkVehicle() {
    }

    public ParkVehicle(String vehicleNumber, String vehicleType, int parkingSlot, String parkedTime) {
        this.setVehicleNumber(vehicleNumber);
        this.setVehicleType(vehicleType);
        this.setParkingSlot(parkingSlot);
        this.setParkedTime(parkedTime);
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(int parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getParkedTime() {
        return parkedTime;
    }

    public void setParkedTime(String parkedTime) {
        this.parkedTime = parkedTime;
    }
}
