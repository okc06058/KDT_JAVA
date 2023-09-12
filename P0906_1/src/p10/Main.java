package p10;

public class Main {
	public static void main(String args[]) {
		AAA a1 = new BBB();
		
		a1.testA();
		
		if(a1 instanceof BBB) {
			BBB b1 = (BBB)a1;
			b1.testB();	
		}else {
			System.out.println("a1은 BBB 가 아니야");
		}
		
	}
}

class AAA{
	int a1;
	int a2;
	void testA(){
		
	}
}

class BBB extends AAA{
	int b1;
	int b2;
	void testB() {
		System.out.println("안녕");
	}
}