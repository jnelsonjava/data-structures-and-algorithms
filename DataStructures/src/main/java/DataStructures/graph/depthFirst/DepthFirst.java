package DataStructures.graph.depthFirst;

import DataStructures.graph.Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class DepthFirst {
    public static ArrayList<Graph.GraphNode> getNodesDepthFirst(Graph graph) {
        ArrayList<Graph.GraphNode> outputList = new ArrayList<>();
        HashSet<Graph.GraphNode> visited = new HashSet<>();
        if (graph.getNodes() != null) {
            for (Graph.GraphNode node : graph.getNodes()) {
                populateNodeList(node, outputList, visited);
            }
        }
        return outputList;
    }

    static void populateNodeList(Graph.GraphNode node, ArrayList<Graph.GraphNode> outputList, HashSet<Graph.GraphNode> visited) {
        if (visited.add(node)) {
            outputList.add(node);
            for (Graph.GraphEdge edge : node.getEdges()) {
                populateNodeList(edge.getDestination(), outputList, visited);
            }
        }
    }
}
