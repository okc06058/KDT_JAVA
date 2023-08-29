import java.util.Scanner;

public class B_HitandBlow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
	    int[] a = new int[n];
	    int[] b = new int[n];
	    for(int i = 0; i < n; i++)
	    	a[i] = sc.nextInt();
	    for(int i = 0; i < n; i++) 
	    	b[i] = sc.nextInt();
	    
	    
		int hit = 0;
	    int blow = 0;

	    for(int i = 0; i < n; i++) {
	      for(int j = 0; j < n; j++) {
	        if(a[i] == b[j]) {
	          if(i == j) { hit++; }
	          else { blow++;}
	         // System.out.println(i+" "+ j);
	        }
	      }
	    }
	    System.out.println(hit+"\n"+ blow);
	}

}
