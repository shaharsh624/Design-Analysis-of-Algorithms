import java.util.*;

/* class Graph {
    static class Edge{
        int src;
        int dest;

        Edge (int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        int[] weights = {1};

        for (int i=0 ; i<graph.length ; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,4));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,4));
    }
}
*/ 

public class Main {
    static void makeSet(int parent[], int rank[], int n) {
        for (int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    static int findParent(int parent[], int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = findParent(parent, parent[node]);
    }

    static void unionSet(int u, int v, int parent[], int[] rank) {
        u = findParent(parent, u);
        v = findParent(parent, v);

        if (rank[u] < rank[v]) {
            parent[u] = v;
        }
        else if (rank[u] < rank[v]) {
            parent[u] = v;
        }
        else {
            parent[v] = u;
            rank[u]++;
        }
    }

    static int minSpanTree(int [][] edges, int n){
        Arrays.sort(edges);
        int[] parent = new int[n];
        int[] rank = new int[n];
        makeSet(parent, rank, n);

        int minWeight = 0;

        for (int i=0; i<edges.length; i++) {
            int u = findParent(parent, edges[i][0]);
            int v = findParent(parent, edges[i][1]);
            int weight = edges[i][2];

            if (u != v) {
                minWeight += weight;
                unionSet(u, v, parent, rank);
            }
        }
        return minWeight;
    }
    public static void main(String[] args) {
        int [][] edges = {
            {7,6,1},
            {8,2,2},
            {6,5,2},
            {0,1,4},
            {2,5,4},
            {8,6,6},
            {2,3,7},
            {7,8,7},
            {0,7,8},
            {1,2,8},
            {3,4,9},
            {5,4,10},
            {1,7,11},
            {3,5,14}
    };
        int n=9;
        System.out.println(minSpanTree(edges, n));

    }

}

class Edge {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}



