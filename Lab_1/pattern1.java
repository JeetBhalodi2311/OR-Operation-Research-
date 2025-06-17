
import java.util.Scanner;


public class pattern1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = n; i > 0; i--) {
            int num=1;
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }    
            
            for (int k = n; k >= i ; k--) {
                System.out.print(num);
                num++;    
            }
            for (int k = i; k <= n ; k++) {
                System.out.print(num);
                num++;    
            }
            System.out.println("");
        }
    }    
}
