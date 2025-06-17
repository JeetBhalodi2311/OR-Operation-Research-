import java.util.Arrays;
import java.util.Scanner;

public class nort_west {
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

        int i=0,j=0,totalCost=0;

        while (i<supply.length && j<demand.length) { 
                
            int allocationValue = Math.min(supply[i], demand[j]);
            totalCost += allocationValue * costMatrix[i][j];
            allocation[i][j] = allocationValue;
            supply[i] -= allocationValue;
            demand[j] -= allocationValue;

            if (supply[i] == 0) i++;
            if (demand[j] == 0) j++;
        }

        System.out.println("Allocation Matrix:");
        for (int[] row : allocation) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Total Cost : "+totalCost);
    }    
}
