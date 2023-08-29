import java.util.Scanner;

public class B_CountDistinctIntegers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
	
		int[] newArr = new int[10];
        for (int i = 0; i < 10; i++) {
            newArr[i] = 0;
        }
        for (int i = 0; i < n; i++) {
        	//int m = (])-40;
            newArr[arr[i]]++;
        }
        
        int cnt=0;
        for (int i = 0; i < 10; i++) {
            if(newArr[i]>0) {
            	cnt++;
            	//System.out.println(i);
            }
        }
        System.out.println(cnt);

	}

}
