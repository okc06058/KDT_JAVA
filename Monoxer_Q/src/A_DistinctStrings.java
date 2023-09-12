import java.util.Collections;
import java.util.Scanner;

public class A_DistinctStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		//String[] inputList = input.split(" ");
		char[] inputList = input.toCharArray();
	
		int total = fact(input.length());
		int totalDou = 0;
		int tmpfact=0;
		int i=0;
		for(int x='a'; x<='z'; x++) {
			char ch = (char) (x+(i));
			String change1 = Character.toString(ch);
			boolean dou_check = input.contains(change1);
			if (dou_check) {
				int ck=0;
				tmpfact=0;
				for(int j=0; j<input.length(); j++) {
					if(inputList[j]==(ch)) {
						ck++;
					}
				}
				tmpfact = fact(ck);
			}
			totalDou *= tmpfact;
			i++;
		}
		
		System.out.println(total/tmpfact);
		
	}

	public static int fact(int n) {
		if (n <= 1)
			return n;
		else 
			return fact(n-1) * n;
	}

}
