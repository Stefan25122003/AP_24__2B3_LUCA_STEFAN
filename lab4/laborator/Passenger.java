package org.example;

public class Passenger extends Person {
    private String name;
    private int age;
    private String destination;
    public Passenger(String name, int age, String destination) {
        super();
    }
    @Override
    public String toString() {
        return "Driver: " + getName() + ", Age: " + getAge() + ", Destination: ";
    }
}