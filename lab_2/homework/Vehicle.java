abstract class Vehicle {
    protected String name;
    protected Depot depot;

    public Vehicle(String name, Depot depot) {
        this.name = name;
        this.depot = depot;
    }

    public Depot getDepot()
    {
        return this.depot;
    }

    public void setDepot(Depot depot)
    {
        this.depot = depot;
    }

    @Override
    public abstract String toString();
}

class Truck extends Vehicle {
    private int capacity;

    public Truck(String name, Depot depot, int capacity) {
        super(name, depot);
        this.capacity = capacity;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Truck(name='" + name + "', capacity=" + capacity + ")";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return name.equals(vehicle.name) && depot.equals(vehicle.depot);
    }

}

class Drone extends Vehicle {
    private int maxFlightDuration;

    public Drone(String name, Depot depot, int maxFlightDuration) {
        super(name, depot);
        this.maxFlightDuration = maxFlightDuration;
    }

    public int getMaxFlightDuration()
    {
        return maxFlightDuration;
    }

    public void setMaxFlightDuration(int maxFlightDuration)
    {
        this.maxFlightDuration = maxFlightDuration;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return name.equals(vehicle.name) && depot.equals(vehicle.depot);
    }


    @Override
    public String toString() {
        return "Drone(name='" + name + "', maxFlightDuration=" + maxFlightDuration + ")";
    }
}
