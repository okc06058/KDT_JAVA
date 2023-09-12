import java.util.Arrays;
import java.util.Scanner;

public class B_Pasta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		3 2
//		1 1 3
//		3 1
		
		
		Scanner sc = new Scanner(System.in);
		
		String input1 = sc.nextLine();
		String[] input1List = input1.split(" ");
		
		int n = Integer.parseInt(input1List[0]);
		int m = Integer.parseInt(input1List[1]);
		
		String input2 = sc.nextLine();
		String[] input2List = input2.split(" ");
		//Arrays.sort(input2List);
		
		int[] aList = new int[n];
		for(int x=0; x<n; x++) {
			aList[x] = Integer.parseInt(input2List[x]);
		}
		
		String input3 = sc.nextLine();
		String[] input3List = input3.split(" ");
		//Arrays.sort(input3List);
		
		int[] bList = new int[n];
		for(int x=0; x<m; x++) {
			bList[x] = Integer.parseInt(input3List[x]);
		}
		int check=0;
		for(int i = 0; i<m; i++) {
			for(int j = 0; j<n; j++) {
				if (aList[j]!=-1 && bList[i]==aList[j]) {
					check++;
					aList[j]=-1;
					break;
				}
				
			}
//			for(int j = 0; j<aList.length; j++) 
//				System.out.print(aList[j]+" ");
//			System.out.println("");
//			for(int j = 0; j<bList.length; j++) 
//				System.out.print(bList[j]+" ");
//			System.out.println("");
		}
		
		if(check==m) {System.out.println("Yes");}
		else { System.out.println("No");}
		
		
	}

}
