//import java.util.*;
//
//class Edge {
//    int src, dest, weight;
//
//    public Edge(int src, int dest, int weight) {
//        this.src = src;
//        this.dest = dest;
//        this.weight = weight;
//    }
//}
//
//class Subset {
//    int parent, rank;
//
//    public Subset(int parent, int rank) {
//        this.parent = parent;
//        this.rank = rank;
//    }
//}
//
//class Graph {
//    private int V, E;
//    private ArrayList<Edge> edges;
//
//    public Graph(int V, int E) {
//        this.V = V;
//        this.E = E;
//        this.edges = new ArrayList<>();
//    }
//
//    public void addEdge(int u, int v, int w) {
//        edges.add(new Edge(u, v, w));
//    }
//
//    private int find(Subset[] subsets, int i) {
//        if (subsets[i].parent != i)
//            subsets[i].parent = find(subsets, subsets[i].parent);
//
//        return subsets[i].parent;
//    }
//
//    private void union(Subset[] subsets, int x, int y) {
//        int xroot = find(subsets, x);
//        int yroot = find(subsets, y);
//
//        if (subsets[xroot].rank < subsets[yroot].rank)
//            subsets[xroot].parent = yroot;
//        else if (subsets[xroot].rank > subsets[yroot].rank)
//            subsets[yroot].parent = xroot;
//        else {
//            subsets[yroot].parent = xroot;
//            subsets[xroot].rank++;
//        }
//    }
//
//    public void kruskal() {
//        ArrayList<Edge> result = new ArrayList<>();
//        int i = 0, e = 0;
//        Collections.sort(edges, (a, b) -> a.weight - b.weight);
//
//        Subset[] subsets = new Subset[V];
//        for (int v = 0; v < V; v++) {
//            subsets[v] = new Subset(v, 0);
//        }
//
//        while (e < V - 1 && i < E) {
//            Edge next_edge = edges.get(i++);
//
//            int x = find(subsets, next_edge.src);
//            int y = find(subsets, next_edge.dest);
//
//            if (x != y) {
//                result.add(next_edge);
//                union(subsets, x, y);
//                e++;
//            }
//        }
//
//
//        int cost = 0;
//        System.out.println("Edges in MST:");
//        for (Edge edge : result) {
//            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
//            cost += edge.weight;
//        }
//
//        System.out.println(cost);
//    }
//}
//
//public class KruskalsAlgo {
//    public static void main(String[] args) {
//        int V = 4, E = 5;
//        Graph g = new Graph(V, E);
//
//        g.addEdge(0, 1, 1);
//        g.addEdge(0, 2, 1);
//        g.addEdge(0, 3, 2);
//        g.addEdge(1, 2, 4);
//        g.addEdge(2, 3, 3);
//
//        g.kruskal();
//    }
//}
