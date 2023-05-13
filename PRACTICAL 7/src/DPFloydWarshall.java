import java.util.Scanner;
public class DPFloydWarshall {
    static int INF = 9999;

    static void floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] matrix = new int[V][V];
        for(int i = 0; i < V; i ++) {
            for(int j = 0; j < V; j ++) {
                matrix[i][j] = graph[i][j];
            }
        }
        for(int i = 0; i < V; i ++) {
            for(int j = 0; j < V; j ++) {
                for(int k = 0; k < V; k ++) {
                    if(matrix[j][k] > matrix[j][i] + matrix[i][k]) {
                        matrix[j][k] = matrix[j][i] + matrix[i][k];
                    }
                }
            }
        }
        printMatrix(matrix);
    }
    static void printMatrix(int[][] matrix) {
        System.out.println("Resultant Matrix using Floyd Warshall is: ");
        int V = matrix.length;

        for(int i = 0; i < V; i ++) {
            System.out.print("[ ");
            for(int j = 0; j < V; j ++) {
                if(matrix[i][j] == INF) {
                    System.out.print("∞ ");
                }
                else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input the Graph Matrix");
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        int graph[][] = new int[V][V];

        for (int i=0 ; i<V ; i++) {
            System.out.printf("Enter vertex from %d : ", (i+1));
            for (int j=0 ; j<V ; j++) {
                graph[i][j] =  sc.nextInt();
                if (graph[i][j] == 0) {
                    graph[i][j] = INF;
                }
            }
        }
        floydWarshall(graph);
        sc.close();
    }
}


