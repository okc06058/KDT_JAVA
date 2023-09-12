
public class P5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SomeCompunent sc1 = SomeCompunent.getInstance();
		sc1.test();
		SomeCompunent sc2 = SomeCompunent.getInstance();
		sc2.test();
	}

}

class SomeCompunent{
	// 싱글톤 (디자인 패턴)
	private static final SomeCompunent instance = new SomeCompunent();
	
	private SomeCompunent() {
	}
	
	public static SomeCompunent getInstance() {
//		if(instance == null){
//			instance = new SomeCompunent();
//		}
		return instance;
	}
	
	
	//아래는 일반 코드
	//필드
	private int v1;
	//....
	
	//기능
	public void test() {
		System.out.println(v1);
	}
}