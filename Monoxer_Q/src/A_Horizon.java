import java.util.Scanner;

public class A_Horizon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double h = sc.nextDouble();
		
		double a = h*(12800000.0 + h);
		System.out.printf("%.9f",Math.sqrt(a));

	}

}
