import java.util.*;

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
