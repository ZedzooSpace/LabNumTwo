package classes;

public class Path {
    private City destination;
    private int cost;

    public Path(City destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }

    public City getDestination() { return destination; }
    public int getCost() { return cost; }

    @Override
    public String toString() {
        return destination.getName() + ":" + cost;
    }
}