import java.text.Format;
import java.util.Scanner;

public class A_Water_Pressure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double d = sc.nextDouble();
		if(d%100==0) {
			String num = String.format("%.0f",d/100);
			System.out.println(num);
		}
		else System.out.println((d/100));
	}

}
