import java.util.Scanner;

public class P14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// M~N까지 소수 구하기
		Scanner sc = new Scanner(System.in);
		System.out.printf("시작값과 끝값을 입력하세요. : ");
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] A = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            A[i] = i;
        }

        for (int i = 2; i <= N; i++) {
            if (A[i] == 0) {
                continue;
            }
            
            for (int j = i + i; j <= N; j = j + i) {
                A[j] = 0;
            } 
        }
        int cnt=0;
        for (int i = M; i <= N; i++) {
            if (A[i] != 0) {
            	cnt++;
                System.out.printf(A[i]+"\t");
                if (cnt%10==0) {
                	System.out.println("");
                }
            }
            
        }
	}

}
