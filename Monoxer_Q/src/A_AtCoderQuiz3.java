import java.util.Scanner;

public class A_AtCoderQuiz3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n<=41) {
			System.out.println("AGC"+String.format("%03d",n));
		}
		else System.out.println("AGC"+String.format("%03d",n+1));
	}

}
