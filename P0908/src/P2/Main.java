package P2;

public class Main {

	public static void main(String[] args) {
		// 가벼운 API들
		// String
		String str1 = "안녕하세요";
		String str2 = "안녕하세요";
		String str3 = new String("안녕하세요");
		if(str1==str2) {
			
		}
		String str4 = "Hello, 안녕, LOW";
		System.out.println(str4);
		
		str4 = str4.concat("aaa");//중요 코드 스타일
		
		System.out.println(str4);
		
		int qq = str4.length();
		
		int q1 = str4.indexOf("aa");
		System.out.println("aa 라는 글자는 "+q1+"번쨰");
		
		String searchWord = "hello";
		
		if(searchWord.toLowerCase().equals("hello".toLowcase()));
		
		// 메소드 체이닝 - 앞부터
		str4.trim().trim().trim().trim().trim().trim();
	
		// 아래는 매소드 체이닝 아님 - 안쪽 부터
		str4.lastIndexOf((int)Math.random());
		
		// 예제
		str4.trim().trim().trim().substring(str4.lastIndexOf(0)).trim().trim();
		
	}

}
