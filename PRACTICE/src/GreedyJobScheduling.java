public class GreedyJobScheduling {
    public static void main(String[] args) {
        int[] profits = {10, 5, 1, 15, 20};
        int[] deadline = {1, 3, 3, 2, 2};
        int maxDeadline = 3;
        System.out.println("\nTotal Profit: " + scheduleJob(profits, deadline, maxDeadline));
    }

    private static int scheduleJob(int[] profits, int[] deadline, int maxDeadline) {
        int profit = 0;
        boolean[] scheduled = new boolean[maxDeadline + 1];

        sortArrays(profits, deadline);

        for(int i=0 ; i<deadline.length ; i++){
            int job = deadline[i];
            if (!scheduled[job]) {
                scheduled[job] = true;
                profit += profits[i];
                System.out.printf("\nJob with profit %d scheduled in %d-%d.", profits[i], job-1, job);
            } else {
                for (int j = job - 1; j > 0; j--) {
                    if (!scheduled[j]) {
                        scheduled[j] = true;
                        profit += profits[i];
                        System.out.printf("\nJob with profit %d scheduled in %d-%d.",profits[i], (j-1), j);
                        break;
                    }
                }
            }
        }
        return profit;
    }

    private static void sortArrays(int[] profits, int[] deadline) {
        int temp1;
        int temp2;
        int flag = 1;
        for (int i = 0; i < profits.length - 1; i++) {
            for (int j = 0; j < profits.length - i - 1; j++) {
                if (profits[j] < profits[j + 1]) {
                    temp1 = profits[j];
                    profits[j] = profits[j + 1];
                    profits[j + 1] = temp1;

                    temp2 = deadline[j];
                    deadline[j] = deadline[j + 1];
                    deadline[j + 1] = temp2;

                    flag = 0;
                }
            }
            if (flag == 1) {
                break;
            }
        }
    }
}




