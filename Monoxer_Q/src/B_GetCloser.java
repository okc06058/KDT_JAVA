import java.util.Scanner;

public class B_GetCloser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		double z = Math.sqrt((double)(x*x + y*y)); // 피타고라스 한 변
		System.out.printf("%.12f %.12f",x/z,y/z);
	}

}
