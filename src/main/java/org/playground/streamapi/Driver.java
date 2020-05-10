package org.playground.streamapi;

import java.util.List;

public class Driver {
    private String name;
    private String surname;
    private List<String> info;
    private Vehicle vehicle;

    public Driver(String name, String surname, Vehicle vehicle) {
        this.name = name;
        this.surname = surname;
        this.vehicle = vehicle;
    }

    public static boolean isRealDriver(Driver d){
        return d.vehicle!=null;
    }

    public List<String> getInfo() {
        return info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
