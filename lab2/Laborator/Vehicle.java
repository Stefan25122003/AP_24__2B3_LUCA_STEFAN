import java.util.List;
class Vehicle
{
    String name;
    private Depot depot;

    public Vehicle(String name, Depot depot)
    {
        this.name = name;
        this.depot = depot;
    }

    public Depot getDepot()
    {
        return depot;
    }

    public void setDepot(Depot depot)
    {
        this.depot = depot;
    }

    @Override
    public String toString()
    {
        return "Vehicle(" + "Depot = '" + depot + '\'' + ')';
    }
}