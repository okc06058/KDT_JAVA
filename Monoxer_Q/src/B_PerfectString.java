import java.util.Arrays;
import java.util.Scanner;

public class B_PerfectString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		
		char[] arr = str.toCharArray();
		
		
		String[] checkList = new String[60];
		Arrays.fill(checkList, "0");
		
		int[] newArr = new int[60];
        for (int i = 0; i < checkList.length; i++) {
            newArr[i] = Integer.parseInt(checkList[i]);
        }
        
		boolean ck_a=false, ck_A=false, ck_double=false;
		
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>='a' && arr[i]<='z') {
				ck_a = true;
				newArr[arr[i]-'a']++;
				
			}
			else if(arr[i]>='A' && arr[i]<='Z') {
				ck_A = true;
				newArr[arr[i]-'A'+26]++;
			}
		}
		
		for(int i=0; i<newArr.length; i++) {
			if(newArr[i]>1) {
				ck_double = true;
				break;
			}
		}
		
		if(ck_a == true && ck_A == true && ck_double == false) {
			System.out.println("Yes");
		}
		else System.out.println("No");
	}

}
