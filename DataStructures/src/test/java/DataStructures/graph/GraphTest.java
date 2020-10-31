package DataStructures.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {
    @Test
    public void testEmptyGraph() {
        Graph graph = new Graph();
        assertNotNull("graph should be instantiated", graph);
        assertEquals("node set should be empty", 0, graph.nodes.size());
    }

    @Test
    public void testAddNode() {
        Graph graph = new Graph();
        graph.addNode("cat");
        assertEquals("node set should have one node", 1, graph.nodes.size());
    }
}
