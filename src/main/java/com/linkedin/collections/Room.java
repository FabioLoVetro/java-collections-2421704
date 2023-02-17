package com.linkedin.collections;

import java.util.Objects;

public class Room {

    private String name;

    private String type;

    private int capacity;

    private double rate;

    public Room(String name, String type, int capacity, double rate) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.rate = rate;
    }

    public Room(String name, String type) {
        super();
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Room [name=" + name + ", type=" + type + ", capacity=" + capacity + ", rate=" + rate + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return getCapacity() == room.getCapacity() && getName().equals(room.getName()) && getType().equals(room.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getType(), getCapacity());
    }
}
