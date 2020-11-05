package DataStructures.graph.depthFirst;

import DataStructures.graph.Graph;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DepthFirstTest {
    public static Graph setupCyclicalGraph() {
        Graph graph = new Graph();
        Graph.GraphNode a = graph.addNode("a");
        Graph.GraphNode b = graph.addNode("b");
        Graph.GraphNode c = graph.addNode("c");
        Graph.GraphNode d = graph.addNode("d");
        Graph.GraphNode e = graph.addNode("e");
        Graph.GraphNode f = graph.addNode("f");
        Graph.GraphNode g = graph.addNode("g");
        Graph.GraphNode h = graph.addNode("h");

        graph.addEdge(a, b);
        graph.addEdge(b, c);
        graph.addEdge(c, d);
        graph.addEdge(d, e);
        graph.addEdge(e, f);
        graph.addEdge(f, g);
        graph.addEdge(g, h);
        graph.addEdge(h, a);

        return graph;
    }

    @Test
    public void testCyclicalGraph() {
        Graph graph = setupCyclicalGraph();
        ArrayList<Graph.GraphNode> output = DepthFirst.getNodesDepthFirst(graph);
        assertEquals("output should be same size as input graph", graph.size(), output.size());

        String[] orderReference = {"a","b","c","d","e","f","g","h"};
        String nodeVal = output.get(0).getValue();
        String nextVal = output.get(1).getValue();
        int index;
        for (index = 0; index < orderReference.length; index++) {
            if (nodeVal.equals(orderReference[index])) break;
        }
        int offset = 0;
        if (nextVal.equals(orderReference[(index + 1) % orderReference.length])) {
            offset = 1;
        } else {
            offset = -1;
        }
        int iter = offset;
        for (int i = 1; i < output.size(); i++) {
            nextVal = output.get(i).getValue();
            String compareVal = orderReference[(index + offset) % orderReference.length];
            System.out.println("comparing " + nextVal + " to " + compareVal);
            assertEquals("the depth first traversal should travel in one direction around the loop of adjacent nodes",
                    nextVal,
                    compareVal);
            offset += iter;
            if (index + offset == -1) offset += orderReference.length;
        }
    }

    @Test
    public void testDetachedNode() {
        Graph graph = setupCyclicalGraph();
        graph.addNode("i");
        ArrayList<Graph.GraphNode> output = DepthFirst.getNodesDepthFirst(graph);
        assertEquals("output should be same size as input graph", graph.size(), output.size());
        assertTrue("detached node should either be first or last",
                output.get(0).getValue().equals("i") ||
                        output.get(output.size() - 1).getValue().equals("i"));

        HashSet<Graph.GraphNode> checkUnique = new HashSet<>();
        for (Graph.GraphNode node : output) {
            assertTrue("all nodes should be unique", checkUnique.add(node));
        }
    }

    @Test
    public void testEmptyGraph() {
        Graph graph = new Graph();
        ArrayList<Graph.GraphNode> output = DepthFirst.getNodesDepthFirst(graph);
        assertEquals("output list should be empty", 0, output.size());
    }
}
