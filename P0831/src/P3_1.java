
public class P3_1 {

	public static void main(String[] args) {

		Car c1 = new Car("현대차",5,10);
		 	
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
	boolean run() {
		if(fuel <= 0) {
			System.out.println("Error. 기름이 없습니다. 기름을 채워 주세요.");
			return false;
		}
		
		System.out.println(name + "는 " + speed + "로 달립니다.");
		fuel--;
		return true;
	}
}

//int func1(int x) {
//	return x+1;
//}