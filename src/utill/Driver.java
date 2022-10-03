package utill;

import java.util.Objects;

public class Driver extends Object {
    private String name;
    private String nic;
    private String driven_Licence_no;
    private String address;
    private int contact;

    public Driver() {
    }
    static Driver driverList[]=new Driver[16];
    static {
        //driverList[0].
    }

    public Driver(String name, String nic, String driven_Licence_no, String address, int contact) {
        this.setName(name);
        this.setNic(nic);
        this.setDriven_Licence_no(driven_Licence_no);
        this.setAddress(address);
        this.setContact(contact);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDriven_Licence_no() {
        return driven_Licence_no;
    }

    public void setDriven_Licence_no(String driven_Licence_no) {
        this.driven_Licence_no = driven_Licence_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return   name +
                "," + nic +
                "," + driven_Licence_no +
                "," + address +
                "," + contact ;
    }
}
