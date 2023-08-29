import java.util.Scanner;

public class A_Jogging {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//A B C D E F X
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt();
		int D = sc.nextInt(), E = sc.nextInt(), F = sc.nextInt();
		int X = sc.nextInt();

		int takahashi = (X / (A + C)) * (B * A) + Math.min(X % (A + C), A) * B;
		int aoki = (X / (D + F)) * (E * D) + Math.min(X % (D + F), D) * E;

		if (takahashi > aoki) {
			System.out.println("Takahashi");
		} else if (aoki > takahashi) {
			System.out.println("Aoki");
		} else {
			System.out.println("Draw");
		}
	}
}
