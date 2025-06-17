public class brut_force {
    public static void main(String[] args) {
        int temp=0,x1=0,x2=0;
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                int z = (3*i)+(2*j);
                if((i+j)<=4){
                    if(temp<z){
                        temp=z;
                        x1=i;
                        x2=j;
                    }
                }
            }
        }
        System.err.println("X1 : "+x1);
        System.err.println("X2 : "+x2);
        System.err.println("Z : "+temp);
    }
}
