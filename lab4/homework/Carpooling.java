
package org.example;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;
public class Carpooling {
    LinkedList<Driver> drivers = new LinkedList<>();
    TreeSet<Passenger> passengers = new TreeSet<>((p1, p2) -> p1.getName().compareTo(p2.getName()));

    public void randomPersons (int nrSoferi, int nrPas)
    {
        Faker faker= new Faker();
        for(int i=0;i < nrSoferi;i++)
            drivers.add(new Driver(faker.name().fullName(), faker.number().numberBetween(20, 60), faker.address().city()));

        for(int i=0;i<nrPas;i++)
            passengers.add(new Passenger(faker.name().fullName(), faker.number().numberBetween(18, 70), faker.address().city()));
    }

    public void Example() {
        // Adding example drivers and passengers
        drivers.add(new Driver("Driver John Doe", 35, "City A"));
        drivers.add(new Driver("Driver Jane Smith", 40, "City B"));

        passengers.add(new Passenger("Passenger Mike Brown", 25, "City A"));
        passengers.add(new Passenger("Passenger Lucy White", 30, "City B"));
        passengers.add(new Passenger("Passenger Chris Green", 22, "City A")); // Extra passenger to test unmatched scenario

    }


    public void printSortedDrivers() {
        drivers.stream()
                .sorted(Comparator.comparingInt(Driver::getAge))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }


    public void printSortedPassengers() {
        passengers.forEach(System.out::println);
    }

    public List<String> getDestinations() {
        return drivers.stream()
                .map(Driver::getDestination)
                .distinct()
                .collect(Collectors.toList());
    }


    public Map<String, List<Person>> getDestinationMap() {
        Map<String, List<Person>> destinationMap = new HashMap<>();
        List<Person> allPersons = new ArrayList<>();
        allPersons.addAll(drivers);
        allPersons.addAll(passengers);

        for (String destination : getDestinations()) {
            List<Person> peopleToDestination = allPersons.stream()
                    .filter(person -> person.getDestination().equals(destination))
                    .collect(Collectors.toList());
            destinationMap.put(destination, peopleToDestination);
        }

        return destinationMap;
    }


    public void greedyMatching() {
        List<Person> allPeople = new ArrayList<>();
        allPeople.addAll(drivers);
        allPeople.addAll(passengers);
        Map<String, List<Person>> groupedByDestination = allPeople.stream()
                .collect(Collectors.groupingBy(Person::getDestination));

        groupedByDestination.forEach((destination, people) -> {
            List<Driver> availableDrivers = people.stream()
                    .filter(p -> p instanceof Driver)
                    .map(p -> (Driver)p)
                    .collect(Collectors.toList());
            List<Passenger> passengersForDestination = people.stream()
                    .filter(p -> p instanceof Passenger)
                    .map(p -> (Passenger)p)
                    .collect(Collectors.toList());

            for (Driver driver : availableDrivers) {
                if (!passengersForDestination.isEmpty()) {
                    Passenger passenger = passengersForDestination.remove(0);
                    System.out.println(driver.getName() + " is driving " + passenger.getName() +
                            " to " + destination);
                }
            }
        });
    }
}
