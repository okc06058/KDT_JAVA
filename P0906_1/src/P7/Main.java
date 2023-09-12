package P7;

public class Main {
	public static void main(String args[]) {
		// 다형성 = 참조변수는 자신의 타입을 포함해서 모든 자손을 받을 수 있다.
		
		
		AAA a = new AAA();
		//BBB b = new AAA();
		//int c = "안녕"
		
		double d = 1;// 타입 미스매치 - 타입 캐스팅이 발생한 경우

		//다형성의 경우
		AAA aaa;
		aaa = new AAA(); // 당연히 됨
		aaa = new BBB(); // 다형성
		
		BBB  bbb;
		bbb = new BBB(); // 당연히 됨
		//bbb = new AAA(); // 안됨
		
		//주의 사항
		AAA a1 = new AAA();
		AAA a2 = new BBB();
		BBB b1 = new BBB();
		
	}
}

class AAA{
	int a1;
	int a2;
	
	void printA() {
		System.out.println("프린트 A 출력");
	}
}


class BBB{
	int b1;
	int b2;
	
	void printB() {
		System.out.println("프린트 B 출력");
	}
}