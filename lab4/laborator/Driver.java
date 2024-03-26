package org.example;

public class Driver extends Person{
    public Driver(String name, int age, String destination) {
        super();
    }
    @Override
    public String toString() {
        return "Driver: " + getName() + ", Age: " + getAge() + ", Destination: ";
    }
}