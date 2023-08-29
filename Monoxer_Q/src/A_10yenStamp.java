import java.util.Scanner;

public class A_10yenStamp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(), y = sc.nextInt();
		if (x>y) System.out.println("0");
		else {
			int num=(y-x)/10;
			if((y-x)%10==0) System.out.println(num);
			else System.out.println(num+1);
		}
	}

}
