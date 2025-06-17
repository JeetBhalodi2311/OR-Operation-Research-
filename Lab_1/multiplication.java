
import java.util.Scanner;

public class multiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length of 2D-array: ");
        int n = sc.nextInt(); 

        int[][] arr1 = new int[n][n];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                System.out.print("Enter element : ");
                arr1[i][j] = sc.nextInt();
            }
        }

        System.out.println("");

        int[][] arr2 = new int[n][n];

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                System.out.print("Enter element : ");
                arr2[i][j] = sc.nextInt();
            }
        }

        System.out.println("");

        int[][] result = new int[n][n]; 

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                result[i][j]=0;
                for (int k = 0; k < arr1.length; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println(" ");
        }


    }    
}
