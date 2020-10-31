package DataStructures.graph;

import java.util.HashSet;

public class Graph {
    HashSet<GraphNode> nodes = new HashSet<>();

    public GraphNode addNode(String value) {
        GraphNode node = new GraphNode(value);
        nodes.add(node);
        return node;
    }

    public void addEdge(GraphNode nodeA, GraphNode nodeB) {
        if (!nodes.contains(nodeA) || !nodes.contains(nodeB)) throw new NullPointerException("GraphNode not contained in Graph");
        nodeA.addEdge(nodeB);
        nodeB.addEdge(nodeA);
    }

    public void addEdge(GraphNode nodeA, GraphNode nodeB, int weight) {
        if (!nodes.contains(nodeA) || !nodes.contains(nodeB)) throw new NullPointerException("GraphNode not contained in Graph");
        nodeA.addEdge(nodeB, weight);
        nodeB.addEdge(nodeA, weight);
    }

    public HashSet<GraphNode> getNodes() {
        if (nodes.size() == 0) return null;
        return nodes;
    }

    public HashSet<GraphEdge> getNeighbors(GraphNode node) {
        return node.edges;
    }

    public int size() {
        return nodes.size();
    }

    static class GraphNode {
        String value;
        HashSet<GraphEdge> edges = new HashSet<>();

        GraphNode(String value) {
            this.value = value;
        }

        void addEdge(GraphNode destination) {
            GraphEdge edge = new GraphEdge(value, destination.value);
            edges.add(edge);
        }

        void addEdge(GraphNode destination, int weight) {
            GraphEdge edge = new GraphEdge(value, destination.value, weight);
            edges.add(edge);
        }
    }

    static class GraphEdge {
        String origin;
        String destination;
        int weight = 1; // defaults to weight of 1 if not specified

        GraphEdge(String origin, String destination) {
            this.origin = origin;
            this.destination = destination;
        }

        GraphEdge(String origin, String destination, int weight) {
            this.origin = origin;
            this.destination = destination;
            this.weight = weight;
        }
    }
}
