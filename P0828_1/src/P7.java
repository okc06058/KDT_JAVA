
public class P7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[4][3]; // 4행 3열
		arr[2][1] = 10;
		arr[1][0] = 50;
		int cnt=0;
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr[x].length; y++) {
				arr[x][y]=cnt++;
			}
		}
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr[x].length; y++) {
				System.out.print(String.format("%3d", arr[x][y])+" ");
			}System.out.println("");
		}

	}

}


// Stack arr1[3][3] -> Hip 1중 배열 4개 2중 배열 3개씩
