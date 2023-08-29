import java.util.Scanner;

public class A_NotOverflow {

	public static void main(String[] args) {
		// 정수 자료형 범위
		// int  −2^31 ~ 2^31−1
		// long -(2^63) ~ (2^63) -1​
		Scanner sc = new Scanner(System.in);
	    long n = sc.nextLong();
	    int a = (int)n;
	    String ans = "No";
	    if (a == n) {
	      ans = "Yes";
	    }
	    System.out.println(ans);

	}

}
