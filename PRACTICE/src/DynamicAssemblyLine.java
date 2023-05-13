public class DynamicAssemblyLine {
    public static void main(String[] args) {
        int[][] assembly = {
                {4, 5, 3, 2},
                {2, 10, 1, 4}
        };
        int[][] transition = {
                {0, 7, 4, 5},
                {0, 9, 2, 8}
        };
        int[] start = {10, 12};
        int[] end = {18, 7};

        scheduleAssembly(assembly, transition, start, end);
    }

    private static void scheduleAssembly(int[][] assembly, int[][] transition, int[] start, int[] end) {
        int n = assembly[0].length;

        int[] line1 = new int[n + 1];
        int[] line2 = new int[n + 1];
        int[][] trace = new int[n + 1][n + 1];

        line1[0] = start[0] + assembly[0][0];
        line2[0] = start[1] + assembly[1][0];

        for (int i = 1; i < n; i++) {
            if (line1[i - 1] + assembly[0][i] <= line2[i - 1] + transition[1][i] + assembly[0][i]) {
                line1[i] = line1[i - 1] + assembly[0][i];
                trace[0][i] = 1;
            }
            if (line1[i - 1] + assembly[0][i] > line2[i - 1] + transition[1][i] + assembly[0][i]) {
                line1[i] = line2[i - 1] + transition[1][i] + assembly[0][i];
                trace[0][i] = 2;
            }
            if (line2[i - 1] + assembly[1][i] <= line1[i - 1] + transition[0][i] + assembly[1][i]) {
                line2[i] = line2[i - 1] + assembly[1][i];
                trace[1][i] = 2;
            }
            if (line2[i - 1] + assembly[1][i] > line1[i - 1] + transition[0][i] + assembly[1][i]) {
                line2[i] = line1[i - 1] + transition[0][i] + assembly[1][i];
                trace[1][i] = 1;
            }
        }

        line1[n] = end[0] + line1[n - 1];
        line2[n] = end[1] + line2[n - 1];

        int last = 0;
        if (line1[n] <= line2[n]) {
            trace[0][n] = 1;
            trace[1][n] = 1;
            last = 1;
        } else {
            trace[0][n] = 2;
            trace[1][n] = 2;
            last = 2;
        }

        System.out.print("Optimal Assembly line: ");
        traceStation(trace, line1, line2, n, last);
        System.out.println("\n\nOptimal Time for assembly: " + Math.min(line1[n],line2[n]));
    }

    private static void traceStation(int[][] trace, int[] line1, int[] line2, int n, int last) {
        System.out.printf("\nLine %d -> Station %d", last, n);
        for (int i=n-1 ; i>0 ; i--) {
            last = trace[last-1][i];
            System.out.printf("\nLine %d -> Station %d", last,i);
        }
    }
}
