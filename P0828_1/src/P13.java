
public class P13 {

	public static void main(String[] args) {
		int[] arr = {7,4,2,1,9,8};
		System.out.printf("정렬 전 : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

		for(int i = 0; i < arr.length; i++) {
			for(int j = 0 ; j < arr.length - i - 1 ; j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		System.out.printf("\n정렬 후 : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

	}

}
