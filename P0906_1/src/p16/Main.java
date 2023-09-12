package p16;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AAA t = new TTT();
		t.test1();
	}

}

interface AAA{
	public abstract void test1();
	public void test2();
	abstract void test3();
	void test4();
}

class TTT implements AAA{
	public void test1() {
	}
	public void test2() {
	}
	public void test3() {
	}
	public void test4() {
	}
	
}