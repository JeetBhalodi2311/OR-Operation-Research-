import java.util.Arrays;
import java.util.Scanner;

public class LeastCostMethod {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] costMatrix = new int[3][4];

        System.out.println("Enter Cost Matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                costMatrix[i][j] = sc.nextInt();
            }
        }

        int[] supply = new int[3];
        System.out.println("Enter Supply Matrix:");
        for (int i = 0; i < supply.length; i++) {
            supply[i] = sc.nextInt();
        }
        int[] demand = new int[4];
        System.out.println("Enter Demand Matrix:");
        for (int i = 0; i < demand.length; i++) {
            demand[i] = sc.nextInt();
        }

        int[][] allocation = new int[3][4];
        boolean[][] allocated = new boolean[3][4];  
        int totalCost = 0;

        while (Arrays.stream(supply).sum() > 0 && Arrays.stream(demand).sum() > 0) {
            int minCost = Integer.MAX_VALUE;
            int minRow = -1, minCol = -1;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    if (!allocated[i][j] && costMatrix[i][j] < minCost) {
                        minCost = costMatrix[i][j];
                        minRow = i;
                        minCol = j;
                    }
                }
            }

            int allocationValue = Math.min(supply[minRow], demand[minCol]);
            allocation[minRow][minCol] = allocationValue;
            totalCost += allocationValue * costMatrix[minRow][minCol];
            supply[minRow] -= allocationValue;
            demand[minCol] -= allocationValue;
            allocated[minRow][minCol] = true;

            if (supply[minRow] == 0) {
                for (int j = 0; j < 4; j++) {
                    allocated[minRow][j] = true;
                }
            }
            if (demand[minCol] == 0) {
                for (int i = 0; i < 3; i++) {
                    allocated[i][minCol] = true;
                }
            }
        }

        System.out.println("Allocation Matrix:");
        for (int[] row : allocation) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Total Cost: " + totalCost);
    }
}