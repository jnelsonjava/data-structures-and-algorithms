# Graphs

A data structure for representing nodes and their unique connections

## Challenge

Implement a graph with methods to add nodes, add edges between nodes, get a collection of all nodes, get neighbors of a given node, and check the size of the graph.

## Approach & Efficiency
<!-- What approach did you take? Why? What is the Big O space/time for this approach? -->

I created the main Graph class and added a GraphNode class and GraphEdge class. The Graph simply tracks a set of GraphNodes as they are added. The GraphNodes each contain a value and a set of GraphEdges. The GraphEdges are created to represent connections between GraphNodes. Each GraphEdge contains a string referencing the value of its origin GraphNode, a pointer to its destination GraphNode, and an integer with the weight of the connection.

The internal methods are all very efficient since the nodes are hashed. The only variable space creation is related to the size of the input value.

Time Efficiency:
  - addNode : O(1)
  - addEdge : O(1)
  - getNodes : O(1)
  - getNeighbors : O(1)
  - size : O(1)

Space Efficiency:
  - addNode : O(n)
  - addEdge : O(1)
  - getNodes : O(1)
  - getNeighbors : O(1)
  - size : O(1)

## API

Graph Methods:
  - addNode : Takes in a string, creates a GraphNode holding that string value and stores it in the Graph. Returns the GraphNode.
  - addEdge : Takes in two GraphNodes and an optional integer weight and creates GraphEdges connecting the two GraphNodes. If a weight is not passed, it defaults to 1. If both GraphNodes passed are the same GraphNode, only one GraphEdge is created. If either of the GraphEdges passed are not in the Graph, throws a NullPointerException.
  - getNodes : Returns a HashSet of GraphNodes with all the GraphNodes currently in the Graph.
  - getNeighbors : Takes in a GraphNode and returns a HashSet with all the GraphEdges originating from that GraphNode.
  - size : Returns an integer count of the number of GraphNodes in the Graph.
