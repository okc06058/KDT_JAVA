import java.util.Scanner;

public class A_LackedNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char[] arr = s.toCharArray(); //String(문자열)을 char형 배열
	
		int[] newArr = new int[10];
        for (int i = 0; i < 9; i++) {
            newArr[i] = 0;
        }
        for (int i = 0; i < 9; i++) {
        	int n = (int)(arr[i]);
            newArr[n-48] = 1;
        }
      
        for (int i = 0; i < 9; i++) {
            if(newArr[i]==0) {
            	System.out.println(i);
            }
        }
	}

}
