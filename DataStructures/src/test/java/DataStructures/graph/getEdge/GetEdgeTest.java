package DataStructures.graph.getEdge;

import DataStructures.graph.Graph;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetEdgeTest {
    public static Graph setupGraph() {
        // implementation of graph visual from whiteboard-ch-37a.PNG
        Graph graph = new Graph();
        Graph.GraphNode a = graph.addNode("a");
        Graph.GraphNode b = graph.addNode("b");
        Graph.GraphNode c = graph.addNode("c");
        Graph.GraphNode d = graph.addNode("d");
        Graph.GraphNode e = graph.addNode("e");
        Graph.GraphNode f = graph.addNode("f");

        graph.addEdge(a, b, 150);
        graph.addEdge(b, c, 99);
        graph.addEdge(b, d, 42);
        graph.addEdge(c, d, 105);
        graph.addEdge(c, e, 37);
        graph.addEdge(c, f, 26);
        graph.addEdge(d, f, 73);
        graph.addEdge(e, f, 250);

        return graph;
    }

    @Test
    public void testOneDirectConnection() throws Exception {
        Graph graph = setupGraph();
        GetEdge.TripDetail ab = GetEdge.checkTrip(graph, new String[]{"a", "b"});
        assertTrue("trip should be viable", ab.viable);
        assertEquals("cost should be edge weight of connection", 150, ab.cost);

        GetEdge.TripDetail ce = GetEdge.checkTrip(graph, new String[]{"c", "e"});
        assertTrue("trip should be viable", ce.viable);
        assertEquals("cost should be edge weight of connection", 37, ce.cost);
    }

    @Test
    public void testMultipleDirectConnections() throws Exception {
        Graph graph = setupGraph();
        GetEdge.TripDetail abc = GetEdge.checkTrip(graph, new String[]{"a", "b", "c"});
        assertTrue("trip should be viable", abc.viable);
        assertEquals("cost should be total edge weights of connections", 249, abc.cost);

        GetEdge.TripDetail dfecf = GetEdge.checkTrip(graph, new String[]{"d", "f", "e", "c", "f"});
        assertTrue("trip should be viable", dfecf.viable);
        assertEquals("cost should be total edge weights of connections", 386, dfecf.cost);
    }

    @Test
    public void testSingleIndirectConnection() throws Exception {
        Graph graph = setupGraph();
        GetEdge.TripDetail ac = GetEdge.checkTrip(graph, new String[]{"a", "c"});
        assertFalse("trip should not be viable", ac.viable);
        assertEquals("cost should be 0 for non-viable trip", 0, ac.cost);

        GetEdge.TripDetail be = GetEdge.checkTrip(graph, new String[]{"b", "e"});
        assertFalse("trip should not be viable", be.viable);
        assertEquals("cost should be 0 for non-viable trip", 0, be.cost);
    }

    @Test
    public void testMultipleIndirectConnection() throws Exception {
        Graph graph = setupGraph();
        GetEdge.TripDetail abe = GetEdge.checkTrip(graph, new String[]{"a", "b", "e"});
        assertFalse("trip should not be viable", abe.viable);
        assertEquals("cost should be 0 for non-viable trip", 0, abe.cost);

        GetEdge.TripDetail bdfb = GetEdge.checkTrip(graph, new String[]{"b", "d", "f", "b"});
        assertFalse("trip should not be viable", bdfb.viable);
        assertEquals("cost should be 0 for non-viable trip", 0, bdfb.cost);
    }

    @Test
    public void testNotEnoughCities() {
        Graph graph = setupGraph();
        assertThrows("empty city array should throw exception",
                Exception.class,
                () -> GetEdge.checkTrip(graph, new String[]{}));

        assertThrows("single city array should throw exception",
                Exception.class,
                () -> GetEdge.checkTrip(graph, new String[]{"a"}));
    }

    @Test
    public void testSingleConnectionWithMultipleRoutes() throws Exception {
        Graph graph = new Graph();
        Graph.GraphNode a = graph.addNode("a");
        Graph.GraphNode b = graph.addNode("b");
        graph.addEdge(a, b, 150);
        graph.addEdge(a, b, 115);
        graph.addEdge(a, b, 100);

        GetEdge.TripDetail ab = GetEdge.checkTrip(graph, new String[]{"a", "b"});
        assertTrue("trip should be viable", ab.viable);
        assertEquals("cost should be edge weight of smallest connection", 100, ab.cost);

        graph.addEdge(b, a, 42);
        ab = GetEdge.checkTrip(graph, new String[]{"a", "b"});
        assertTrue("trip should be viable", ab.viable);
        assertEquals("cost should be edge weight of smallest connection", 42, ab.cost);
    }

    @Test
    public void testMultipleConnectionWithMultipleRoutes() throws Exception {
        Graph graph = new Graph();
        Graph.GraphNode a = graph.addNode("a");
        Graph.GraphNode b = graph.addNode("b");
        Graph.GraphNode c = graph.addNode("c");
        graph.addEdge(a, b, 150);
        graph.addEdge(a, b, 115);
        graph.addEdge(a, b, 2);
        graph.addEdge(a, c, 80);
        graph.addEdge(b, c, 2);
        graph.addEdge(b, c, 60);

        GetEdge.TripDetail abc = GetEdge.checkTrip(graph, new String[]{"a", "b", "c"});
        assertTrue("trip should be viable", abc.viable);
        assertEquals("cost should be total edge weights of smallest connections", 4, abc.cost);

        graph.addEdge(b, c, 1);
        abc = GetEdge.checkTrip(graph, new String[]{"a", "b", "c"});
        assertTrue("trip should be viable", abc.viable);
        assertEquals("cost should be total edge weights of smallest connections", 3, abc.cost);
    }

    @Test
    public void testCityNotInGraph() throws Exception {
        Graph graph = setupGraph();
        GetEdge.TripDetail azc = GetEdge.checkTrip(graph, new String[]{"a", "z", "c"});
        assertFalse("trip should not be viable", azc.viable);
        assertEquals("cost should be 0 for non-viable trip", 0, azc.cost);

        GetEdge.TripDetail zab = GetEdge.checkTrip(graph, new String[]{"z", "a", "b"});
        assertFalse("trip should not be viable", zab.viable);
        assertEquals("cost should be 0 for non-viable trip", 0, zab.cost);
    }
}
