import java.util.*;

public class PrimsAlgo {
    static class Edge {
        int src, dest, wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node, cost;

        Pair(int n, int c) {
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair c2) {
            return this.cost - c2.cost;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        // 0 --- 1 (weight 2)
        graph[0].add(new Edge(0, 1, 2));
        graph[1].add(new Edge(1, 0, 2));

        // 0 --- 2 (weight 4)
        graph[0].add(new Edge(0, 2, 4));
        graph[2].add(new Edge(2, 0, 4));

        // 1 --- 2 (weight 1)
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 1, 1));

        // 1 --- 3 (weight 3)
        graph[1].add(new Edge(1, 3, 3));
        graph[3].add(new Edge(3, 1, 3));

        // 2 --- 3 (weight 5)
        graph[2].add(new Edge(2, 3, 5));
        graph[3].add(new Edge(3, 2, 5));
    }

    public static void prims(ArrayList<Edge>[] graph, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[graph.length];
        int mcost = 0;
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                mcost += curr.cost;
            for (Edge e : graph[curr.node]) {
                if (!vis[e.dest]) {
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        }
        System.out.println("Minimum cost for this graph : " + mcost);
    }

    public static void main(String[] args) {
        int src = 0;
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        createGraph(graph);
        prims(graph, src);

    }
}