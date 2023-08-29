
public class P10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 일반 반복
		int[] arr = {5,3,2,2,7};
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("===========");
		// 향상된 for문(foreach) 문
		for(int element : arr) {
			System.out.println(element);
		}
		
	}

}
