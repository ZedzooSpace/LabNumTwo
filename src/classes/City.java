package classes;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<Path> paths;

    public City(String name) {
        this(name, new ArrayList<>());
    }

    public City(String name, List<Path> paths) {
        this.name = name;
        this.paths = new ArrayList<>(paths);
    }

    public String getName() { return name; }

    public void addPath(City dest, int cost) {
        this.paths.add(new Path(dest, cost));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name).append(" -> [");
        for (int i = 0; i < paths.size(); i++) {
            sb.append(paths.get(i));
            if (i < paths.size() - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
