package p1;

public class Main {

	public static void main(String[] args) {
		// 상속 다형성 오버라이딩
		AAA a1 = new AAA();
		BBB b1 = new BBB();
		
	}
	
}

class AAA{
	int v1;
	int v2;
	
	void test1(){
		System.out.println("t1 호출");
	}
}

// 상속 문법 : !extand 상속받는 클래스명
class BBB extends AAA{
	int v3;
	int v4;
}

class CCC extends BBB{
	int c1;
	int c2;
}