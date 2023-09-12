package p2;

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
	
	
	void text2() {
		this. v1=10
		super.v2 = 30;
		this.v2 = 20;
		System.out.println(this.v2);
	}
}
