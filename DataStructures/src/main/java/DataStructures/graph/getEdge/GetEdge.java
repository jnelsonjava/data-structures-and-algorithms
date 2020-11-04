package DataStructures.graph.getEdge;

import DataStructures.graph.Graph;

public class GetEdge {
    public static TripDetail checkTrip(Graph flights, String[] cities) throws Exception {
        if (cities.length < 2) {
            throw new Exception("cities must include at least two locations");
        }
        Graph.GraphNode current = null;
        for (Graph.GraphNode city : flights.getNodes()) {
            if (city.getValue().equals(cities[0])) {
                current = city;
            }
        }
        if (current == null) return new TripDetail(false, 0);
        int cost = 0;
        for (int i = 1; i < cities.length; i++) {
            int cheapest = Integer.MAX_VALUE;
            Graph.GraphEdge bestRoute = null;
            for (Graph.GraphEdge edge : current.getEdges()) {
                if (edge.getDestination().getValue().equals(cities[i])) {
                    if (bestRoute == null) {
                        cheapest = edge.getWeight();
                        bestRoute = edge;
                    } else {
                        if (edge.getWeight() < cheapest) {
                            cheapest = edge.getWeight();
                            bestRoute = edge;
                        }
                    }
                }
            }
            if (bestRoute == null) return new TripDetail(false, 0);
            cost += cheapest;
            current = bestRoute.getDestination();
        }
        return new TripDetail(true, cost);
    }

    public static class TripDetail {
        public boolean viable;
        public int cost;

        public TripDetail(boolean viable, int cost) {
            this.viable = viable;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "TripDetail{" +
                    "viable=" + viable +
                    ", cost=" + cost +
                    '}';
        }
    }

}
