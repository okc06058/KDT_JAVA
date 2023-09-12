package P3;

import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "qwertffff";
		
		for (int x = 0 ; x < str1.length(); x++) {
			char r = str1.charAt(x);
		}
		
		//정규표현식
		String inputPassword = "qwer111233";
		String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

		
		Pattern.compile(regex).matcher(inputPassword);
		if(Pattern.compile(regex).matcher(inputPassword).matches()) {
			System.out.println("사용 가능한 정상적인 비밀번호");
		}else {
			System.out.println("영문..숫자... 8글자 이상... 이어야합니다.");
		}
		
		int a = 8;
		int b = 7;
		
		String result = a + "X" + b + " = " + (a*b);
		System.out.println(result);
		
		String result2 = String.format("%d X %d = %d", a, b, (a*b));
		System.out.println(result2);
	
		String result3 = String.format("%d 안녕 %f 야호 %s", 1, 3.3, "헬로우");
		System.out.println(result3);
		
		double c = 123.456789;
		String result4 = String.format("안녕 %.2f 헬로", c);
		System.out.println(result4);
	}

}
