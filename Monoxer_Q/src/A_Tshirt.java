import java.util.Scanner;

public class A_Tshirt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//A B C X
		Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double x = sc.nextDouble();
        double ans = 0;
        if(x <= a){
            ans = 1;
        }else if(b < x){
            ans = 0;
        }else{
            ans = c / (b - a);
        }
        System.out.printf("%.12f",ans);  
	}
}
