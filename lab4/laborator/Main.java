package org.example;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main
{
    private static List<Person> generate(int count)
    {
        Random random = new Random();
        List<Person> people = new ArrayList<>();

        while (people.size() < count)
        {
            int age = 18 + random.nextInt(42);
            String destination = "Destination" + random.nextInt(5);
            if (random.nextBoolean())
            {
                people.add(new Driver("Driver" + people.size(), age, destination));
            }
            else
            {
                people.add(new Passenger("Passenger" + (people.size() + random.nextInt(people.size() + 30)), age, destination));
            }
        }

        return people;
    }
    public static void main(String[] args)
    {
        List<Person> persons = generate(10);
        List<Driver> drivers = persons.stream()
                .filter(p -> p instanceof Driver)
                .map(p -> (Driver) p)
                .collect(Collectors.toCollection(LinkedList::new));

        Set<Passenger> passengers = persons.stream()
                .filter(p -> p instanceof Passenger)
                .map(p -> (Passenger) p)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(p -> p.getName() != null ? p.getName() : ""))));

        drivers.sort(Comparator.comparingInt(Person::getAge));
        System.out.println("The Drivers:");
        drivers.forEach(System.out::println);

        System.out.println("The Passengers:");
        passengers.forEach(System.out::println);
    }
}