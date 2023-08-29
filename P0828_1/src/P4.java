
public class P4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrOuter = null;
		{
			int[] arr1 = new int[5];
			int[] arr2 = new int[3];
			arrOuter = arr2;
			arrOuter[0]=20;
			
		}
		
		System.out.println(arrOuter[0]);
	}

}
