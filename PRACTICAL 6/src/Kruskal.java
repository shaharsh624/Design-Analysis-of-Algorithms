import java.util.*;

public class Kruskal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();

        Graph graph = new Graph(V, E);

        // Adding edges
        for (int i = 0; i < E; i++) {
            System.out.println("Enter the source, destination, and weight of edge " + (i + 1) + ":");
            graph.edges[i].src = sc.nextInt();
            graph.edges[i].dest = sc.nextInt();
            graph.edges[i].weight = sc.nextInt();
        }

        graph.kruskal();
        sc.close();
    }
}

class Graph {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public int compareTo(Edge other) {
            return weight - other.weight;
        }
    }

    int V, E;
    Edge[] edges;

    Graph(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < E; ++ i)
            edges[i] = new Edge();
    }

    int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    void kruskal() {
        Edge[] result = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++ i)
            result[i] = new Edge();

        Arrays.sort(edges);

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        i = 0;
        while (e < V - 1) {
            Edge next_edge = edges[i ++];
            int x = find(parent, next_edge.src);
            int y = find(parent, next_edge.dest);

            if (x != y) {
                result[e ++] = next_edge;
                union(parent, x, y);
            }
        }

        int finalWeight = 0;
        System.out.println("Edges in the MST :: ");
        for (i = 0; i < e; ++ i) {
            System.out.println(result[i].src + " - " + result[i].dest + ": " + result[i].weight);
            finalWeight = finalWeight + result[i].weight;
        }
        System.out.println("Total Weight of MST :: " + finalWeight);

    }
}
