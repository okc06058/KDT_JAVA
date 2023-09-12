package P5;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// 날짜 숫자 문자
		Date d1 = new Date();
		System.out.println(d1);
		
		Date d2 = new Date(0);
		System.out.println(d2);
		
		Date d3 = new Date(97,4,4);
		System.out.println(d3);
		
		if(d1.after(d2)) {
			
		}
		System.out.println(d1.getMonth());
		
	}

}
