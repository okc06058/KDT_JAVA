import java.util.Scanner;

public class A_OnandOff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//S T X
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt(), t = sc.nextInt(), x = sc.nextInt();
		
		if(s < t) {
			if(s <= x && x < t) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
		}else {
			if(x <t || s <= x) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
		}
	}

}
