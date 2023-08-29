import java.util.Arrays;
import java.util.Scanner;

public class B_MinimizeOrdering {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();
		char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s = new String(chars); // 문자형 조합을 문자열로 만듬
 
        System.out.println(s);
	}

}
