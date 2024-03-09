
public class Client
{
    public Client(String name, int visitingStartTime, int visitingEndTime, Main.ClientType clientType) {
    }

    public enum ClientType {    REGULAR,       PREMIUM; }
    private String name;
    private int timeStart;
    private int timeEnd;
    private ClientType type;

    public Client(String name, int visitingStartTime, int visitingEndTime, ClientType type)
    {
        this.name = name;
        this.timeStart = visitingStartTime;
        this.timeEnd = visitingEndTime;
        this.type = type;
    }
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getVisitingStartTime()
    {
        return timeStart;
    }

    public void setVisitingStartTime(int visitingStartTime)
    {
        this.timeStart = visitingStartTime;
    }

    public int getVisitingEndTime()
    {
        return timeEnd;
    }

    public void setVisitingEndTime(int visitingEndTime)
    {
        this.timeEnd = visitingEndTime;
    }

    public ClientType getType()
    {
        return type;
    }

    public void setType(ClientType type)
    {
        this.type = type;
    }
    @Override
    public String toString()
    {
        return "Client(" + "name='" + name + '\'' + ", timeStart = " + timeStart + ", timeEnd = " + timeEnd + ", type = " + type + ')';
    }
}