public class GreedyActivitySelection {
    public static void main(String[] args) {
        int[] start = {1,3,0,5,5,8};
        int[] end = {2,4,6,7,9,9};
        int n = start.length;
        int i=0;
        sortArrays(start, end);
        System.out.println(start[0] + " -> " + end[0]);
        for (int j=1; j < n; j++) {
            if (start[j] >= end[i]) {
                System.out.println(start[j] + " -> " + end[j]);
                i=j;
            }
        }
    }

    private static void sortArrays(int[] start, int[] end) {
        int flag = 1;
        for (int i = 0; i < start.length - 1; i++) {
            for (int j = 0; j < start.length - 1; j++) {
                if (end[j] > end[j + 1]) {
                    int temp1 = end[j];
                    end[j] = end[j + 1];
                    end[j + 1] = temp1;

                    int temp2 = start[j];
                    start[j] = start[j + 1];
                    start[j + 1] = temp2;

                    flag = 0;
                }
            }
            if (flag == 1) {
                break;
            }
        }
    }
}
