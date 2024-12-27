import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Collection<Node> nodes;
    private final Collection<Edge> edges;
    private final Map<String, String> attributes;

    public Graph() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        attributes = new HashMap<>();
    }

    public Graph(Map<String, String> attributes) {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        this.attributes = new HashMap<>(attributes);
    }

    public Collection<Node> getNodes() {
        return nodes;
    }

    public Collection<Edge> getEdges() {
        return edges;
    }

    public Graph node(String name) {
        nodes.add(new Node(name));
        return this;
    }

    public Graph node(String name, Map<String, String> attributes) {
        nodes.add(new Node(name, attributes));
        return this;
    }

    public Graph edge(String start, String end) {
        edges.add(new Edge(start, end));
        return this;
    }

    public Graph edge(String start, String end, Map<String, String> attributes) {
        edges.add(new Edge(start, end, attributes));
        return this;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
