package P4;

public class Main {

	public static void main(String[] args) {
		// system
		long time = System.currentTimeMillis();
	
		//System.out.println(time);
		
		int sum = 0;
		for(int x = 0; x<1000000; x++) {
			sum+=x;
		}
		System.out.println(sum);
		
		time = System.currentTimeMillis()-time;
		System.out.println(time);
		
		System.out.println(time/1000/60/60/24/365);
	}

}
