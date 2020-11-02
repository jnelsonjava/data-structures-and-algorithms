package DataStructures.graph.breadthFirst;

import DataStructures.graph.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirst {
    public static ArrayList<Graph.GraphNode> breadthFirst(Graph.GraphNode node) {
        if (node == null) throw new NullPointerException("Input node is null");

        ArrayList<Graph.GraphNode> outputArray = new ArrayList<>();
        HashSet<Graph.GraphNode> encounteredNode = new HashSet<>();
        Queue<Graph.GraphNode> queue = new LinkedList<>();

        encounteredNode.add(node);
        queue.add(node);

        while (!queue.isEmpty()) {
            Graph.GraphNode tempNode = queue.remove();
            for (Graph.GraphEdge edge : tempNode.getEdges()) {
                Graph.GraphNode neighbor = edge.getDestination();
                if (encounteredNode.add(neighbor)) {
                    queue.add(neighbor);
                }
            }
            outputArray.add(tempNode);
        }

        return outputArray;
    }
}
