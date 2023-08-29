import java.util.Arrays;
import java.util.Scanner;

public class A_chukodai {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
        char[] S = sc.next().toCharArray();
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        char tmp = S[a-1]; S[a-1]=S[b-1]; S[b-1]=tmp;
        for(int i = 0; i < S.length; i++){
        	System.out.print(S[i]);
        }
	}

}
