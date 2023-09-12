
public class P1 {

	public static void main(String[] args) {
		// RAM
		// stack -> 지역변수
		// heap -> new
		
		// 인스턴스 생성 문법 - 클래스 정의 형태로 메모리 생성(힙)
		// new 클래스명();
		StudentInfo a1 = new StudentInfo();
		StudentInfo a2 = new StudentInfo();
		
		a1.name = "한조";
		a1.age = 30;
		a1.score = 59;
		System.out.println(a1.name);
		
		a2.name = "트레이서";
		a2.age = 20;
		a2.score = 99;
		System.out.println(a2.name);
		
		a2=a1;
		a1.name = "안녕";
		System.out.println(a2.name);
		
		TestA testA = new TestA();
		testA.v1 = 10;
		
		testA.v2 = new TestB();	
		
		testA.v2.v1 = 30;
		
		String str = "";
		str.concat("").concat("").concat("");
	}

}


// 클래스 정의 문법 : class 클래스명{ ... }
// 클래스명 명명법 : 파스칼 케이스 - 첫글자 대문자로 시작. 명사
// 클래스 정의만으로는 아무것도 안됨.
class StudentInfo{
	//속성 : 인스턴스 변수, 멤버 변수
	String name;
	int age;
	int score;
	
	
	//생성자
	
	
	//기능
}

class TestA{
	int v1;
	TestB v2 ;//1= new TestB();
}

class TestB{
	int v1;
}