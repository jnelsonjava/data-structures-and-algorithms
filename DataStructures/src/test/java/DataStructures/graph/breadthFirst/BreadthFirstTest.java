package DataStructures.graph.breadthFirst;

import DataStructures.graph.Graph;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.*;

public class BreadthFirstTest {
    public static Graph.GraphNode setupGraphNode() {
        Graph graph = new Graph();
        Graph.GraphNode a = graph.addNode("a");
        Graph.GraphNode b = graph.addNode("b");
        Graph.GraphNode c = graph.addNode("c");
        Graph.GraphNode d = graph.addNode("d");
        Graph.GraphNode e = graph.addNode("e");
        Graph.GraphNode f = graph.addNode("f");

        graph.addEdge(a, b);
        graph.addEdge(b, c);
        graph.addEdge(b, d);
        graph.addEdge(c, d);
        graph.addEdge(c, e);
        graph.addEdge(c, f);
        graph.addEdge(d, f);
        graph.addEdge(e, f);

        return a;
    }

    @Test
    public void testExpectedTraverse() {
        Graph.GraphNode node = setupGraphNode();

        ArrayList<Graph.GraphNode> output = BreadthFirst.breadthFirst(node);

        assertEquals("first index should be a", "a", output.get(0).getValue());
        assertEquals("second index should be b", "b", output.get(1).getValue());
        HashSet<String> thirdTier = new HashSet<>();
        thirdTier.add(output.get(2).getValue());
        thirdTier.add(output.get(3).getValue());
        assertTrue("third and fourth positions should contain c and d", thirdTier.contains("c"));
        assertTrue("third and fourth positions should contain c and d", thirdTier.contains("d"));
        HashSet<String> fourthTier = new HashSet<>();
        fourthTier.add(output.get(4).getValue());
        fourthTier.add(output.get(5).getValue());
        assertTrue("third and fourth positions should contain e and f", fourthTier.contains("e"));
        assertTrue("third and fourth positions should contain e and f", fourthTier.contains("f"));
    }

    @Test
    public void testNullInput() {
        Graph.GraphNode node = null;
        assertThrows("should throw NullPointerException if input is null",
                NullPointerException.class,
                () -> BreadthFirst.breadthFirst(node));
    }

    @Test
    public void testGraphWithMoreConnections() {
        Graph graph = new Graph();
        Graph.GraphNode a = graph.addNode("a");
        Graph.GraphNode b = graph.addNode("b");
        Graph.GraphNode c = graph.addNode("c");
        Graph.GraphNode d = graph.addNode("d");
        Graph.GraphNode e = graph.addNode("e");
        Graph.GraphNode f = graph.addNode("f");

        graph.addEdge(a, b);
        graph.addEdge(a, c);
        graph.addEdge(a, e);
        graph.addEdge(b, c);
        graph.addEdge(b, d);
        graph.addEdge(c, d);
        graph.addEdge(c, e);
        graph.addEdge(c, f);
        graph.addEdge(d, f);
        graph.addEdge(e, f);

        ArrayList<Graph.GraphNode> output = BreadthFirst.breadthFirst(a);

        assertEquals("first index should be a", "a", output.get(0).getValue());

        HashSet<String> secondTier = new HashSet<>();
        secondTier.add(output.get(1).getValue());
        secondTier.add(output.get(2).getValue());
        secondTier.add(output.get(3).getValue());
        assertTrue("third and fourth positions should contain b, c, and e", secondTier.contains("b"));
        assertTrue("third and fourth positions should contain b, c, and e", secondTier.contains("c"));
        assertTrue("third and fourth positions should contain b, c, and e", secondTier.contains("e"));

        HashSet<String> thirdTier = new HashSet<>();
        thirdTier.add(output.get(4).getValue());
        thirdTier.add(output.get(5).getValue());
        assertTrue("third and fourth positions should contain d and f", thirdTier.contains("d"));
        assertTrue("third and fourth positions should contain d and f", thirdTier.contains("f"));
    }
}
