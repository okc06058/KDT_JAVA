
public class P2 {

	public static void main(String[] args) {
		System.out.println("테스트 시작!!");

		Student s1 = new Student("한조", 50, 90);
//		s1.name = "트레";
//		s1.age = 20;
//		s1.score = 99;
		System.out.println("테스트 끝!!");
	}

}

class Student{
	// 속성(필드) : 인스턴스 변수
	String name;
	int age;
	int score;
	// 생성자
	// 생성자 선언 문법 : 클래스명(매개변수N...){...}
	// 인스턴스가 생성되면 실행
	// 일반적인 활용법 : 값의 초기화 용도
	Student(String name, int age, int score){
		this.name = name;
		this.age = age;
		this.score =score;
	}
	
	// 생성자 오버로딩 
	Student(String name, int age){
		this(name,age,0);
		
	}
}