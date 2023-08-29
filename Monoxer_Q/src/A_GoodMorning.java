import java.util.Scanner;

public class A_GoodMorning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt(), B = sc.nextInt();
		int C = sc.nextInt(), D = sc.nextInt(); 

		if (A < C) {
			System.out.println("Takahashi");
		} 
		
		else {
			if (A == C && B <= D) {
				System.out.println("Takahashi");
			} 
			else {
				System.out.println("Aoki");
			}
		}
	}

}
