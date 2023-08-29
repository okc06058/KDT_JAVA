import java.util.Scanner;

public class A_DigitMachine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        for(int i = 0;i<10;i++){
            array[i] = sc.nextInt();
        }
        int k = 0;
        k = array[k];
        k = array[k];
        k = array[k];
        System.out.println(k);

	}

}
