import java.util.Scanner;

public class A_WeirdFunction {
	
	private static int f(int t) {
        return t * t + 2 * t + 3;
    }
	
	public static void main(String[] args) {
		//f(x)=x^2+2*x+3
		//f(f(f(t)+t)+f(f(t)))
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		System.out.println(f(f(f(t)+t)+f(f(t))));
		
		
	}

}
