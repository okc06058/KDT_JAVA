
public class P3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AAA a1 = new AAA();
		AAA a2 = new AAA();
		
		a1.v1 = 10;
		a2.v1 = 20;
		
		System.out.println(a1.v1);
		System.out.println(a2.v1);
		
		a1.v2 = 10;
		a2.v2 = 20;
		
		System.out.println(a1.v2);
		System.out.println(a2.v2);
		
		AAA.a = new AAA();
		a.v1 =20;
		AAA.v2 = 30;
		
		new
	}

}


//문법 static - 메소드 영역에 메모리 생성된다. 처음부터 1개 생성되고 프로그램 종료시까지 소멸X
// - 인스턴스 생성과 무관
class AAA{
	int v1;
	static int v2;
	int v3;
	
	void test1(){
		System.out.println("안녕1");
	}
	static void test1(int a) {
		System.out.println("안녕2");
	}
}

class Q1{
	void test1() {
		test2();
	}
	void test2() {
		test3();
	}
	void test3() {
		System.out.println("안녕하세요."+AAA.v2);
		AAA.v2=50;
	}
}