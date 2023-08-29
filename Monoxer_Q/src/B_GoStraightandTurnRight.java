import java.util.Scanner;

public class B_GoStraightandTurnRight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    char[] t = sc.next().toCharArray();
	    int [][] v = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
//	   0 1 0 동
//	   1 0 -1 남
//	   2 -1 0 서
//	   3 0 1 북
	    int x = 0;
	    int y = 0;
	    int ck_v = 0;
	    for (char i : t) {
	      if (i == 'S') {
	        x += v[ck_v][0];
	        y += v[ck_v][1];
	      } 
	      else {
	    	  ck_v = (ck_v + 1) % 4;
	      }
	    }
	    System.out.println(x + " " + y);

	}

}
