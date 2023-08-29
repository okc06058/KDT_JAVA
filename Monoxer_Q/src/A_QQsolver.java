import java.util.Scanner;

public class A_QQsolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String input1 = sc.nextLine();

		char[] input1List = input1.toCharArray();

		int a = (int)(input1List[0])-'0';
		int b = (int)(input1List[2])-'0';
		
		System.out.println(a*b);
	}

}
