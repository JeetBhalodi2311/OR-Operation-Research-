import java.util.*;

public class brut_force_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter No of tasks : ");
        int noOfTask = sc.nextInt();

        System.out.println("Enter No of servers : ");
        int servers = sc.nextInt();

        int[] timeOfTasks = new int[noOfTask];

        System.out.println("Enter time : ");
        for (int i = 0; i < noOfTask; i++) {
            timeOfTasks[i] = sc.nextInt();
        }

        int minMaxLoad = Integer.MAX_VALUE;
        int totalCombinations = (int) Math.pow(servers, noOfTask);

        for (int i = 0; i < totalCombinations; i++) {
            int[] taskToServer = toBaseKArray(i,  noOfTask); // 0, 0, 0
            int[] serverLoads = new int[servers];

            for (int j = 0; j < noOfTask; j++) {
                int server = taskToServer[j]; // 0
                serverLoads[server] += timeOfTasks[j]; // server[0] += 30
            }

            int maxLoad = Arrays.stream(serverLoads).max().getAsInt(); //60
            minMaxLoad = Math.min(minMaxLoad, maxLoad);//0
        }

        System.out.println("Minimum max load: " + minMaxLoad);
    }

    public static int[] toBaseKArray(int number, int length) {
        int[] arr = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            arr[i] = number % 2;
            number /= 2;
        }
        return arr;
    }
}


// https://github.com/KD3805/OR_Programs/blob/main/Lab%20-%202/P_2.java