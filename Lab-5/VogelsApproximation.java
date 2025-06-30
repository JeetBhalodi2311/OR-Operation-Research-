import java.util.Arrays;
import java.util.Scanner;

public class VogelsApproximation {
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
        int totalCost = 0;

        while (Arrays.stream(supply).sum() > 0 && Arrays.stream(demand).sum() > 0) {
            int[] rowDiff = new int[3];
            int[] colDiff = new int[4];

            for (int i = 0; i < 3; i++) {
                if (supply[i] > 0) {
                    int[] sortedRow = Arrays.copyOf(costMatrix[i], 4);
                    Arrays.sort(sortedRow);
                    rowDiff[i] = sortedRow[1] - sortedRow[0];
                }
            }

            for (int j = 0; j < 4; j++) {
                int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
                for (int i = 0; i < 3; i++) {
                    if (demand[j] > 0 && costMatrix[i][j] < min1) {
                        min2 = min1;
                        min1 = costMatrix[i][j];
                    } else if (demand[j] > 0 && costMatrix[i][j] < min2) {
                        min2 = costMatrix[i][j];
                    }
                }
                colDiff[j] = min2 - min1;
            }

            int maxPenalty = -1, selectedRow = -1, selectedCol = -1;
            for (int i = 0; i < 3; i++) {
                if (supply[i] > 0 && rowDiff[i] > maxPenalty) {
                    maxPenalty = rowDiff[i];
                    selectedRow = i;
                    selectedCol = -1;
                }
            }

            for (int j = 0; j < 4; j++) {
                if (demand[j] > 0 && colDiff[j] > maxPenalty) {
                    maxPenalty = colDiff[j];
                    selectedCol = j;
                    selectedRow = -1;
                }
            }

            if (selectedRow != -1) {
                selectedCol = findMinCostCol(costMatrix[selectedRow], demand);
            } else {
                selectedRow = findMinCostRow(costMatrix, selectedCol, supply);
            }

            int allocationValue = Math.min(supply[selectedRow], demand[selectedCol]);
            allocation[selectedRow][selectedCol] = allocationValue;
            totalCost += allocationValue * costMatrix[selectedRow][selectedCol];
            supply[selectedRow] -= allocationValue;
            demand[selectedCol] -= allocationValue;
        }

        System.out.println("Allocation Matrix:");
        for (int[] row : allocation) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Total Cost: " + totalCost);
    }

    private static int findMinCostCol(int[] row, int[] demand) {
        int minCost = Integer.MAX_VALUE, minCol = -1;
        for (int j = 0; j < row.length; j++) {
            if (demand[j] > 0 && row[j] < minCost) {
                minCost = row[j];
                minCol = j;
            }
        }
        return minCol;
    }

    private static int findMinCostRow(int[][] costMatrix, int col, int[] supply) {
        int minCost = Integer.MAX_VALUE, minRow = -1;
        for (int i = 0; i < supply.length; i++) {
            if (supply[i] > 0 && costMatrix[i][col] < minCost) {
                minCost = costMatrix[i][col];
                minRow = i;
            }
        }
        return minRow;
    }
}