import java.util.Scanner;

public class A_Rotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int xyz = sc.nextInt();
		
		int x = (int) Math.floor(xyz/100);
		int y = (int) Math.floor((xyz-(xyz/100)*100)/10);
		int z = (int) Math.floor((xyz-((xyz-(xyz/100)*100)/10)*10)%10);
		System.out.println((x*100+y*10+z)+(y*100+z*10+x)+(z*100+x*10+y));
	}

}
