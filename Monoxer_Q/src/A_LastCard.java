import java.util.Scanner;

public class A_LastCard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input2 = sc.nextLine();
		String[] input2List = input2.split(" ");
		//Arrays.sort(input2List);
		
		int[] aList = new int[4];
		for(int x=0; x<3; x++) {
			aList[x] = Integer.parseInt(input2List[x]);
		}
		int ans = (aList[2]+aList[1]-1)%aList[0];
		if(ans == 0)ans =aList[0];
		System.out.println(ans);
	}

}
