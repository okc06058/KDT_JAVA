import java.util.Scanner;

public class A_Shampoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//V A B C    F M T
		Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int lest = v % (a + b + c);
        if(lest < a){
            System.out.println("F");
        }
        else if(lest < a + b){
            System.out.println("M");
        } 
        else {
            System.out.println("T");
        }
      
	}

}
