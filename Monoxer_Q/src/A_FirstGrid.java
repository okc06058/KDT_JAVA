import java.util.Scanner;

public class A_FirstGrid {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S1 = sc.next();
		String S2 = sc.next();
		if(S1.charAt(0)!=S1.charAt(1)){
			if(S2.charAt(0)!=S2.charAt(1)){
				System.out.println(S1.equals(S2)?"Yes":"No");
				return;
			}
		}
		System.out.println("Yes");

	}

}
