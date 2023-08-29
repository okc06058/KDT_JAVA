import java.util.Arrays;

public class P12 {

	static int[] nums;

	public static void main(String[] args) {
		int[] arr = {7,4,2,1,9,8};
		System.out.printf("정렬 전 : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}

		}

		System.out.printf("\n정렬 후 : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
