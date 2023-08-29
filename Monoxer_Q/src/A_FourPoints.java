import java.util.Scanner;

public class A_FourPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		Scanner sc = new Scanner(System.in);
		//		int x1 = sc.nextInt();
		//		int y1 = sc.nextInt();
		//		int x2 = sc.nextInt();
		//		int y2 = sc.nextInt();
		//		int x3 = sc.nextInt();
		//		int y3 = sc.nextInt();
		//		
		//		System.out.println((x1 ^ x2 ^ x3) + " " + (y1 ^ y2 ^ y3));
		// ^ XOR 비트 연산으로 구하는 방법 
		
		
		Scanner scanner = new Scanner(System.in);
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();
		int x3 = scanner.nextInt();
		int y3 = scanner.nextInt();

		int[] ans = new int[2];
		if (x1 == x2) {
			ans[0] = x3;
		} 
		else if (x1 == x3) {
			ans[0] = x2;
		} 
		else {
			ans[0] = x1;
		}

		if (y1 == y2) {
			ans[1] = y3;
		} 
		else if (y1 == y3) {
			ans[1] = y2;
		} 
		else {
			ans[1] = y1;
		}

		System.out.println(ans[0] + " " + ans[1]);
	}

}
