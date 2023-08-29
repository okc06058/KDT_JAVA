import java.util.Arrays;
import java.util.Collections;

public class P11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7,4,2,1,9,8};
		System.out.printf("주어진 값 : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		System.out.printf("\n"+"오름차순 정렬 : ");
		Arrays.sort(arr);// 오름차순
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		System.out.printf("\n"+"내림차순 정렬 : ");
		// 내림차순은 Integer타입 배열로 변경 해줘야 한다.
		Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		Arrays.sort(arr2, Collections.reverseOrder());// 내림차순
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr2[i]+" ");
		}
		
		
	}

}
