package DataStructures.graph;

import org.junit.Test;

import java.util.HashSet;

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
        Graph.GraphNode node = graph.addNode("cat");
        assertEquals("node set should have one node", 1, graph.nodes.size());
        for (Graph.GraphNode singleNode : graph.nodes) {
            assertEquals("the one node should be the same as returned", node, singleNode);
        }
        assertEquals("node should have value set", "cat", node.value);
        assertEquals("node should empty set of edges", 0, node.edges.size());
    }

    @Test
    public void testGetNodesOnEmptyGraph() {
        Graph graph = new Graph();
        assertNull("empty graph should return null for node request", graph.getNodes());
    }

    @Test
    public void testGetNodes() {
        Graph graph = new Graph();
        Graph.GraphNode cat = graph.addNode("cat");
        Graph.GraphNode dog = graph.addNode("dog");
        Graph.GraphNode snake = graph.addNode("snake");
        assertEquals("getNodes should return set with size 3", 3, graph.getNodes().size());
        assertTrue("set returned should contain all nodes added", graph.getNodes().contains(cat));
        assertTrue("set returned should contain all nodes added", graph.getNodes().contains(dog));
        assertTrue("set returned should contain all nodes added", graph.getNodes().contains(snake));
    }

    @Test
    public void testAddEdge() {
        Graph graph = new Graph();
        Graph.GraphNode cat = graph.addNode("cat");
        Graph.GraphNode dog = graph.addNode("dog");
        Graph.GraphNode snake = graph.addNode("snake");

        graph.addEdge(cat, dog);
        assertEquals("edge list should contain one edge", 1, cat.edges.size());
        assertEquals("edge list should contain one edge", 1, dog.edges.size());
        for (Graph.GraphEdge edge : cat.edges) {
            assertEquals("edge's destination should be other node", dog, edge.destination);
        }
        for (Graph.GraphEdge edge : dog.edges) {
            assertEquals("edge's destination should be other node", cat, edge.destination);
        }

        graph.addEdge(cat, snake, 5);
        assertEquals("edge list should update to two edges", 2, cat.edges.size());
        assertEquals("edge list should contain one edge", 1, snake.edges.size());
        for (Graph.GraphEdge edge : cat.edges) {
            if (edge.destination != dog) {
                assertEquals("edge's destination should be other node", snake, edge.destination);
            } else {
                assertEquals("edge's destination should be other node", dog, edge.destination);
            }
        }
        for (Graph.GraphEdge edge : snake.edges) {
            assertEquals("edge's destination should be other node", cat, edge.destination);
        }
    }

    @Test
    public void testAddEdgeDefaultWeight() {
        Graph graph = new Graph();
        Graph.GraphNode cat = graph.addNode("cat");
        Graph.GraphNode dog = graph.addNode("dog");
        Graph.GraphNode snake = graph.addNode("snake");
        graph.addEdge(cat, dog);
        graph.addEdge(cat, snake);
        for (Graph.GraphEdge edge : cat.edges) {
            assertEquals("all edges should default to weight 1 if not passed", 1, edge.weight);
        }
        for (Graph.GraphEdge edge : dog.edges) {
            assertEquals("all edges should default to weight 1 if not passed", 1, edge.weight);
        }
        for (Graph.GraphEdge edge : snake.edges) {
            assertEquals("all edges should default to weight 1 if not passed", 1, edge.weight);
        }
    }

    @Test
    public void testAddEdgeSpecifiedWeight() {
        Graph graph = new Graph();
        Graph.GraphNode cat = graph.addNode("cat");
        Graph.GraphNode dog = graph.addNode("dog");
        Graph.GraphNode snake = graph.addNode("snake");

        graph.addEdge(cat, dog, 3);
        for (Graph.GraphEdge edge : cat.edges) {
            assertEquals("edge weight should match specified input", 3, edge.weight);
        }
        for (Graph.GraphEdge edge : dog.edges) {
            assertEquals("edge weight should match specified input", 3, edge.weight);
        }


        graph.addEdge(cat, snake, 6);
        for (Graph.GraphEdge edge : cat.edges) {
            if (edge.destination != dog) {
                assertEquals("new edge should have specified weight", 6, edge.weight);
            } else {
                assertEquals("old edge weight should not change", 3, edge.weight);

            }
        }
        for (Graph.GraphEdge edge : snake.edges) {
            assertEquals("edge weight should match specified input", 6, edge.weight);
        }
    }

    @Test
    public void testGetNeighbors() {
        Graph graph = new Graph();
        Graph.GraphNode cat = graph.addNode("cat");
        Graph.GraphNode dog = graph.addNode("dog");
        Graph.GraphNode snake = graph.addNode("snake");

        graph.addEdge(cat, dog, 3);
        graph.addEdge(cat, snake, 6);
        HashSet<Graph.GraphEdge> catEdges = graph.getNeighbors(cat);
        HashSet<Graph.GraphEdge> dogEdges = graph.getNeighbors(dog);

        HashSet<Graph.GraphNode> catDestinations = new HashSet<>();
        for (Graph.GraphEdge edge : catEdges) catDestinations.add(edge.destination);
        assertEquals("cat should have two destinations in edges", 2, catDestinations.size());
        assertTrue("getNeighbors should return edges with destinations to both connected nodes", catDestinations.contains(dog));
        assertTrue("getNeighbors should return edges with destinations to both connected nodes", catDestinations.contains(snake));

        HashSet<Graph.GraphNode> dogDestinations = new HashSet<>();
        for (Graph.GraphEdge edge : dogEdges) dogDestinations.add(edge.destination);
        assertEquals("dog should have one destination in edges", 1, dogDestinations.size());
        assertTrue("getNeighbors should return edges with destinations to one connected node", dogDestinations.contains(cat));
    }

    @Test
    public void testSize() {
        Graph graph = new Graph();
        assertEquals("empty graph should have size 0", 0, graph.size());

        Graph.GraphNode cat = graph.addNode("cat");
        assertEquals("graph size should increase with new nodes", 1, graph.size());

        Graph.GraphNode dog = graph.addNode("dog");
        assertEquals("graph size should increase with new nodes", 2, graph.size());

        Graph.GraphNode snake = graph.addNode("snake");
        assertEquals("graph size should increase with new nodes", 3, graph.size());
    }

    @Test
    public void testEdgeDestinationEqualsOrigin() {
        Graph graph = new Graph();
        Graph.GraphNode cat = graph.addNode("cat");
        graph.addEdge(cat, cat);
        assertEquals("there should still be only one node", 1, graph.size());
        assertEquals("only one edge should be created", 1, graph.getNeighbors(cat).size());
        for (Graph.GraphEdge edge : graph.getNeighbors(cat)) {
            assertEquals("edge should have default weight", 1, edge.weight);
        }

        graph.addEdge(cat, cat, 3);
        assertEquals("there should still be only one node", 1, graph.size());
        assertEquals("one more unique edge should be created", 2, graph.getNeighbors(cat).size());
        boolean oneFound = false;
        boolean threeFound = false;
        for (Graph.GraphEdge edge : graph.getNeighbors(cat)) {
            if (edge.weight == 1) oneFound = true;
            if (edge.weight == 3) threeFound = true;
        }
        assertTrue("original weight edge should persist", oneFound);
        assertTrue("new weight edge should be added", threeFound);
    }

    @Test
    public void testAddEdgeToForeignNode() {
        Graph graph = new Graph();
        Graph.GraphNode cat = graph.addNode("cat");
        Graph.GraphNode falseNode = new Graph.GraphNode("falseNode");
        assertFalse("falseNode should not be in the graph", graph.getNodes().contains(falseNode));
        assertThrows("should throw NullPointerException if add edge is passed an unrelated node for destination",
                NullPointerException.class,
                () -> graph.addEdge(cat, falseNode));
        assertThrows("should throw NullPointerException if add edge is passed an unrelated node for origin",
                NullPointerException.class,
                () -> graph.addEdge(falseNode, cat));
        assertThrows("should throw NullPointerException if add edge is passed an unrelated node with weight for destination",
                NullPointerException.class,
                () -> graph.addEdge(cat, falseNode, 6));
        assertThrows("should throw NullPointerException if add edge is passed an unrelated node with weight for origin",
                NullPointerException.class,
                () -> graph.addEdge(cat, falseNode, 6));
    }
}
