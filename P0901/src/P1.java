
public class P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 값의형태 : 변수 - 기본타입(실제값) / 참조타입(주소값)
		// 메모리사이클 : 변수 - 지역변수(stack) / 인스턴스변수(heap) / 클래스변수(Static)
		int a = 10;
		Test1 t1 = new Test1();
		t1.dol();
		
		System.out.println("프로그램 종료");
		
		
	}

}

class Test1 {
	void dol() {
		System.out.println("do1 호출");
		do2();
	}
	void do2() {
		System.out.println("do2 호출");
	}
}