package p14;

public class Main {

	public static void main(String[] args) {
		// 상속 다향성 오버라이딩
		 
		SCV s1 = new SCV();
		SCV s2 = new SCV();
		Marine m1 = new Marine();
		Tank t1 = new Tank();
		
//		
//		s1.move();
//		m1.move();
//		t1.move();
//		
//	
		Unit[] arr new Unit[12];
		arr[0] = new Marine();
		arr[1] = new SCV;
		}

}

class Unit{
	int hp;
	int ap;
	int speed;
	void move() {
		System.out.println("유닛이 "+speed+"로 움직입니다.");
	}
	void stop() {
		System.out.println("유닛이 멈춥니다.");
	}
	void attack() {
		System.out.println("유닛이 "+ap+"의 공격을 합니다.");
	}
}

class SCV extends Unit{
	SCV(){
		this.hp = 40;
		this.ap = 5;
		this.speed = 1;
	}
}

class Marine extends Unit{
	Marine(){
		this.hp = 50;
		this.ap = 10;
		this.speed = 2;
	}
}

class Tank extends Unit{
	Tank(){
		this.hp = 150;
		this.ap = 20;
		this.speed = 3;
	}
}