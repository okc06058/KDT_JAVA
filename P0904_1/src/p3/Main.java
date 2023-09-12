package p3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 어노테이션 - @ - 깔끔하게 버리자
		TTT t1 = new TTT();
		t1.setV1(10);
	}

}

class TTT{
	private int v1;
	
	//메소드 문법
	
	//setter
	public void setV1(int v1) {
		this.v1 = v1;
	}
	
	//getter
	public int getV1() {
		return v1;
	}
}