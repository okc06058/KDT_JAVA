
public class P3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c1 = new Car("현대차",5,10);
		
		int a = c1.dosomeThing(10,2);//메서드 호출 문법
		System.out.println(a);
		a=c1.dosomeThing(5,3);
		System.out.println();
		
		
		c1.test(20); 
	}

}

class Car{
	//속성
	String name;
	int speed;
	int fuel;

	//생성자
	Car(String name, int speed, int fuel){
		this.name = name;
		this.speed = speed;
		this.fuel = fuel;
	}

	//기능 - 메서드
	// 메서드 정의 문법 : 리턴타입 메서드명 (...파라미터N){...}
	// 리턴타입 존재시 항상 그에 맞는 값을 리턴
	// 메서드명 명명법 : 카멜케이스 - 동사
	
	int dosomeThing(int a, int b) {
		
		this.test(b);//this 생략 가능
		
		if(a%2==1) {
			return -1;
		}
		
		System.out.println("-");
		return a+b;  //값을 리턴
	}
	
	void test(int a) {
		if(a<10) {
			return;  //탈출
		}
		System.out.println("테스트 호출됨");
	}
}

//int func1(int x) {
//	return x+1;
//}