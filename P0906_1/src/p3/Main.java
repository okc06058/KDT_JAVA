package p3;

import p2.AAA;
import p2.BBB;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BBB b1 = new BBB();	
		
		b1.text1();
	}

}

class AAA{
	int v1;
	int v2;
	AAA(){
		System.out.println("A 생성자1 호출");
	}
	void text1() {
		this.v2 = 10;
		System.out.println(this.v2);
	}
}

class BBB extends AAA{
	int v2;
	int v3;
	

	BBB(){
		System.out.println("B 생성자 1 호출");
	}
	
	
	BBB(int v3) {
		super(10);
		this.v2 = v3;
		System.out.println("B 생성자 2 호출");
	}
}
