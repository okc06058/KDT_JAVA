import java.util.Scanner;

public class B_Slimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String input1 = sc.nextLine();
		String[] input1List = input1.split(" ");

		int a = Integer.parseInt(input1List[0]);
		int b = Integer.parseInt(input1List[1]);
		int k = Integer.parseInt(input1List[2]);

		int count = 0;

		if (a>=b) {System.out.println("0");}
		else {
			while (true) {
				count++;
				if(a*k>=b) {break;}
				else {a=a*k;}
			}
			System.out.println(count);
		}
	}

}
